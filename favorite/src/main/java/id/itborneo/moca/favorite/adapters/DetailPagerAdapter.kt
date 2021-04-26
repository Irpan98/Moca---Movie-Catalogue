package id.itborneo.moca.favorite.adapters

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import id.itborneo.moca.favorite.views.FavoriteMovieFragment
import id.itborneo.moca.favorite.views.FavoriteSeriesFragment

class DetailPagerAdapter(activity: AppCompatActivity) :
    FragmentStateAdapter(activity) {

    private val fragments = listOf(FavoriteMovieFragment(), FavoriteSeriesFragment())

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = fragments[0]
            1 -> fragment = fragments[1]
        }
        return fragment as Fragment
    }

    override fun getItemCount() = fragments.size
}