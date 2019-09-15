package com.example.adrianwong.hackthenorth.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adrianwong.hackthenorth.MainApplication
import com.example.adrianwong.hackthenorth.R
import kotlinx.android.synthetic.main.dashboard_row.view.*
import kotlinx.android.synthetic.main.fragment_dashboard.*
import javax.inject.Inject


class DashboardFragment : Fragment(), DashboardContract.View {
    val animals: ArrayList<String> = ArrayList()

    @Inject
    lateinit var presenter: DashboardPresenter

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

    override fun showCurrentPool(currentPool: String, date: String) {
        current_pool_row.amount_of_money.text = "$$currentPool"
        current_pool_row.date.text = date
    }
    
    override fun onDestroyView() {
        (activity?.application as MainApplication).releaseDashboardSubcomponent()
        super.onDestroyView()
    }
}
