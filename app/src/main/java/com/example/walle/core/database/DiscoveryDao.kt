package com.example.walle.core.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.walle.features.discover.data.HistoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DiscoveryDao {



    @Query("SELECT * FROM browser_history")
    fun getAllHistory(): Flow<List<HistoryEntity>>

    @Insert
    fun insert(vararg item: HistoryEntity)
}