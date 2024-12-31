package com.example.mplcricket.RecyclerViewAdapter
import android.content.ComponentCallbacks
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.mplcricket.MainActivityHomeFragment
import com.example.mplcricket.MainActivityLiveFragment
import com.example.mplcricket.MainActivityPreviousFragment

class MainActiviyTabPagerAdapter(fm: FragmentManager, private var tabCount: Int) :
    FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> MainActivityHomeFragment()
            1 -> MainActivityLiveFragment()
            2 -> MainActivityPreviousFragment()
            else -> throw IllegalStateException("Invalid tab position: $position")
        }
    }

    override fun getCount(): Int {
        return tabCount
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Home"
            1 -> "Live"
            2 -> "Previous"
            else -> null
        }
    }
}
