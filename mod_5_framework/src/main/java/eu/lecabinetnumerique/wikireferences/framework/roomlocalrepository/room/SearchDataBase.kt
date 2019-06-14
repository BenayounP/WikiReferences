package eu.lecabinetnumerique.wikireferences.framework.roomlocalrepository.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import eu.lecabinetnumerique.wikireferences.framework.MainApplication

@Database(entities = arrayOf(SearchEntity::class), version = 1)
abstract class SearchDataBase : RoomDatabase() {
    abstract fun searchDao(): SearchDao

    companion object {
        private var INSTANCE: SearchDataBase? = null

        suspend fun getInstance(context : Context): SearchDataBase? {
            if (INSTANCE == null) {
                synchronized(SearchDataBase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        SearchDataBase::class.java, "${RoomConstants.tableName}.db")
                        .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}