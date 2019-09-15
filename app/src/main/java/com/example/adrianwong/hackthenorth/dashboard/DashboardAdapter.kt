package com.example.adrianwong.hackthenorth.dashboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.adrianwong.hackthenorth.R
import kotlinx.android.synthetic.main.dashboard_row.view.*
import kotlinx.android.synthetic.main.fragment_dashboard.view.*

class DashboardAdapter(val items: ArrayList<String>, val context: Context?) :
    RecyclerView.Adapter<DashboardAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.dashboard_row,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //holder.bind(items[position])
        //holder?.tvAnimalType?.text = items.get(position)
    }


    inner class ViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {
    }
}