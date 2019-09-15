package com.example.adrianwong.hackthenorth.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.adrianwong.hackthenorth.R
import com.example.adrianwong.hackthenorth.datamodels.CurrentPool
import kotlinx.android.synthetic.main.dashboard_all_pool.view.*


class DashboardAdapter : ListAdapter<CurrentPool, DashboardAdapter.CurrentPoolViewHolder>(CurrentPoolDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrentPoolViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CurrentPoolViewHolder(inflater.inflate(R.layout.dashboard_all_pool, parent, false))
    }

    override fun onBindViewHolder(holder: CurrentPoolViewHolder, position: Int) {
        val currentPool = getItem(position)
        holder.bind(currentPool)
    }

    inner class CurrentPoolViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(currentPool: CurrentPool) {
            itemView.live_count.text = currentPool.totalAmount.toString()
            itemView.date.text = currentPool.date
        }
    }
}

class CurrentPoolDiffUtilCallback : DiffUtil.ItemCallback<CurrentPool>() {
    override fun areItemsTheSame(oldItem: CurrentPool, newItem: CurrentPool): Boolean {
        return oldItem.date == newItem.date
    }

    override fun areContentsTheSame(oldItem: CurrentPool, newItem: CurrentPool): Boolean {
        return oldItem == newItem
    }
}