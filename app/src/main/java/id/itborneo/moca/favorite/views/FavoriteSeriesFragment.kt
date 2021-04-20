package id.itborneo.moca.favorite.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import id.itborneo.moca.core.local.enitity.FavoriteSeriesEntity
import id.itborneo.moca.databinding.FragmentFavoriteSeriesBinding
import id.itborneo.moca.detail.DetailSeriesActivity
import id.itborneo.moca.favorite.adapters.FavoriteSeriesPagedAdapter
import id.itborneo.moca.favorite.adapters.FavoriteSeriesAdapter
import id.itborneo.moca.favorite.viewmodels.FavoriteSeriesViewModel
import org.koin.android.viewmodel.ext.android.sharedViewModel


class FavoriteSeriesFragment : Fragment() {

    companion object {
        private const val TAG = "SeriesFragment"
    }

    private lateinit var binding: FragmentFavoriteSeriesBinding
    private lateinit var adapter: FavoriteSeriesPagedAdapter

    private val viewModel: FavoriteSeriesViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteSeriesBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        observerData()
    }

    private fun observerData() {
        viewModel.getSeries().observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    private fun initRecycler() {
        binding.rvSeries.layoutManager = LinearLayoutManager(requireContext())
        adapter = FavoriteSeriesPagedAdapter {
            actionToDetail(it)
        }
        binding.rvSeries.layoutManager = GridLayoutManager(context, 3)
        binding.rvSeries.adapter = adapter
    }

    private fun actionToDetail(series: FavoriteSeriesEntity) {
        val id = series.id
        DetailSeriesActivity.getInstance(requireContext(), id)
    }
}