package com.mtuci.vkpas.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface SiteDao {
    @Upsert
    suspend fun upsertSite(site: Site)
    @Delete
    suspend fun deleteSite(site: Site)

    @Query("SELECT * FROM site ORDER BY dateAdded")
    fun getSitesOrderedByDateAdded(): Flow<List<Site>>
}