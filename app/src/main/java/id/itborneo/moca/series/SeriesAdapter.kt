package id.itborneo.moca.series

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import id.itborneo.moca.R
import id.itborneo.moca.core.constant.ImageConstant
import id.itborneo.moca.core.domain.model.SeriesModel
import id.itborneo.moca.databinding.ItemPosterBinding


class SeriesAdapter(private val listener: (SeriesModel) -> Unit) :
    RecyclerView.Adapter<SeriesAdapter.ViewHolder>() {

    private var series = listOf<SeriesModel>()

    fun set(series: List<SeriesModel>) {
        this.series = series
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding =
            ItemPosterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(series[position])
    }

    override fun getItemCount() = series.size

    inner class ViewHolder(private val itemBinding: ItemPosterBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(movie: SeriesModel) {
            itemBinding.apply {
                tvName.text = movie.name

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