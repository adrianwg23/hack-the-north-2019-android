package com.example.adrianwong.hackthenorth.dashboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.adrianwong.hackthenorth.R
import com.example.adrianwong.hackthenorth.datamodels.CurrentPool
import kotlinx.android.synthetic.main.dashboard_row.view.*
import android.widget.TextView
import kotlinx.android.extensions.LayoutContainer


class DashboardAdapter(val items: ArrayList<CurrentPool>, val context: Context?) :
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
        items?.let { v ->
            holder.title.text = v[position].totalAmount.toString()
        }
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.live_count
    }
}