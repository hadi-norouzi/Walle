package com.example.walle.core.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.walle.core.database.model.BrowserHistoryModel
import kotlinx.coroutines.flow.Flow

@Dao
interface BrowserDao {


    @Query("SELECT * FROM browser_history")
    suspend fun getAllHistories(): Flow<BrowserHistoryModel>

    @Insert
    suspend fun insertHistory(history: BrowserHistoryModel): Long
}