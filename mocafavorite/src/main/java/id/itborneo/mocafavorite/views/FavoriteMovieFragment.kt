package id.itborneo.mocafavorite.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import id.itborneo.core.domain.model.MovieDomainModel
import id.itborneo.moca.databinding.FragmentFavoriteMovieBinding
import id.itborneo.moca.detail.views.DetailMovieActivity
import id.itborneo.mocafavorite.adapters.FavoriteMoviePagedAdapter
import id.itborneo.mocafavorite.viewmodels.FavoriteMovieViewModel
import org.koin.android.viewmodel.ext.android.sharedViewModel


class FavoriteMovieFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteMovieBinding
    private lateinit var adapter: FavoriteMoviePagedAdapter
    private val viewModel: FavoriteMovieViewModel by sharedViewModel()
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

    private fun actionToDetail(movie: MovieDomainModel) {
        DetailMovieActivity.getInstance(requireContext(), movie.id)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.root.removeAllViews()
    }
}