package id.itborneo.moca.detail.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import id.itborneo.core.constant.ImageConstant
import id.itborneo.core.domain.model.credits.CastModel
import id.itborneo.moca.R
import id.itborneo.moca.databinding.ItemCastBinding


class CastAdapter :
    RecyclerView.Adapter<CastAdapter.ViewHolder>() {

    private var casts = listOf<CastModel>()

    fun set(casts: List<CastModel>) {
        this.casts = casts
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding =
            ItemCastBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(casts[position])
    }

    override fun getItemCount() = casts.size

    inner class ViewHolder(private val itemBinding: ItemCastBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(cast: CastModel) {
            itemBinding.apply {
                tvName.text = cast.name
                Glide.with(root.context)
                    .load("${ImageConstant.BASE_IMAGE}${cast.profilePath}")
                    .placeholder(R.drawable.ic_placeholder_image)
                    .transform(CenterCrop(), RoundedCorners(ImageConstant.IMAGE_RADIUS))
                    .into(ivPoster)

            }
        }
    }
}