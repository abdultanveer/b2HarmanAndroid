package com.abdul.b2harmanandroid.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao //annotation
interface ItemDao {
    //crud
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(itemRow: Item)

    @Update
    suspend fun update(item: Item)

    @Delete
    suspend fun delete(item: Item)

    @Query("SELECT * from item WHERE id = :id")
    fun getItem(id: Int): Flow<Item>

    @Query("SELECT * from item ORDER BY name ASC")
    fun getItems(): Flow<List<Item>>

}