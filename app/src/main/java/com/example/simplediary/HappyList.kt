package com.example.simplediary

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.realm.Realm
import io.realm.Sort
import kotlinx.android.synthetic.main.activity_happy_list.*

class HappyList : AppCompatActivity() {
    private lateinit var realm: Realm
    private lateinit var adapter: HappyRecyclerViewAdapter
    private lateinit var layoutManager: RecyclerView.LayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_happy_list)
        realm = Realm.getDefaultInstance()
    }

    override fun onStart(){
        super.onStart()
        val realmResults = realm.where(SimpleDiary::class.java).findAll().sort("id", Sort.DESCENDING)
        layoutManager = LinearLayoutManager(this)
        happyRecyclerView.layoutManager = layoutManager

        adapter = HappyRecyclerViewAdapter(realmResults)
        happyRecyclerView.adapter = this.adapter
    }
}