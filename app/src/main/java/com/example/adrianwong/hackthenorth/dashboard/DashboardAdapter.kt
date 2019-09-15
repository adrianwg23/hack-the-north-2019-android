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
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.dashboard_all_pool.view.*
import kotlinx.android.synthetic.main.dashboard_row.view.live_count


class ChapterAdapter(
    private val chaptersList: ArrayList<CurrentPool>,
    private val context: Context?
) :
    RecyclerView.Adapter<ChapterAdapter.ViewHolder>() {
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
        //return chaptersList.size
        return 17
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.chapterName?.text = chaptersList.get(position).totalAmount.toString()
        holder.chapterDate?.text = chaptersList.get(position).date

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val chapterName = view.live_count
        val chapterDate = view.date
    }
}

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