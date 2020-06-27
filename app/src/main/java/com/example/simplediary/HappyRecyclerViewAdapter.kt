package com.example.simplediary

import android.content.Intent
import android.graphics.Color
import android.graphics.Color.rgb
import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.realm.RealmResults


class HappyRecyclerViewAdapter(realmResults: RealmResults<SimpleDiary>) :
    RecyclerView.Adapter<HappyViewHolder>(){
    private val hResults: RealmResults<SimpleDiary> = realmResults

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): HappyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.happy_row, parent, false)
        val viewholder = HappyViewHolder(view)
        return viewholder
    }

    override fun getItemCount() : Int{
        return hResults.size
    }

    override fun onBindViewHolder(holder: HappyViewHolder, position: Int) {
        val simpleDiary = hResults[position]
        holder.dateText?.text = DateFormat.format("yyyy/MM/dd", simpleDiary?.date)
        holder.happyText?.text = simpleDiary?.happy.toString()
        holder.itemView.setBackgroundColor(if(position % 2 == 0) rgb(246, 198, 255) else Color.WHITE)

        holder.itemView.setOnClickListener{
            val intent = Intent(it.context, EditActivity::class.java)
            intent.putExtra("id", simpleDiary?.id)
            it.context.startActivity(intent)
        }
    }

}