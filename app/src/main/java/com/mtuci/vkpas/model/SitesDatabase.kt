package com.mtuci.vkpas.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Site::class],
    version = 1
)
abstract class SitesDatabase: RoomDatabase() {
    abstract val dao: SiteDao
}