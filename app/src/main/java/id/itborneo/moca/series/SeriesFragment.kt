package id.itborneo.moca.series

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
import id.itborneo.moca.core.factory.ViewModelFactory
import id.itborneo.moca.core.model.SeriesModel
import id.itborneo.moca.core.repository.MocaRepository
import id.itborneo.moca.databinding.FragmentSeriesBinding
import id.itborneo.moca.detail.DetailSeriesActivity


class SeriesFragment : Fragment() {

    companion object {
        private const val TAG = "MovieFragment"
    }

    private lateinit var binding: FragmentSeriesBinding
    private lateinit var adapter: SeriesAdapter

    private val viewModel: SeriesViewModel by viewModels {
        val repo = MocaRepository
        ViewModelFactory(repo)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSeriesBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        observerData()
    }

    private fun observerData() {
        viewModel.getSeries().observe(viewLifecycleOwner) {
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
        binding.rvSeries.layoutManager = LinearLayoutManager(requireContext())
        adapter = SeriesAdapter {
            actionToDetail(it)
        }
        binding.rvSeries.layoutManager = GridLayoutManager(context, 3)
        binding.rvSeries.adapter = adapter
    }

    private fun actionToDetail(series: SeriesModel) {
        val id = series.id
        if (id != null) {
            DetailSeriesActivity.getInstance(requireContext(), id)
        }
    }
}