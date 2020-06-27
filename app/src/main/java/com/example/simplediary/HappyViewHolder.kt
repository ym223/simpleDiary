package com.example.simplediary

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.happy_row.view.*

class HappyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    var dateText: TextView? = null
    var happyText: TextView? = null

    init {
        dateText = itemView.dateText
        happyText = itemView.happyText
    }
}