package id.itborneo.moca.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.itborneo.moca.core.model.MovieModel
import id.itborneo.moca.databinding.ItemMovieBinding


class MovieAdapter(private val listener: (MovieModel) -> Unit) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private var movies = listOf<MovieModel>()

    fun set(movies: List<MovieModel>) {
        this.movies = movies
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding =
            ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount() = movies.size

    inner class ViewHolder(private val itemBinding: ItemMovieBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(movie: MovieModel) {
            itemBinding.apply {
                tvName.text = movie.title
//                tvName.text = user.login
//                tvSubtitle.text = user.htmlUrl?.removeRange(0, 8)
//                Picasso.get()
//                    .load(user.avatarUrl)
//                    .into(ivImage)
//                clItem.setOnClickListener {
//                    listener(user)
//                }
            }
        }
    }
}