package id.itborneo.moca.favorite.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import id.itborneo.moca.core.data.local.database.enitity.FavoriteMovieEntity
import id.itborneo.moca.databinding.FragmentFavoriteMovieBinding
import id.itborneo.moca.detail.views.DetailMovieActivity
import id.itborneo.moca.favorite.adapters.FavoriteMoviePagedAdapter
import id.itborneo.moca.favorite.viewmodels.FavoriteMovieViewModel
import org.koin.android.viewmodel.ext.android.sharedViewModel


class FavoriteMovieFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteMovieBinding
    private val viewModel: FavoriteMovieViewModel by sharedViewModel()
    private lateinit var adapter: FavoriteMoviePagedAdapter

    private val isEmpty = MutableLiveData(true)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecycler()
        observerData()
        observerIsEmpty()
    }

    private fun observerIsEmpty() {
        isEmpty.observe(viewLifecycleOwner) {
            showEmptyFavorite(it)
        }
    }

    private fun showEmptyFavorite(showIt: Boolean) {
        if (showIt) {
            binding.incEmptyFavorite.root.visibility = View.VISIBLE
        } else {
            binding.incEmptyFavorite.root.visibility = View.GONE
        }
    }

    private fun observerData() {
        viewModel.getMovies().observe(viewLifecycleOwner) {

            isEmpty.value = it.size == 0
            adapter.submitList(it)
        }
    }

    private fun initRecycler() {
        binding.rvMovies.layoutManager = LinearLayoutManager(requireContext())
        adapter = FavoriteMoviePagedAdapter {
            actionToDetail(it)
        }
        binding.rvMovies.layoutManager = GridLayoutManager(context, 3)
        binding.rvMovies.adapter = adapter
    }

    private fun actionToDetail(movie: FavoriteMovieEntity) {
        DetailMovieActivity.getInstance(requireContext(), movie.id)
    }
}