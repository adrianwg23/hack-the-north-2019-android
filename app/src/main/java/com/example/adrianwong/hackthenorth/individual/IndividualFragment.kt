package com.example.adrianwong.hackthenorth.individual

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.adrianwong.hackthenorth.R
import kotlinx.android.synthetic.main.fragment_individual.*
import android.app.Activity
import android.R.attr.data
import com.example.adrianwong.hackthenorth.BarCodeScannerActivity


class IndividualFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_individual, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        openScanner.setOnClickListener {
            val intent = Intent(activity, BarCodeScannerActivity::class.java)
            activity?.startActivity(intent)
        }
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}
