package com.example.simplediary

import android.content.Intent
import android.graphics.Color
import android.graphics.Color.rgb
import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.realm.RealmResults


class SadRecyclerViewAdapter(realmResults: RealmResults<SimpleDiary>) :
    RecyclerView.Adapter<SadViewHolder>(){
    private val hResults: RealmResults<SimpleDiary> = realmResults

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): SadViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sad_row, parent, false)
        val viewholder = SadViewHolder(view)
        return viewholder
    }

    override fun getItemCount() : Int{
        return hResults.size
    }

    override fun onBindViewHolder(holder: SadViewHolder, position: Int) {
        val simpleDiary = hResults[position]
        holder.dateText?.text = DateFormat.format("yyyy/MM/dd", simpleDiary?.date)
        holder.sadText?.text = simpleDiary?.sad.toString()
        holder.itemView.setBackgroundColor(if(position % 2 == 0) rgb(246, 198, 255) else Color.WHITE)

        holder.itemView.setOnClickListener{
            val intent = Intent(it.context, EditActivity::class.java)
            intent.putExtra("id", simpleDiary?.id)
            it.context.startActivity(intent)
        }
    }

}