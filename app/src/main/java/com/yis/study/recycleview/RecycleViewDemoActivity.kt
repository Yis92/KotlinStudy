package com.yis.study.recycleview

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.yis.study.R
import kotlinx.android.synthetic.main.activity_recycle_view_demo.*

/**
 * Created by liuyi on 2019-04-26.
 */
class RecycleViewDemoActivity : AppCompatActivity() {

    private var listData = listOf("测试1", "测试2", "测试3", "测试4", "测试5", "测试6", "测试7", "测试8")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_recycle_view_demo)

        recycle_view.layoutManager = LinearLayoutManager(this)
        var adapter = MyRecycleViewAdapter(this, listData)
        recycle_view.adapter = adapter

    }

    /**
     * RecycleView适配器
     */
    class MyRecycleViewAdapter(private val context: Context, private val myData: List<String>) :
        RecyclerView.Adapter<MyRecycleViewAdapter.ViewHolder>() {

        override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): ViewHolder {
            return ViewHolder(
                LayoutInflater.from(context).inflate(
                    R.layout.adapter_recycle_view_demo_item,
                    viewGroup,
                    false
                )
            )
        }

        override fun getItemCount(): Int {
            return myData.size
        }

        override fun onBindViewHolder(viewholder: ViewHolder, position: Int) {
            viewholder.tvName.text = myData[position]
        }


        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var tvName: TextView = itemView.findViewById(R.id.tv_name) as TextView
        }
    }


}