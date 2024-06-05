package com.example.Lab9

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase

@Database(entities = [Grades::class], version = 1)
abstract class GradesDB: RoomDatabase() {
    abstract fun gradesDao(): GradesDao
}

@Entity(tableName = "grades")
data class Grades(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "mark") val mark: Int?,
    @ColumnInfo(name = "markDate") val markDate: String?
)

@Dao
interface GradesDao {
    @Query("SELECT * FROM grades")
    fun getAll(): List<Grades>

    @Insert
    fun insertAll(vararg grades: Grades)

    @Delete
    fun delete (grades: Grades)

    @Query("DELETE FROM grades WHERE id = :gradesId")
    fun deleteById(gradesId: Int)
}
