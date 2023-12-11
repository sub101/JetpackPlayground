package com.example.jetpackplayground.Room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WordDao {

    @Query("SELECT * FROM word_table")
    fun getAllData() : List<WordEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(text : WordEntity)

    @Query("DELETE FROM word_table")
    fun deleteAllData()

}