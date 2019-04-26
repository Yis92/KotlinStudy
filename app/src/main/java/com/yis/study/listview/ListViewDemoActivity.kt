package com.yis.study.listview

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.yis.study.R
import kotlinx.android.synthetic.main.activity_list_view_demo.*
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by liuyi on 2019-04-26.
 */
class ListViewDemoActivity : AppCompatActivity() {

    var listData = listOf("测试1", "测试2", "测试3", "测试4", "测试5", "测试6", "测试7", "测试8")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_list_view_demo)

        var kotlinListAdapter = KotlinListAdapter(listData, this)
        list_view.adapter = kotlinListAdapter
    }

    /**
     * ListView适配器
     */
    class KotlinListAdapter(private val myData: List<String>, private val context: Context) : BaseAdapter() {

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var viewHolder: ViewHolder? = null
            var view: View
            if (convertView == null) {
                view = View.inflate(context, R.layout.adapter_main_item, null)
                viewHolder = ViewHolder(view)
                view.tag = viewHolder
            } else {
                view = convertView
                viewHolder = view.tag as ViewHolder
            }

            viewHolder.name.setText(myData[position])

            return view!!
        }

        override fun getItem(position: Int): Any {
            return myData[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return myData.size
        }

        class ViewHolder(val view: View) {
            var name: TextView = view.findViewById(R.id.tv_name) as TextView
        }

    }
}