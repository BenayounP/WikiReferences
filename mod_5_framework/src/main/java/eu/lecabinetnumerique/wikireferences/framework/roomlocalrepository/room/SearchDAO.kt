package eu.lecabinetnumerique.wikireferences.framework.roomlocalrepository.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Update


@Dao
interface SearchDao {

    @Query("SELECT * FROM ${RoomConstants.tableName} LIMIT 1")
    fun getLastSearch(): SearchEntity

    @Insert(onConflict = REPLACE)
    fun insert(searchEntity: SearchEntity)

    @Update(onConflict = REPLACE)
    fun update(searchEntity: SearchEntity)


    @Query("DELETE from ${RoomConstants.tableName}")
    fun deleteAll()
}

