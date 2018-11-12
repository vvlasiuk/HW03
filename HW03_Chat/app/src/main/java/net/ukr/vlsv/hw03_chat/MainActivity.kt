package net.ukr.vlsv.hw03_chat

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v7.widget.RecyclerView
import net.ukr.vlsv.hw03_chat.adapter.RecyclerAdapter
import net.ukr.vlsv.hw03_chat.adapter.SpacesItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myDataset = getDataSet()

        chat_rv.setHasFixedSize(true)                               // если мы уверены, что изменения в контенте не изменят размер layout-а RecyclerView
        chat_rv.layoutManager = LinearLayoutManager(this)           // используем linear layout manager
        chat_rv.adapter = RecyclerAdapter(myDataset)                // создаем адаптер

        val viewType: String
        if (radioButton1.isChecked) viewType = "1"
        else viewType = "2"

        myDataset.add(arrayOf(viewType, ""))
        chat_rv.adapter.notifyDataSetChanged()
        chat_rv.addItemDecoration(SpacesItemDecoration(15))

        ok_btn.setOnClickListener() {
            val viewType: String

            if (radioButton1.isChecked) viewType = "1"
            else viewType = "2"

            myDataset.add(arrayOf(viewType, text_tw.text.toString()))
            text_tw.setText("")
//            chat_rv.adapter.notifyItemInserted(chat_rv.childCount - 1)
            chat_rv.adapter.notifyDataSetChanged()
        }
    }

    private fun getDataSet(): ArrayList<Array<String>> {
        val mDataSet = ArrayList<Array<String>>()
        return mDataSet
    }
}
