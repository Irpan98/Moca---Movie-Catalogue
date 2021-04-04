package id.itborneo.moca.movie

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import id.itborneo.moca.core.enums.Status
import id.itborneo.moca.core.model.MovieModel
import id.itborneo.moca.databinding.FragmentMovieBinding
import id.itborneo.moca.detail.DetailActivity

class MovieFragment : Fragment() {


    companion object {
        private const val TAG = "MovieFragment"
    }

    private lateinit var binding: FragmentMovieBinding
    private lateinit var adapter: MovieAdapter

    private val viewModel: MovieViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
//        initNav(view)
        observerData()
    }

    private fun observerData() {
        viewModel.getMovies().observe(viewLifecycleOwner) {
            when (it.status) {
                Status.SUCCESS -> {
                    if (it.data != null) {
                        val result = it.data.results
                        if (result != null) {
                            adapter.set(result)
                        }
                    }
//                    showLoading(false)
                }
                Status.LOADING -> {
//                    showLoading(true)
                }
                Status.ERROR -> {
                    Log.e(TAG, "${it.status}, ${it.message} and ${it.data}")
                }
            }
        }
    }

    private fun initRecycler() {
        binding.rvMovies.layoutManager = LinearLayoutManager(requireContext())
        adapter = MovieAdapter {
            actionToDetail(it)
        }
        binding.rvMovies.layoutManager = GridLayoutManager(context, 3)
        binding.rvMovies.adapter = adapter
    }

    private fun actionToDetail(movie: MovieModel) {
        DetailActivity.getInstance(requireContext(), movie)
    }


}