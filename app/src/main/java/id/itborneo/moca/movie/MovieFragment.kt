package id.itborneo.moca.movie

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import id.itborneo.core.domain.model.MovieModel
import id.itborneo.core.enums.Status
import id.itborneo.moca.databinding.FragmentMovieBinding
import id.itborneo.moca.detail.views.DetailMovieActivity
import kotlinx.coroutines.FlowPreview
import org.koin.android.viewmodel.ext.android.sharedViewModel

@FlowPreview
class MovieFragment : Fragment() {

    companion object {
        private const val TAG = "MovieFragment"
    }

    private lateinit var binding: FragmentMovieBinding
    private lateinit var adapter: MovieAdapter

    private val viewModel: MovieViewModel by sharedViewModel()

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
        initSearch()
        observerData()
        observerSearch()

    }

    private fun observerData() {
        viewModel.getMovies().observe(viewLifecycleOwner) {
            when (it.status) {
                Status.SUCCESS -> {
                    showLoading(false)
                    val data = it.data
                    if (data != null) {
                        adapter.set(data)
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

    private fun observerSearch() {
        viewModel.getSearched().observe(viewLifecycleOwner) {
            when (it.status) {
                Status.SUCCESS -> {
                    showLoading(false)

                    if (it.data != null) {
                        val result = it.data
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
            binding.rvMovies.visibility = View.GONE
        } else {
            binding.incNotFound.root.visibility = View.GONE
            binding.rvMovies.visibility = View.VISIBLE

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
        DetailMovieActivity.getInstance(requireContext(), movie.id)
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
                        viewModel.initMovies()
                    }
                    return true
                }
            })
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.root.removeAllViews()
    }
}