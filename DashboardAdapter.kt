package com.bs.master

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.dashboard_list_item.view.*

//TO DO: Add to main activity
//val dashboardListAdapter = DashboardAdapter()
//dashboard_list_id.adapter = dashboardListAdapter
//dashboard_list_id.layoutManager = GridLayoutManager(this, 2)
//val x = arrayListOf(DashboardDataModel("a"), DashboardDataModel("b"))
//dashboardListAdapter.setData(x)


class DashboardAdapter() :
    RecyclerView.Adapter<DashboardAdapter.DashboardViewHolder>() {

    var listener: DashboardListener? = null
    private val items = ArrayList<DashboardDataModel>()

    fun setData(dashboardItems : ArrayList<DashboardDataModel>){
        items.clear()
        items.addAll(dashboardItems)
        notifyDataSetChanged()

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        return DashboardViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.dashboard_list_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        listener?.let { holder.bind(it, items[position]) }
        val item = items[position]
        holder.dashboardTitleView.text = item.title
    }

    interface DashboardListener {
        fun OnItemClick(model: DashboardDataModel)
    }

    class DashboardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val dashboardTitleView:TextView = itemView.dashboard_item_title

        fun bind(listener: DashboardListener, model: DashboardDataModel) {
            itemView.setOnClickListener{
                listener.OnItemClick(model)
            }
        }
    }
}