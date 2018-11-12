package net.ukr.vlsv.hw03_chat.adapter


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import net.ukr.vlsv.hw03_chat.R


class RecyclerAdapter (private var mDataset: ArrayList<Array<String>>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    // класс view holder-а с помощью которого мы получаем ссылку на каждый элемент
    // отдельного пункта спискаmDataset
    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        // наш пункт состоит только из одного TextView
        var mTextView: TextView

        init {
            mTextView = v.findViewById(R.id.text1_tw) as TextView
        }
    }

//     Создает новые views (вызывается layout manager-ом)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        if (viewType == 0) {
            val v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_count_message, parent, false)
            return ViewHolder(v)
        }

        if (viewType == 1) {
            val v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_user1_item, parent, false)
            // тут можно программно менять атрибуты лэйаута (size, margins, paddings и др.)
            return ViewHolder(v)
        }
        else {
            val v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_user2_item, parent, false)
            // тут можно программно менять атрибуты лэйаута (size, margins, paddings и др.)
            return ViewHolder(v)
        }

    }

    // Заменяет контент отдельного view (вызывается layout manager-ом)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (position == 0) {
            var countUser1: Int = 0
            var countUser2: Int = 0
            var countFirst: Int = 0

            for (i in mDataset) {
                if (countFirst == 0) {
                    countFirst++
                }
                else {
                    if (i[0] == "1") countUser1++ else countUser2++
                }
            }

            holder.mTextView.setText("user1: $countUser1             user2: $countUser2")
        }
        else {
            holder.mTextView.setText(mDataset[position][1])
        }
    }

    // Возвращает размер данных (вызывается layout manager-ом)
    override fun getItemCount(): Int {
        return mDataset.size
    }

    override fun getItemViewType(position: Int): Int
    {
        if (position == 0) {
            return 0
        }

        val ViewType: String = mDataset[position][0]
        if (ViewType == "1") {return 1}

        return -1

    }

    companion object {
        private val TAG = "RecyclerAdapter"
    }

}