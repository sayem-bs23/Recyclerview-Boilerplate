package com.bs.master

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dashboard_list.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dashboardListAdapter = DashboardAdapter()
        dashboard_list_id.adapter = dashboardListAdapter
        dashboard_list_id.layoutManager = GridLayoutManager(this, 2)
        val x = arrayListOf(DashboardDataModel("a"), DashboardDataModel("b"))
        dashboardListAdapter.setData(x)

    }
}
