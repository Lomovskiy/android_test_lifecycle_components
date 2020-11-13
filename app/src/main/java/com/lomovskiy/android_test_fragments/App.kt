package com.lomovskiy.android_test_fragments

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager

class App : Application() {

    private val _tagActivityLC = "ActivityLC"
    private val _tagFragmentLC = "FragmentLC"

    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {

            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                Log.d(_tagActivityLC, "onActivityCreated($activity, $savedInstanceState)")
                if (activity is FragmentActivity) {
                    activity.supportFragmentManager.registerFragmentLifecycleCallbacks(
                        object : FragmentManager.FragmentLifecycleCallbacks() {

                            override fun onFragmentPreAttached(
                                fm: FragmentManager,
                                f: Fragment,
                                context: Context
                            ) {
                                super.onFragmentPreAttached(fm, f, context)
                                Log.d(_tagFragmentLC, "onFragmentPreAttached(${f::class.java.name})")
                            }

                            override fun onFragmentAttached(
                                fm: FragmentManager,
                                f: Fragment,
                                context: Context
                            ) {
                                super.onFragmentAttached(fm, f, context)
                                Log.d(_tagFragmentLC, "onFragmentAttached(${f::class.java.name})")
                            }

                            override fun onFragmentPreCreated(
                                fm: FragmentManager,
                                f: Fragment,
                                savedInstanceState: Bundle?
                            ) {
                                super.onFragmentPreCreated(fm, f, savedInstanceState)
                                Log.d(_tagFragmentLC, "onFragmentPreCreated(${f::class.java.name})")
                            }

                            override fun onFragmentCreated(
                                fm: FragmentManager,
                                f: Fragment,
                                savedInstanceState: Bundle?
                            ) {
                                super.onFragmentCreated(fm, f, savedInstanceState)
                                Log.d(_tagFragmentLC, "onFragmentCreated(${f::class.java.name}, $savedInstanceState)")
                            }

                            override fun onFragmentViewCreated(
                                fm: FragmentManager,
                                f: Fragment,
                                v: View,
                                savedInstanceState: Bundle?
                            ) {
                                super.onFragmentViewCreated(fm, f, v, savedInstanceState)
                                Log.d(_tagFragmentLC, "onFragmentViewCreated(${f::class.java.name}, $savedInstanceState)")
                            }

                            override fun onFragmentActivityCreated(
                                fm: FragmentManager,
                                f: Fragment,
                                savedInstanceState: Bundle?
                            ) {
                                super.onFragmentActivityCreated(fm, f, savedInstanceState)
                                Log.d(_tagFragmentLC, "onFragmentActivityCreated(${f::class.java.name}, $savedInstanceState)")
                            }

                            override fun onFragmentStarted(fm: FragmentManager, f: Fragment) {
                                super.onFragmentStarted(fm, f)
                                Log.d(_tagFragmentLC, "onFragmentStarted(${f::class.java.name})")
                            }

                            override fun onFragmentResumed(fm: FragmentManager, f: Fragment) {
                                super.onFragmentResumed(fm, f)
                                Log.d(_tagFragmentLC, "onFragmentResumed(${f::class.java.name})")
                                Log.d(_tagFragmentLC, "-------------------------------")
                            }

                            override fun onFragmentPaused(fm: FragmentManager, f: Fragment) {
                                super.onFragmentPaused(fm, f)
                                Log.d(_tagFragmentLC, "onFragmentPaused(${f::class.java.name})")
                            }

                            override fun onFragmentStopped(fm: FragmentManager, f: Fragment) {
                                super.onFragmentStopped(fm, f)
                                Log.d(_tagFragmentLC, "onFragmentStopped(${f::class.java.name})")
                            }

                            override fun onFragmentSaveInstanceState(
                                fm: FragmentManager,
                                f: Fragment,
                                outState: Bundle
                            ) {
                                super.onFragmentSaveInstanceState(fm, f, outState)
                                Log.d(_tagFragmentLC, "onFragmentSaveInstanceState(${f::class.java.name}, $outState)")
                            }

                            override fun onFragmentViewDestroyed(fm: FragmentManager, f: Fragment) {
                                super.onFragmentViewDestroyed(fm, f)
                                Log.d(_tagFragmentLC, "onFragmentViewDestroyed(${f::class.java.name})")
                            }

                            override fun onFragmentDestroyed(fm: FragmentManager, f: Fragment) {
                                super.onFragmentDestroyed(fm, f)
                                Log.d(_tagFragmentLC, "onFragmentDestroyed(${f::class.java.name})")
                            }

                            override fun onFragmentDetached(fm: FragmentManager, f: Fragment) {
                                super.onFragmentDetached(fm, f)
                                Log.d(_tagFragmentLC, "onFragmentDetached(${f::class.java.name})")
                            }

                        },
                        true
                    )
                }
            }

            override fun onActivityStarted(activity: Activity) {
                Log.d(_tagActivityLC, "onActivityStarted($activity)")
            }

            override fun onActivityResumed(activity: Activity) {
                Log.d(_tagActivityLC, "onActivityResumed($activity)")
            }

            override fun onActivityPaused(activity: Activity) {
                Log.d(_tagActivityLC, "onActivityPaused($activity)")
            }

            override fun onActivityStopped(activity: Activity) {
                Log.d(_tagActivityLC, "onActivityStopped($activity)")
            }

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
                Log.d(_tagActivityLC, "onActivitySaveInstanceState($activity, $outState)")
            }

            override fun onActivityDestroyed(activity: Activity) {
                Log.d(_tagActivityLC, "onActivityDestroyed($activity)")
            }

        })
    }

}