package id.itborneo.moca.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import id.itborneo.moca.core.enums.Status
import id.itborneo.moca.core.factory.ViewModelFactory
import id.itborneo.moca.core.model.MovieModel
import id.itborneo.moca.core.model.detail.MovieDetailModel
import id.itborneo.moca.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {


    companion object {
        const val EXTRA_MOVIE = "extra_movie"
        private const val TAG = "DetailActivity"

        fun getInstance(context: Context, data: MovieModel) {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(EXTRA_MOVIE, data)
            context.startActivity(intent)
        }

    }

    private lateinit var binding: ActivityDetailBinding

    private var getIntentData: MovieModel? = null

    private val viewModel: DetailViewModel by viewModels {
        ViewModelFactory(getIntentData)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initBinding()
        retrieveData()
//        initToolbar()
//        initTabLayout()
//        buttonListener()
        observerDetailMovie()
    }

    private fun retrieveData() {
        getIntentData = intent.extras?.getParcelable(EXTRA_MOVIE)
    }

    private fun initBinding() {
        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    private fun observerDetailMovie() {
        viewModel.getDetailMovie().observe(this) {
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

        Picasso.get()
            .load(
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/${data.backdropPath}"
            )
            .into(binding.ivBackdrop)
        Picasso.get()
            .load(
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/${data.posterPath}"
            )
            .into(binding.ivPoster)


        binding.tvGenres.text = data.genres.toString()
        binding.tvOverview.text = data.overview.toString()
        binding.tvProductionCompanies.text = data.productionCompanies.toString()
        binding.tvTitle.text = data.title
        binding.tvVoteAverage.text = data.voteAverage.toString()

    }
}