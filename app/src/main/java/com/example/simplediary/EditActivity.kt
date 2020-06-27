package com.example.simplediary

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import io.realm.Realm
import io.realm.kotlin.createObject
import io.realm.kotlin.where
import kotlinx.android.synthetic.main.activity_edit.*
import java.util.*

class EditActivity : AppCompatActivity() {
    private val tag = "SimpleDiary"
    private lateinit var realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        realm = Realm.getDefaultInstance()

        val dId = intent.getLongExtra("id", 0L)
        if(dId > 0L){
            val bloodPress = realm.where<SimpleDiary>().equalTo("id", dId).findFirst()
            happyEdit.setText(bloodPress?.happy.toString())
            sadEdit.setText(bloodPress?.sad.toString())
            deleteBtn.visibility = View.VISIBLE
        }else {
            deleteBtn.visibility = View.INVISIBLE
        }

        saveBtn.setOnClickListener{
            var happy = ""
            var sad = ""

            if(!happyEdit.text.isNullOrEmpty()){
                happy = happyEdit.text.toString()
            }
            if(!sadEdit.text.isNullOrEmpty()){
                sad = sadEdit.text.toString()
            }

            when(dId){
                0L -> {
                    realm.executeTransaction {
                        val maxId = realm.where<SimpleDiary>().max("id")
                        val nextId = (maxId?.toLong() ?: 0L) + 1L
                        val simpleDiary = realm.createObject<SimpleDiary>(nextId)
                        simpleDiary.date = Date()
                        simpleDiary.happy = happy
                        simpleDiary.sad = sad
                    }
                }

                else -> {
                    realm.executeTransaction {
                        val simpleDiary = realm.where<SimpleDiary>().equalTo("id", dId).findFirst()
                        simpleDiary?.happy = happy
                        simpleDiary?.sad = sad
                    }
                }
            }
            Toast.makeText(applicationContext, "書き込んだ！", Toast.LENGTH_SHORT).show()
            finish()
        }
        deleteBtn.setOnClickListener{
            realm.executeTransaction{
                val simpleDiary = realm.where<SimpleDiary>().equalTo("id", dId)?.findFirst()?.deleteFromRealm()
            }
            Toast.makeText(applicationContext, "削除しました", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

}
