package com.example.simplediary

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.realm.Realm
import io.realm.Sort
import kotlinx.android.synthetic.main.activity_sad_list.*

class SadList : AppCompatActivity() {
    private lateinit var realm: Realm
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var adapter: SadRecyclerViewAdapter
    val dId = intent.getLongExtra("id", 0L)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sad_list)
        realm = Realm.getDefaultInstance()

        val realmResults = realm.where(SimpleDiary::class.java).findAll().sort("id", Sort.DESCENDING)
        layoutManager = LinearLayoutManager(this)
        sadRecyclerView.layoutManager = layoutManager

        adapter = SadRecyclerViewAdapter(realmResults)
        sadRecyclerView.adapter = this.adapter

    }

}
