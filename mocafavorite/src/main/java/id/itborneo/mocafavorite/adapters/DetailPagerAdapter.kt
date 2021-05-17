package id.itborneo.mocafavorite.adapters

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import id.itborneo.mocafavorite.views.FavoriteMovieFragment
import id.itborneo.mocafavorite.views.FavoriteSeriesFragment

class DetailPagerAdapter(activity: AppCompatActivity) :
    FragmentStateAdapter(activity) {

    private val fragments = listOf(FavoriteMovieFragment(), FavoriteSeriesFragment())

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }


    override fun getItemCount() = fragments.size
}