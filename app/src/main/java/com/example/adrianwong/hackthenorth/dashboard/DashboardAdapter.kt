package com.example.adrianwong.hackthenorth.dashboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.adrianwong.hackthenorth.R
import kotlinx.android.synthetic.main.dashboard_row.view.*
import kotlinx.android.synthetic.main.fragment_dashboard.view.*

class DashboardAdapter (val items : ArrayList<String>, val context: Context?) : RecyclerView.Adapter<ViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.dashboard_row, parent, false))

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.moneyAmount?.text = items[position]
    }

}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    // Holds the TextView that will add each animal to
    val moneyAmount = view.amount_of_money
}