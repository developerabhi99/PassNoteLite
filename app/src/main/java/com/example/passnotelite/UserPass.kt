package com.example.passnotelite

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserPass(
    var appname:String?,
    var pass:String,
    @PrimaryKey(autoGenerate = true)
    var id:Long=0

)
