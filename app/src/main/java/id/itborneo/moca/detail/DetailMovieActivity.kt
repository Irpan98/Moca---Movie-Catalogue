package id.itborneo.moca.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.itborneo.moca.core.enums.Status
import id.itborneo.moca.core.factory.ViewModelFactory
import id.itborneo.moca.core.model.detail.GenresItem
import id.itborneo.moca.core.model.detail.MovieDetailModel
import id.itborneo.moca.core.repository.MocaRepository
import id.itborneo.moca.databinding.ActivityDetailMoviesBinding

class DetailMovieActivity : AppCompatActivity() {


    companion object {
        const val EXTRA_ID_MOVIE = "extra_movie"
        private const val TAG = "DetailActivity"

        fun getInstance(context: Context, data: Int) {
            val intent = Intent(context, DetailMovieActivity::class.java)
            intent.putExtra(EXTRA_ID_MOVIE, data)
            context.startActivity(intent)
        }

    }

    private lateinit var creditsAdapter: CastAdapter
    private lateinit var binding: ActivityDetailMoviesBinding

    private var getIntentId: Int? = null

    private val movieViewModel: DetailMovieViewModel by viewModels {
        val repo = MocaRepository

        ViewModelFactory(repo, getIntentId)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initBinding()
        initCreditsRecycler()
        retrieveData()
//        initToolbar()
//        initTabLayout()
//        buttonListener()
        observerDetailMovie()
        observerCredits()
    }

    private fun initCreditsRecycler() {

        binding.rvCasts.layoutManager =
            LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        creditsAdapter = CastAdapter {
//            actionToDetail(it)
        }
        binding.rvCasts.adapter = creditsAdapter

    }

    private fun observerCredits() {
        movieViewModel.getCredits().observe(this) {
            when (it.status) {
                Status.SUCCESS -> {
                    showLoading(false)

                    if (it.data != null) {
                        it.data.cast?.let { it1 -> creditsAdapter.set(it1) }

//                        updateUI(it.data)
//                        userDetail = it.data
                        Log.d(TAG, " getCredits ${it.status}, ${it.message} and ${it.data}")
                    } else {
                        showError()
                    }
                }
                Status.LOADING -> {
                    showLoading(true)
                }
                Status.ERROR -> {
                    showLoading(false)
                    Log.e(TAG, "${it.status}, ${it.message} and ${it.data}")
                    showError()
                }
            }
        }
    }

    private fun retrieveData() {
        getIntentId = intent.extras?.getInt(EXTRA_ID_MOVIE)
    }

    private fun initBinding() {
        binding = ActivityDetailMoviesBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    private fun observerDetailMovie() {
        movieViewModel.getDetailMovie().observe(this) {
            when (it.status) {
                Status.SUCCESS -> {
//                    showLoading(false)

                    if (it.data != null) {
                        updateUI(it.data)
//                        userDetail = it.data
                        Log.d(TAG, "${it.status}, ${it.message} and ${it.data}")
                    } else {
//                        showError()
                    }
                }
                Status.LOADING -> {
//                    showLoading(true)
                }
                Status.ERROR -> {
//                    showLoading(false)
                    Log.e(TAG, "${it.status}, ${it.message} and ${it.data}")
//                    showError()
                }
            }
        }
    }

    private fun updateUI(data: MovieDetailModel) {

        Glide.with(this)
            .load(
                "https://image.tmdb.org/t/p/w500${data.backdropPath}"
            )
            .into(binding.ivBackdrop)
        Glide.with(this)
            .load(
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/${data.posterPath}"
            )
            .into(binding.ivPoster)


        binding.tvGenres.text = getGenres(data.genres)
        binding.tvOverview.text = data.overview.toString()
        binding.tvTitle.text = data.title
        binding.tvVoteAverage.text = data.voteAverage.toString()

    }

    private fun getGenres(genres: List<GenresItem?>?): String {
        var stringGenre = ""
        genres?.forEachIndexed { index, genresItem ->
            stringGenre += if (index != genres.lastIndex) {
                " ${genresItem?.name} |"
            } else {
                " ${genresItem?.name}"
            }
        }

        return stringGenre
    }

    private fun showLoading( showIt: Boolean = true) {
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
}