package eu.lecabinetnumerique.tiniwikicount.framework.roomlocalrepository.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface SearchDao {

    @Query("SELECT * FROM ${RoomConstants.tableName} ORDER BY ${RoomConstants.timeStampColumnName} LIMIT 1")
    fun getLastSearch(): SearchEntity

    @Insert(onConflict = REPLACE)
    fun insert(searchEntity: SearchEntity)

    @Query("DELETE from ${RoomConstants.tableName}")
    fun deleteAll()
}

