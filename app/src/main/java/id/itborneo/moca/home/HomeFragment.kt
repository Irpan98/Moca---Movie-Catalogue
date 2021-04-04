package id.itborneo.moca.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.itborneo.moca.core.enums.Status
import id.itborneo.moca.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private val TAG = "HomeFragment"
    private lateinit var trendingMovieAdapter: HomeAdapter
    private lateinit var trendingSeriesAdapter: HomeAdapter

    private lateinit var binding: FragmentHomeBinding

    private val viewModel: HomeViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecycler()
        observerData()
    }

    private fun observerData() {

        observerTrendingMovies()
        observerTrendingSeries()
        observerNowPlayingMovies()
        observerNowPlayingSeries()
    }

    private fun observerNowPlayingSeries() {
        viewModel.getTrendingSeries().observe(viewLifecycleOwner) {
            when (it.status) {
                Status.SUCCESS -> {
                    if (it.data != null) {
                        val result = it.data.results
                        if (result != null) {
                            trendingSeriesAdapter.set(result)
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

    private fun observerNowPlayingMovies() {
        viewModel.getNowPlayingMovies().observe(viewLifecycleOwner) {
            when (it.status) {
                Status.SUCCESS -> {
                    if (it.data != null) {
                        val result = it.data.results
                        if (result != null) {
                            trendingSeriesAdapter.set(result)
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

    private fun observerTrendingSeries() {
        viewModel.getNowPlayingSeries().observe(viewLifecycleOwner) {
            when (it.status) {
                Status.SUCCESS -> {
                    if (it.data != null) {
                        val result = it.data.results
                        if (result != null) {
                            trendingSeriesAdapter.set(result)
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

    private fun observerTrendingMovies() {
        viewModel.getTrendingMovies().observe(viewLifecycleOwner) {
            when (it.status) {
                Status.SUCCESS -> {
                    if (it.data != null) {
                        val result = it.data.results
                        if (result != null) {
                            trendingMovieAdapter.set(result)
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
        binding.rvHomeMovies.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        trendingMovieAdapter = HomeAdapter {
//            actionToDetail(it)
        }
        binding.rvHomeMovies.adapter = trendingMovieAdapter

        binding.rvHomeSeries.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        trendingSeriesAdapter = HomeAdapter {
//            actionToDetail(it)
        }
        binding.rvHomeSeries.adapter = trendingSeriesAdapter


    }
}