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
import com.example.adrianwong.hackthenorth.MainApplication
import com.example.adrianwong.hackthenorth.R
import com.example.adrianwong.hackthenorth.datamodels.CurrentPool
import com.example.adrianwong.hackthenorth.service.MyFirebaseMessagingService
import kotlinx.android.synthetic.main.dashboard_row.*
import kotlinx.android.synthetic.main.fragment_dashboard.*
import javax.inject.Inject


class DashboardFragment : Fragment(), DashboardContract.View {

    @Inject lateinit var presenter: DashboardPresenter
    private val broadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            val livePoolValue = intent?.extras?.get(MyFirebaseMessagingService.EXTRA_FCM_MESSAGE)
            live_count.text = "$" + livePoolValue.toString()
        }

    }

    private val adapter = DashboardAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity?.application as MainApplication).createDashboardSubcomponent().inject(this)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerview.adapter = adapter
        presenter.attachView(this)


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

    override fun updateCurrentPool(currentPool: Int) {
        live_count.text = "$" + currentPool.toString()
    }
    
    override fun onDestroyView() {
        (activity?.application as MainApplication).releaseDashboardSubcomponent()
        presenter.detachView()
        super.onDestroyView()
    }

    override fun updateCurrentPoolList(currentPoolList: List<CurrentPool>) {
        adapter.submitList(currentPoolList)
    }

}
