package com.example.simplediary

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var realm: Realm
    private lateinit var adapter: HappyRecyclerViewAdapter
    private lateinit var layoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        realm = Realm.getDefaultInstance()

        editBtn.setOnClickListener{
            // 編集画面に移動
            val intent = Intent(this, EditActivity::class.java)
            startActivity(intent)
        }

        readBtn.setOnClickListener{
            //メニュー画面へ移動
            val intent = Intent(this, ReadMenu::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }
}