package id.itborneo.mocafavorite.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import id.itborneo.core.domain.model.SeriesDomainModel
import id.itborneo.moca.databinding.FragmentFavoriteSeriesBinding
import id.itborneo.moca.detail.views.DetailSeriesActivity
import id.itborneo.mocafavorite.adapters.FavoriteSeriesPagedAdapter
import id.itborneo.mocafavorite.viewmodels.FavoriteSeriesViewModel
import org.koin.android.viewmodel.ext.android.sharedViewModel


class FavoriteSeriesFragment : Fragment() {

    private var binding: FragmentFavoriteSeriesBinding? = null


    private lateinit var adapter: FavoriteSeriesPagedAdapter

    private val viewModel: FavoriteSeriesViewModel by sharedViewModel()
    private val isEmpty = MutableLiveData(true)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoriteSeriesBinding.inflate(inflater, container, false)
        return binding?.root
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
        binding?.apply {
            if (showIt) {
                incEmptyFavorite.root.visibility = View.VISIBLE
            } else {
                incEmptyFavorite.root.visibility = View.GONE
            }
        }

    }

    private fun observerData() {
        viewModel.getSeries().observe(viewLifecycleOwner) {

            isEmpty.value = it.size == 0
            adapter.submitList(it)
        }
    }

    private fun initRecycler() {
        binding?.apply {
            rvSeries.layoutManager = LinearLayoutManager(requireContext())
            adapter = FavoriteSeriesPagedAdapter {
                actionToDetail(it)
            }
            rvSeries.layoutManager = GridLayoutManager(context, 3)
            rvSeries.adapter = adapter
        }
    }

    private fun actionToDetail(series: SeriesDomainModel) {
        val id = series.id
        DetailSeriesActivity.getInstance(requireContext(), id)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}