package id.itborneo.moca.favorite.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import id.itborneo.moca.R
import id.itborneo.moca.core.constant.ImageConstant
import id.itborneo.moca.core.data.local.database.enitity.FavoriteMovieEntity
import id.itborneo.moca.databinding.ItemPosterBinding


class FavoriteMoviePagedAdapter(
    val listener: (FavoriteMovieEntity) -> Unit
) : PagedListAdapter<FavoriteMovieEntity, FavoriteMoviePagedAdapter.ViewHolder>(DIFF_CALLBACK) {


    companion object {

        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<FavoriteMovieEntity>() {
            override fun areItemsTheSame(
                oldItem: FavoriteMovieEntity,
                newItem: FavoriteMovieEntity
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: FavoriteMovieEntity,
                newItem: FavoriteMovieEntity
            ): Boolean {
                return oldItem == oldItem
            }

        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding =
            ItemPosterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.bind(item)

        }
    }


    inner class ViewHolder(private val itemBinding: ItemPosterBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(movie: FavoriteMovieEntity) {
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
