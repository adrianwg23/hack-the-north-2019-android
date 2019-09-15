package com.example.adrianwong.hackthenorth.dashboard

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.adrianwong.hackthenorth.R
import com.example.adrianwong.hackthenorth.datamodels.CurrentPool
import kotlinx.android.synthetic.main.dashboard_row.view.*
import android.widget.TextView
import kotlinx.android.synthetic.main.dashboard_all_pool.view.*

import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.dashboard_row.view.live_count


class DashboardAdapter(
    private val chaptersList: ArrayList<CurrentPool>,
    private val context: Context?
) :
    RecyclerView.Adapter<DashboardAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.dashboard_all_pool,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return chaptersList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.chapterName?.text = chaptersList.get(position).totalAmount.toString()
        holder.chapterDate?.text = chaptersList.get(position).date

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val chapterName = itemView.live_count
        val chapterDate = itemView.date
    }

}