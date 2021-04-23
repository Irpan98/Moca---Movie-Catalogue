package id.itborneo.moca.favorite.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import id.itborneo.moca.R
import id.itborneo.moca.core.constant.ImageConstant
import id.itborneo.moca.core.data.local.database.enitity.FavoriteSeriesEntity
import id.itborneo.moca.databinding.ItemPosterBinding


class FavoriteSeriesAdapter(private val listener: (FavoriteSeriesEntity) -> Unit) :
    RecyclerView.Adapter<FavoriteSeriesAdapter.ViewHolder>() {

    private var movies = listOf<FavoriteSeriesEntity>()

    fun set(movies: List<FavoriteSeriesEntity>) {
        this.movies = movies
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding =
            ItemPosterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount() = movies.size

    inner class ViewHolder(private val itemBinding: ItemPosterBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(movie: FavoriteSeriesEntity) {
            itemBinding.apply {
                tvName.text = movie.title
                Glide.with(root.context)
                    .load("${ImageConstant.BASE_IMAGE}${movie.posterPath}")
                    .placeholder(R.drawable.ic_placeholder_image)
                    .transform(CenterCrop(), RoundedCorners(ImageConstant.IMAGE_RADIUS))
                    .into(ivPoster)
                root.setOnClickListener {
                    listener(movie)
                }
            }
        }
    }
}