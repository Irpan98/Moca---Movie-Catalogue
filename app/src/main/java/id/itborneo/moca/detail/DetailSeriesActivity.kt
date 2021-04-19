package id.itborneo.moca.detail

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
import id.itborneo.moca.R
import id.itborneo.moca.core.enums.Status
import id.itborneo.moca.core.model.detail.GenreModel
import id.itborneo.moca.core.model.detail.SeriesDetailModel
import id.itborneo.moca.databinding.ActivityDetailSeriesBinding
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class DetailSeriesActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_ID_SERIES = "extra_series"
        private const val TAG = "DetailSeriesActivity"

        fun getInstance(context: Context, data: Int) {
            val intent = Intent(context, DetailSeriesActivity::class.java)
            intent.putExtra(EXTRA_ID_SERIES, data)
            context.startActivity(intent)
        }

    }

    private lateinit var creditsAdapter: CastAdapter
    private lateinit var binding: ActivityDetailSeriesBinding

    private var getIntentId: Int? = null

    private val viewModel: DetailSeriesViewModel by viewModel { parametersOf(getIntentId) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initBinding()
        initAppbarListener()
        initCreditsRecycler()
        retrieveData()
        observerDetailSeries()
        observerCredits()
    }

    private fun initAppbarListener() {
        binding.ivBack.setOnClickListener {
            finish()
        }
        binding.ivShare.setOnClickListener {
            Toast.makeText(this, getString(R.string.coming_soon), Toast.LENGTH_SHORT).show()
        }
    }

    private fun initBinding() {
        binding = ActivityDetailSeriesBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
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
                        updateUI(it.data)
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

        Glide.with(this)
            .load(
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/${data.posterPath}"
            )
            .apply(RequestOptions().dontTransform().placeholder(R.drawable.ic_placeholder_image))
            .fitCenter()
            .centerCrop()
            .into(binding.ivPoster)

        binding.tvGenres.text = getGenres(data.genres)
        binding.tvOverview.text = data.overview.toString()
        binding.tvTitle.text = data.name
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
}