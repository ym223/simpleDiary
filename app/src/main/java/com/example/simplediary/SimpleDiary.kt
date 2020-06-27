package com.example.simplediary

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required
import java.util.*

open class SimpleDiary : RealmObject(){
    @PrimaryKey
    var id: Long = 0
    var date: Date = Date()

    @Required
    var happy = ""
    var sad = ""

}