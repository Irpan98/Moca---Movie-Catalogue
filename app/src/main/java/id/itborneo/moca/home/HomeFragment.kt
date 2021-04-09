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
import id.itborneo.moca.core.model.HomeItemModel
import id.itborneo.moca.databinding.FragmentHomeBinding
import id.itborneo.moca.detail.DetailMovieActivity
import id.itborneo.moca.detail.DetailSeriesActivity


class HomeFragment : Fragment() {

    private val TAG = "HomeFragment"
    private lateinit var trendingMovieAdapter: HomeAdapter
    private lateinit var trendingSeriesAdapter: HomeAdapter

    private lateinit var playingNowMovieAdapter: HomeAdapter
    private lateinit var airingTodaySeriesAdapter: HomeAdapter

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

    private fun initRecycler() {

        initRecyclerviewTrendingMovie()
        initRecyclerviewTrendingSeries()

        initRecyclerviewPlayingMovie()
        initRecyclerviewAiringToday()
    }

    private fun initRecyclerviewAiringToday() {

        binding.rvAiringTodaySeries.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        airingTodaySeriesAdapter = HomeAdapter {
            actionToDetailSeries(it.id)
        }
        binding.rvAiringTodaySeries.adapter = airingTodaySeriesAdapter
    }

    private fun initRecyclerviewPlayingMovie() {
        binding.rvNowPlayingMovies.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        playingNowMovieAdapter = HomeAdapter {
            actionToDetailMovie(it.id)
        }
        binding.rvNowPlayingMovies.adapter = playingNowMovieAdapter
    }

    private fun initRecyclerviewTrendingSeries() {

        binding.rvHomeSeries.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        trendingSeriesAdapter = HomeAdapter {
            actionToDetailSeries(it.id)
        }
        binding.rvHomeSeries.adapter = trendingSeriesAdapter
    }

    private fun initRecyclerviewTrendingMovie() {
        binding.rvHomeMovies.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        trendingMovieAdapter = HomeAdapter {
            actionToDetailMovie(it.id)
        }
        binding.rvHomeMovies.adapter = trendingMovieAdapter
    }

    private fun observerData() {

        observerTrendingMovies()
        observerTrendingSeries()
        observerNowPlayingMovies()
        observerAiringTodaySeries()
    }

    private fun observerAiringTodaySeries() {
        viewModel.getAiringTodaySeries().observe(viewLifecycleOwner) { it ->
            when (it.status) {
                Status.SUCCESS -> {
                    if (it.data != null) {
                        val result = it.data.results
                        if (result != null) {
                            val items = result.map { model ->
                                HomeItemModel(
                                    model.id, model.posterPath
                                )
                            }
                            airingTodaySeriesAdapter.set(items)
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
                            val items = result.map { model ->
                                HomeItemModel(
                                    model.id, model.posterPath
                                )
                            }
                            playingNowMovieAdapter.set(items)
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
        viewModel.getTrendingSeries().observe(viewLifecycleOwner) {
            when (it.status) {
                Status.SUCCESS -> {
                    if (it.data != null) {
                        val result = it.data.results
                        if (result != null) {
                            val items = result.map { model ->
                                HomeItemModel(
                                    model.id, model.posterPath
                                )
                            }
                            trendingSeriesAdapter.set(items)
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
                            val items = result.map { model ->
                                HomeItemModel(
                                    model.id, model.posterPath
                                )
                            }
                            trendingMovieAdapter.set(items)
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

    private fun actionToDetailMovie(id: Int?) {
        if (id != null) {
            DetailMovieActivity.getInstance(requireContext(), id)
        }
    }

    private fun actionToDetailSeries(id: Int?) {
        if (id != null) {
            DetailSeriesActivity.getInstance(requireContext(), id)
        }
    }
}