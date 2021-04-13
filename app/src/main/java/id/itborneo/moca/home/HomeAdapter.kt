package id.itborneo.moca.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import id.itborneo.moca.R
import id.itborneo.moca.core.constant.ImageConstant
import id.itborneo.moca.core.model.HomeItemModel
import id.itborneo.moca.databinding.ItemHomeBinding


class HomeAdapter(private val listener: (HomeItemModel) -> Unit) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    private var items = listOf<HomeItemModel>()

    fun set(items: List<HomeItemModel>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding =
            ItemHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    inner class ViewHolder(private val itemBinding: ItemHomeBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(movie: HomeItemModel) {
            itemBinding.apply {

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