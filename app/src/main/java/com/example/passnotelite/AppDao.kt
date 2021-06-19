package com.example.passnotelite

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import java.util.*

@Dao
interface AppDao {
    @Insert
    suspend fun insertpass(userPass: UserPass)

    @Query("SELECT * FROM UserPass" )
    fun getTask(): LiveData<List<UserPass>>

    @Query("Delete from UserPass where id= :uid")
    fun deletepass(uid:Long)


}