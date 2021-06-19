package com.example.passnotelite

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import java.util.*

@Dao
interface NoteDao {
    @Insert
    suspend fun insertnote(userNote: UserNote)

    @Query("SELECT * FROM UserNote")
    fun noteTask(): LiveData<List<UserNote>>

    @Query("DELETE FROM UserNote WHERE uid=:uid")
    fun deletenote(uid: Long)
}