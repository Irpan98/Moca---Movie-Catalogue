package id.itborneo.moca.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.itborneo.moca.core.enums.Status
import id.itborneo.moca.core.factory.ViewModelFactory
import id.itborneo.moca.core.model.detail.GenresItem
import id.itborneo.moca.core.model.detail.SeriesDetailModel
import id.itborneo.moca.core.repository.MocaRepository
import id.itborneo.moca.databinding.ActivityDetailSeriesBinding

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

    private val viewModel: DetailSeriesViewModel by viewModels {
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

    private fun initBinding() {
        binding = ActivityDetailSeriesBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
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
        viewModel.getCredits().observe(this) {
            when (it.status) {
                Status.SUCCESS -> {
//                    showLoading(false)

                    if (it.data != null) {
                        it.data.cast?.let { it1 -> creditsAdapter.set(it1) }

//                        updateUI(it.data)
//                        userDetail = it.data
                        Log.d(TAG, " getCredits ${it.status}, ${it.message} and ${it.data}")
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

    private fun retrieveData() {
        getIntentId = intent.extras?.getInt(EXTRA_ID_SERIES)
    }


    private fun observerDetailMovie() {
        viewModel.getDetail().observe(this) {
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

    private fun updateUI(data: SeriesDetailModel) {

        Glide.with(this)
            .load(
                "https://image.tmdb.org/t/p/w500${data?.backdropPath}"
            )
            .into(binding.ivBackdrop)
        Glide.with(this)
            .load(
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/${data?.posterPath}"
            )
            .into(binding.ivPoster)


        binding.tvGenres.text = getGenres(data.genres)
        binding.tvOverview.text = data?.overview.toString()
        binding.tvTitle.text = data.name
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

}