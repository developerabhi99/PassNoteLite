package com.example.passnotelite

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserNote(

    var notesubject:String?,

    var note:String,
    @PrimaryKey(autoGenerate = true)
    var uid:Long=0
)
