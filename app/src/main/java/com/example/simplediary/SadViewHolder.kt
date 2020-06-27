package com.example.simplediary

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.sad_row.view.*

class SadViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
    var dateText: TextView? = null
    var sadText: TextView? = null


    init{
        dateText = itemView.dateText
        sadText = itemView.sadText
    }
}