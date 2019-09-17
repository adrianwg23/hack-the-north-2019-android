package com.example.adrianwong.hackthenorth.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.adrianwong.hackthenorth.R
import com.example.adrianwong.hackthenorth.datamodels.CurrentPool
import com.example.adrianwong.hackthenorth.datamodels.DonationsInfo
import kotlinx.android.synthetic.main.dashboard_all_pool.view.*


class DashboardAdapter : ListAdapter<DonationsInfo, DashboardAdapter.CurrentPoolViewHolder>(DonationsInfoDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrentPoolViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CurrentPoolViewHolder(inflater.inflate(R.layout.dashboard_all_pool, parent, false))
    }

    override fun onBindViewHolder(holder: CurrentPoolViewHolder, position: Int) {
        val currentPool = getItem(position)
        holder.bind(currentPool)
    }

    inner class CurrentPoolViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(donationsInfo: DonationsInfo) {
            itemView.donation_amount.text = "$" + donationsInfo.amount.toString()
            itemView.date.text = donationsInfo.date
        }
    }
}

class DonationsInfoDiffUtilCallback : DiffUtil.ItemCallback<DonationsInfo>() {
    override fun areItemsTheSame(oldItem: DonationsInfo, newItem: DonationsInfo): Boolean {
        return oldItem.date == newItem.date
    }

    override fun areContentsTheSame(oldItem: DonationsInfo, newItem: DonationsInfo): Boolean {
        return oldItem == newItem
    }
}