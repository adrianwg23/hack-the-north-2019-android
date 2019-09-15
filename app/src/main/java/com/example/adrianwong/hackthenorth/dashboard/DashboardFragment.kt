package com.example.adrianwong.hackthenorth.dashboard

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adrianwong.hackthenorth.MainApplication
import com.example.adrianwong.hackthenorth.R
import com.example.adrianwong.hackthenorth.service.MyFirebaseMessagingService
import kotlinx.android.synthetic.main.dashboard_row.*
import kotlinx.android.synthetic.main.dashboard_row.view.*
import kotlinx.android.synthetic.main.fragment_dashboard.*
import javax.inject.Inject


class DashboardFragment : Fragment(), DashboardContract.View {
    val animals: ArrayList<String> = ArrayList()

    @Inject lateinit var presenter: DashboardPresenter
    private val broadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            val livePoolValue = intent?.extras?.get(MyFirebaseMessagingService.EXTRA_FCM_MESSAGE)
            live_count.text = "$" + livePoolValue.toString()
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity?.application as MainApplication).createDashboardSubcomponent().inject(this)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.attachView(this)
        
        recyclerview.layoutManager = LinearLayoutManager(context)

        recyclerview.adapter = DashboardAdapter(animals, context) 
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        activity?.registerReceiver(broadcastReceiver, IntentFilter(MyFirebaseMessagingService.LIVE_POOL_TRIGGER))
    }

    override fun onPause() {
        super.onPause()
        activity?.unregisterReceiver(broadcastReceiver)
    }

    override fun showCurrentPool(currentPool: String, date: String) {
    }
    
    override fun onDestroyView() {
        (activity?.application as MainApplication).releaseDashboardSubcomponent()
        super.onDestroyView()
    }
}
