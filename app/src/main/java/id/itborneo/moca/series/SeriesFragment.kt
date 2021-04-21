package id.itborneo.moca.series

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import id.itborneo.moca.core.enums.Status
import id.itborneo.moca.core.model.SeriesModel
import id.itborneo.moca.databinding.FragmentSeriesBinding
import id.itborneo.moca.detail.DetailSeriesActivity
import org.koin.android.viewmodel.ext.android.sharedViewModel


class SeriesFragment : Fragment() {

    companion object {
        private const val TAG = "SeriesFragment"
    }

    private lateinit var binding: FragmentSeriesBinding
    private lateinit var adapter: SeriesAdapter

    private val viewModel: SeriesViewModel by sharedViewModel()

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
        initSearch()

        observerData()
        observerSearch()
    }


    private fun observerData() {
        viewModel.getSeries().observe(viewLifecycleOwner) {
            when (it.status) {
                Status.SUCCESS -> {
                    if (it.data != null) {
                        val result = it.data.results
                        if (result != null) {
                            if (result.isNotEmpty()) {
                                adapter.set(result)
                            } else {
                                showError()
                            }
                        } else {
                            showError()
                        }
                    }
                    showLoading(false)
                }
                Status.LOADING -> {
                    showLoading(true)
                }
                Status.ERROR -> {
                    Log.e(TAG, "${it.status}, ${it.message} and ${it.data}")
                    showLoading(false)
                    showError()
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

    private fun showLoading(showIt: Boolean = true) {
        binding.incLoading.root.apply {
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

    private fun initSearch() {
        binding.sbUsers.apply {
            setOnClickListener {
                onActionViewExpanded()
            }
            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    if (newText != null && newText.isNotEmpty()) {
                        viewModel.setSearch(newText)
                    } else {
                        viewModel.initSeries()
                    }
                    return true
                }
            })

            setOnCloseListener {
                viewModel.initSeries()
                true
            }

        }
    }

    private fun observerSearch() {
        viewModel.getSearched().observe(viewLifecycleOwner) {
            when (it.status) {
                Status.SUCCESS -> {
                    showLoading(false)

                    if (it.data != null) {
                        val result = it.data.results
                        if (!result.isNullOrEmpty()) {
                            showNotFound(false)
                            adapter.set(result)
                        } else {
                            showNotFound()
                        }
                    } else {
                        showError()
                    }
                }
                Status.LOADING -> {
                    showLoading(true)
                }
                Status.ERROR -> {
                    showLoading(false)
                    showError()
                    Log.e(TAG, "${it.status}, ${it.message} and ${it.data}")
                }
            }
        }

    }

    private fun showNotFound(showIt: Boolean = true) {
        if (showIt) {
            binding.incNotFound.root.visibility = View.VISIBLE
            binding.rvSeries.visibility = View.GONE
        } else {
            binding.incNotFound.root.visibility = View.GONE
            binding.rvSeries.visibility = View.VISIBLE

        }
    }
}