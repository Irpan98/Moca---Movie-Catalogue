package id.itborneo.moca.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import id.itborneo.moca.core.constant.ImageConstant
import id.itborneo.moca.core.model.MovieModel
import id.itborneo.moca.databinding.ItemHomeBinding


class HomeAdapter(private val listener: (MovieModel) -> Unit) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    private var movies = listOf<MovieModel>()

    fun set(movies: List<MovieModel>) {
        this.movies = movies
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding =
            ItemHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount() = movies.size

    inner class ViewHolder(private val itemBinding: ItemHomeBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(movie: MovieModel) {
            itemBinding.apply {
                tvName.text = movie.title
//                tvName.text = user.login
//                tvSubtitle.text = user.htmlUrl?.removeRange(0, 8)
//                Picasso.get()
//                    .load(
//                        "https://image.tmdb.org/t/p/w600_and_h900_bestv2/${movie.posterPath}"
//                    )
//                    .into(ivPoster)

                Glide.with(root.context)
                    .load("${ImageConstant.BASE_IMAGE}${movie.posterPath}")
                    .transform(CenterCrop(), RoundedCorners(ImageConstant.IMAGE_RADIUS))
                    .into(ivPoster)
//                clItem.setOnClickListener {
//                    listener(user)
//                }
            }
        }
    }
}