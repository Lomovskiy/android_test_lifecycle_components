package com.lomovskiy.android_test_fragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.lomovskiy.android_test_fragments.tab.TabActivity

interface NavMessage

interface NavRouter {
    fun handleMessage(navMessage: NavMessage)
}

object Back : NavMessage
object OpenFragmentA : NavMessage
object OpenFragmentB : NavMessage
object OpenTabActivity : NavMessage

inline fun Fragment.sendNavMessage(navMessage: NavMessage) {
    (requireActivity() as NavRouter).handleMessage(navMessage)
}

class MainActivity : AppCompatActivity(), NavRouter {
    override fun handleMessage(navMessage: NavMessage) {
        when (navMessage) {
            Back -> {
                if (supportFragmentManager.backStackEntryCount > 0) {
                    supportFragmentManager.popBackStack()
                } else {
                    finish()
                }
            }
            OpenFragmentA -> {
                supportFragmentManager.beginTransaction()
                    .replace(android.R.id.content, FragmentA(), FragmentA::class.java.name)
                    .commit()
            }
            OpenFragmentB -> {
                supportFragmentManager.beginTransaction()
                    .replace(android.R.id.content, FragmentB(), FragmentB::class.java.name)
                    .addToBackStack(FragmentB::class.java.name)
                    .commit()
            }
            OpenTabActivity -> {
                startActivity(Intent(this, TabActivity::class.java))
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            handleMessage(OpenFragmentA)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        Log.d(App.tagActivityLC, "onCreate($savedInstanceState, $persistentState)")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(App.tagActivityLC, "onRestoreInstanceState($savedInstanceState)")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(App.tagActivityLC, "onRestart")
    }

}