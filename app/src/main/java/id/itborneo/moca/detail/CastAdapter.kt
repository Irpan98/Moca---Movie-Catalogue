package id.itborneo.moca.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import id.itborneo.moca.core.constant.ImageConstant
import id.itborneo.moca.core.model.credits.CastModel
import id.itborneo.moca.databinding.ItemCastBinding


class CastAdapter(private val listener: (CastModel) -> Unit) :
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
//                tvName.text = user.login
//                tvSubtitle.text = user.htmlUrl?.removeRange(0, 8)
//                Picasso.get()
//                    .load(
//                        "https://image.tmdb.org/t/p/w600_and_h900_bestv2/${movie.posterPath}"
//                    )
//                    .into(ivPoster)

                Glide.with(root.context)
                    .load("${ImageConstant.BASE_IMAGE}${cast.profilePath}")
                    .transform(CenterCrop(), RoundedCorners(ImageConstant.IMAGE_RADIUS))
                    .into(ivPoster)
//                clItem.setOnClickListener {
//                    listener(user)
//                }
            }
        }
    }
}