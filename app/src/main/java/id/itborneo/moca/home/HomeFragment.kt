package id.itborneo.moca.home

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import id.itborneo.core.domain.model.HomeItemModel
import id.itborneo.core.enums.Status
import id.itborneo.moca.R
import id.itborneo.moca.databinding.FragmentHomeBinding
import id.itborneo.moca.detail.views.DetailMovieActivity
import id.itborneo.moca.detail.views.DetailSeriesActivity
import org.koin.android.viewmodel.ext.android.sharedViewModel


class HomeFragment : Fragment(R.layout.fragment_home) {

    companion object {
        private const val TAG = "HomeFragment"
    }

    private lateinit var trendingMovieAdapter: HomeAdapter
    private lateinit var trendingSeriesAdapter: HomeAdapter

    private lateinit var playingNowMovieAdapter: HomeAdapter
    private lateinit var airingTodaySeriesAdapter: HomeAdapter

    private val binding: FragmentHomeBinding by viewBinding(FragmentHomeBinding::bind)

    private val viewModel: HomeViewModel by sharedViewModel()

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
        viewModel.getAiringTodaySeries().observe(viewLifecycleOwner) {
            when (it.status) {
                Status.SUCCESS -> {
                    if (it.data != null) {
                        val data = it.data
                        val items = data?.map { model ->
                            HomeItemModel(model.id, model.posterPath)
                        }
                        if (items != null) {
                            airingTodaySeriesAdapter.set(items)
                        }
                    }
                    showLoading(binding.incAiringTodaySeriesLoading.root, false)
                }
                Status.LOADING -> {
                    showLoading(binding.incAiringTodaySeriesLoading.root)
                }
                Status.ERROR -> {
                    showLoading(binding.incAiringTodaySeriesLoading.root, false)

                    Log.e(TAG, "${it.status}, ${it.message} and ${it.data}")
                    showError()

                }
            }
        }
    }

    private fun observerNowPlayingMovies() {
        viewModel.getNowPlayingMovies().observe(viewLifecycleOwner) {
            when (it.status) {
                Status.SUCCESS -> {
                    if (it.data != null) {
                        val data = it.data
                        val items = data?.map { model ->
                            HomeItemModel(
                                model.id, model.posterPath
                            )
                        }
                        if (items != null) {
                            playingNowMovieAdapter.set(items)
                        }
                    }
                    showLoading(binding.incNowPlayingMoviesLoading.root, false)
                }
                Status.LOADING -> {
                    showLoading(binding.incNowPlayingMoviesLoading.root)
                }
                Status.ERROR -> {
                    showLoading(binding.incNowPlayingMoviesLoading.root, false)
                    Log.e(TAG, "${it.status}, ${it.message} and ${it.data}")
                    showError()

                }
            }
        }
    }

    private fun observerTrendingSeries() {
        viewModel.getTrendingSeries().observe(viewLifecycleOwner) {
            when (it.status) {
                Status.SUCCESS -> {
                    if (it.data != null) {
                        val data = it.data
                        val items = data?.map { model ->
                            HomeItemModel(
                                model.id, model.posterPath
                            )
                        }
                        if (items != null) {
                            trendingSeriesAdapter.set(items)
                        }
                    }
                    showLoading(binding.incTrendingSeriesLoading.root, false)
                }
                Status.LOADING -> {
                    showLoading(binding.incTrendingSeriesLoading.root)
                }
                Status.ERROR -> {
                    showError()
                    Log.e(TAG, "${it.status}, ${it.message} and ${it.data}")
                    showLoading(binding.incTrendingSeriesLoading.root, true)


                }
            }
        }
    }

    private fun observerTrendingMovies() {
        viewModel.getTrendingMovies().observe(viewLifecycleOwner) {
            when (it.status) {
                Status.SUCCESS -> {
                    if (it.data != null) {
                        val data = it.data
                        val items = data?.map { model ->
                            HomeItemModel(
                                model.id, model.posterPath
                            )
                        }
                        if (items != null) {
                            trendingMovieAdapter.set(items)
                        }
                    }
                    showLoading(binding.incTrendingMoviesLoading.root, false)
                }
                Status.LOADING -> {
                    showLoading(binding.incTrendingMoviesLoading.root)
                }
                Status.ERROR -> {
                    showLoading(binding.incTrendingMoviesLoading.root, false)
                    Log.e(TAG, "${it.status}, ${it.message} and ${it.data}")
                    showError()
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

    private fun showLoading(loadingView: ViewGroup, showIt: Boolean = true) {
        loadingView.apply {
            visibility = if (showIt) {
                View.VISIBLE
            } else {
                View.GONE
            }
        }
    }

    private fun showError(showIt: Boolean = true) {
        binding.incError.root.apply {
            visibility = if (showIt) {
                View.VISIBLE
            } else {
                View.GONE
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.root.removeAllViews()
    }
}