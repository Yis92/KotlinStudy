package com.yis.study

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.yis.study.listview.ListViewDemoActivity
import com.yis.study.recycleview.RecycleViewDemoActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        btn_list_view.setOnClickListener {
            val intent = Intent(this, ListViewDemoActivity::class.java)
            startActivity(intent)
        }

        btn_recycle_view.setOnClickListener{
            val intent = Intent(this, RecycleViewDemoActivity::class.java)
            startActivity(intent)
        }

    }


}
