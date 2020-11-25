package com.lomovskiy.android_test_fragments.tab

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.lomovskiy.android_test_fragments.R

enum class Tab {
    ONE,
    TWO
}

class TabActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var container: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab)
        bottomNavigationView = findViewById(R.id.bottom_navigation_view)
        bottomNavigationView.setOnNavigationItemSelectedListener {
            if (it.itemId == R.id.action_1) {
                openTab(Tab.ONE)
            } else {
                openTab(Tab.TWO)
            }
            return@setOnNavigationItemSelectedListener true
        }
        openTab(Tab.ONE)
    }

    private fun openTab(tab: Tab) {
        var currentFragment: Fragment? = null
        for (fragment in supportFragmentManager.fragments) {
            if (fragment.isVisible) {
                currentFragment = fragment
                break
            }
        }
        val newFragment: Fragment? = supportFragmentManager.findFragmentByTag(tab.name)
        if (currentFragment != null && newFragment != null && currentFragment === newFragment) {
            return
        }
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        if (newFragment == null) {
            transaction.add(R.id.container, getFragment(tab), tab.name)
        }
        if (currentFragment != null) {
            transaction.hide(currentFragment)
        }
        if (newFragment != null) {
            transaction.show(newFragment)
        }
        transaction.commit()
    }

    private fun getFragment(tab: Tab): Fragment {
        when (tab) {
            Tab.ONE -> {
                return TabFragment1()
            }
            Tab.TWO -> {
                return TabFragment2()
            }
        }
    }

}