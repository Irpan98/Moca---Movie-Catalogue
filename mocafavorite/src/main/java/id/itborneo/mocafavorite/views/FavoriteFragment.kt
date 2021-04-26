package id.itborneo.mocafavorite.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import id.itborneo.moca.R
import id.itborneo.moca.databinding.FragmentFavoriteBinding
import id.itborneo.mocafavorite.adapters.DetailPagerAdapter
import org.koin.core.context.loadKoinModules


class FavoriteFragment : Fragment() {
    private lateinit var binding: FragmentFavoriteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initTabLayout()
        initInject()
    }

    private fun initInject() {
        loadKoinModules(FavoriteModules)
    }


    private val TAB_TITLES = intArrayOf(
        R.string.movies,
        R.string.series
    )

    private fun initTabLayout() {
        val sectionsPagerAdapter = DetailPagerAdapter(requireActivity() as AppCompatActivity)
        binding.viewPager.adapter = sectionsPagerAdapter
        TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()
    }
}