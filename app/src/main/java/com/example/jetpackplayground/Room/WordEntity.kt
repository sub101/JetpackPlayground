package com.example.jetpackplayground.Room

@Entity(tableName = "word_table")
data class WordEntity (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id : Int,
    @ColumnInfo(name = "text")
    var text : String

)