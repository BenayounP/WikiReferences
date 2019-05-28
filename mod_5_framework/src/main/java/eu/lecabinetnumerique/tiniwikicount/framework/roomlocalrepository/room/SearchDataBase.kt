package eu.lecabinetnumerique.tiniwikicount.framework.roomlocalrepository.room

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import eu.lecabinetnumerique.tiniwikicount.framework.MainApplication

@Database(entities = arrayOf(SearchEntity::class), version = 1)
abstract class SearchDataBase : RoomDatabase() {
    abstract fun searchDao(): SearchDao

    companion object {
        private var INSTANCE: SearchDataBase? = null

        fun getInstance(): SearchDataBase? {
            if (INSTANCE == null) {
                synchronized(SearchDataBase::class) {
                    INSTANCE = Room.databaseBuilder(MainApplication.applicationContext(),
                        SearchDataBase::class.java, "${RoomConstants.tableName}.db")
                        // TODO remove allowMainThreadQueries
                        .allowMainThreadQueries()
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