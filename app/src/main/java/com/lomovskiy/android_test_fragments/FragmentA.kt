package com.lomovskiy.android_test_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputLayout

class FragmentA : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(view.findViewById(R.id.button) as Button) {
            setOnClickListener {
                sendNavMessage(OpenFragmentB)
            }
        }
        view.findViewById<Button>(R.id.button_tab_activity).setOnClickListener {
            sendNavMessage(OpenTabActivity)
        }
    }

}
