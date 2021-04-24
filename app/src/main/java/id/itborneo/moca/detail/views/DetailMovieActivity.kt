package id.itborneo.moca.detail.views

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import es.dmoral.toasty.Toasty
import id.itborneo.moca.R
import id.itborneo.moca.core.domain.model.detail.GenreModel
import id.itborneo.moca.core.domain.model.detail.MovieDetailModel
import id.itborneo.moca.core.enums.Status
import id.itborneo.moca.databinding.ActivityDetailMoviesBinding
import id.itborneo.moca.detail.adapters.CastAdapter
import id.itborneo.moca.detail.viewmodels.DetailMovieViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

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
    private lateinit var detailMovie: MovieDetailModel

    private var getIntentId: Int? = null

    private val viewModel: DetailMovieViewModel by viewModel { parametersOf(getIntentId) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initBinding()
        initAppbarListener()
        initCreditsRecycler()
        initFavorite()
        retrieveData()
        observerDetailMovie()
        observerCredits()
        observerFavoriteStatus()
    }

    private fun initFavorite() {
        binding.btnFavorite.setOnClickListener {
            viewModel.apply {
                if (isFavorite.value == true) {
                    viewModel.removeFavorite(detailMovie)
                    showToastFavoriteStatus(false)
                } else {
                    viewModel.addFavorite(detailMovie)
                    showToastFavoriteStatus(true)
                }
            }
        }
    }

    private fun initAppbarListener() {
        binding.ivBack.setOnClickListener {
            finish()
        }
        binding.ivShare.setOnClickListener {
            Toast.makeText(this, getString(R.string.coming_soon), Toast.LENGTH_SHORT).show()
        }
    }

    private fun initCreditsRecycler() {

        binding.rvCasts.layoutManager =
            LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        creditsAdapter = CastAdapter()
        binding.rvCasts.adapter = creditsAdapter

    }

    private fun observerCredits() {
        viewModel.getCredits().observe(this) {
            when (it.status) {
                Status.SUCCESS -> {
                    showLoading(false)
                    if (it.data != null) {
                        it.data.cast?.let { it1 -> creditsAdapter.set(it1) }
                    } else {
                        showError()
                    }
                }
                Status.LOADING -> {
                    showLoading()
                }
                Status.ERROR -> {
                    showLoading(false)
                    Log.e(TAG, "${it.status}, ${it.message} and ${it.data}")
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
        viewModel.getDetailMovie().observe(this) {
            when (it.status) {
                Status.SUCCESS -> {
                    showLoading(false)

                    if (it.data != null) {
                        detailMovie = it.data
                        updateUI(detailMovie)
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

    private fun updateUI(data: MovieDetailModel) {

        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w600_and_h900_bestv2/${data.posterPath}")
            .apply(RequestOptions().dontTransform().placeholder(R.drawable.ic_placeholder_image))
            .fitCenter()
            .centerCrop()
            .into(binding.ivPoster)


        binding.tvGenres.text = getGenres(data.genres)
        binding.tvOverview.text = data.overview
        binding.tvTitle.text = data.title
        binding.tvVoteAverage.text = data.voteAverage.toString()

    }

    private fun getGenres(genres: List<GenreModel?>?): String {
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

    private fun observerFavoriteStatus() {
        viewModel.isFavorite.observe(this) {
            updateFavoriteStatusUI(it)
        }
    }

    private fun updateFavoriteStatusUI(isFavorite: Boolean) {
        if (isFavorite) {
            binding.btnFavorite.setImageResource(R.drawable.ic_favorite_active)
        } else {
            binding.btnFavorite.setImageResource(R.drawable.ic_favorite_inactive)
        }
    }

    private fun showToastFavoriteStatus(isFavorite: Boolean) {
        if (isFavorite) {
            Toasty.normal(this, getString(R.string.added_to_favorite))
                .show()
        } else {
            Toasty.normal(
                this,
                getString(R.string.removed_from_favorite),
            ).show()
        }
    }
}