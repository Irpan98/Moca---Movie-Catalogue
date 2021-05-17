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
import id.itborneo.core.enums.Status
import id.itborneo.moca.R
import id.itborneo.moca.databinding.ActivityDetailSeriesBinding
import id.itborneo.moca.detail.adapters.CastAdapter
import id.itborneo.moca.detail.viewmodels.DetailSeriesViewModel
import id.itborneo.moca.model.SeriesModel
import id.itborneo.moca.model.detail.GenreModel
import id.itborneo.moca.model.detail.SeriesDetailModel
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class DetailSeriesActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_ID_SERIES = "extra_series"
        private const val TAG = "DetailSeriesActivity"

        fun getInstance(context: Context, data: Int) {
            val intent = Intent(context, DetailSeriesActivity::class.java)
            intent.putExtra(EXTRA_ID_SERIES, data).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            context.startActivity(intent)
        }
    }

    private var binding: ActivityDetailSeriesBinding? = null

    private lateinit var creditsAdapter: CastAdapter
    private lateinit var detailSeries: SeriesDetailModel

    private var getIntentId: Int? = null

    private val viewModel: DetailSeriesViewModel by viewModel { parametersOf(getIntentId) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initBinding()
        initAppbarListener()
        initCreditsRecycler()
        initFavorite()
        retrieveData()
        observerDetailSeries()
        observerCredits()
        observerFavoriteStatus()
    }

    private fun initAppbarListener() {

        binding?.ivBack?.setOnClickListener {
            finish()
        }
        binding?.ivShare?.setOnClickListener {
            Toast.makeText(this, getString(R.string.coming_soon), Toast.LENGTH_SHORT).show()
        }
    }

    private fun initBinding() {
        binding = ActivityDetailSeriesBinding.inflate(layoutInflater)
        val view = binding?.root
        setContentView(view)
    }

    private fun initFavorite() {
        binding?.btnFavorite?.setOnClickListener {
            viewModel.apply {
                if (getFavorites().value != null) {
                    viewModel.removeFavorite(detailSeries)
                    showToastFavoriteStatus(false)
                } else {
                    viewModel.addFavorite(detailSeries)
                    showToastFavoriteStatus(true)
                }
            }
        }
    }

    private fun initCreditsRecycler() {
        binding?.rvCasts?.layoutManager =
            LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        creditsAdapter = CastAdapter()
        binding?.rvCasts?.adapter = creditsAdapter
    }

    private fun observerCredits() {
        viewModel.getCredits().observe(this) {
            when (it.status) {
                Status.SUCCESS -> {
                    showLoading(false)
                    val data = it.data
                    if (data != null) {
                        data.cast?.let { it1 -> creditsAdapter.set(it1) }
                    }
                }
                Status.LOADING -> {
                    showLoading(true)
                }
                Status.ERROR -> {
                    showLoading(false)
                    Log.e(TAG, "${it.status}, ${it.message} and ${it.data}")
                }
            }
        }
    }

    private fun retrieveData() {
        getIntentId = intent.extras?.getInt(EXTRA_ID_SERIES)
    }

    private fun observerDetailSeries() {
        viewModel.getDetail().observe(this) {
            when (it.status) {
                Status.SUCCESS -> {
                    showLoading(false)
                    if (it.data != null) {
                        val data = it.data
                        if (data != null) {
                            detailSeries = data
                            updateUI(detailSeries)
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
                    Log.e(TAG, "${it.status}, ${it.message} and ${it.data}")
                    showError()
                }
            }
        }
    }

    private fun updateUI(data: SeriesDetailModel) {

        binding?.apply {
            Glide.with(this@DetailSeriesActivity)
                .load("https://image.tmdb.org/t/p/w600_and_h900_bestv2/${data.posterPath}")
                .apply(
                    RequestOptions().dontTransform().placeholder(R.drawable.ic_placeholder_image)
                )
                .fitCenter()
                .centerCrop()
                .into(this.ivPoster)

            this.tvGenres.text = getGenres(data.genres)
            this.tvOverview.text = data.overview.toString()
            this.tvTitle.text = data.name
            this.tvVoteAverage.text = data.voteAverage.toString()
        }

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
        binding?.incDetailSeriesLoading?.root?.apply {
            visibility = if (showIt) {
                View.VISIBLE
            } else {
                View.GONE
            }
        }
    }

    private fun showError(showIt: Boolean = true) {
        binding?.incDetailSeriesError?.root?.apply {
            visibility = if (showIt) {
                View.VISIBLE
            } else {
                View.GONE
            }
        }
    }

    private fun observerFavoriteStatus() {
        viewModel.getFavorites().observe(this) {
            updateFavoriteStatusUI(it)
        }
    }

    private fun updateFavoriteStatusUI(isFavorite: SeriesModel?) {
        if (isFavorite != null) {
            binding?.btnFavorite?.setImageResource(R.drawable.ic_favorite_active)
        } else {
            binding?.btnFavorite?.setImageResource(R.drawable.ic_favorite_inactive)
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