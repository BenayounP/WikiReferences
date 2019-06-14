package eu.lecabinetnumerique.wikireferences.framework.roomlocalrepository

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import eu.lecabinetnumerique.wikireferences.framework.roomlocalrepository.room.SearchDao
import eu.lecabinetnumerique.wikireferences.framework.roomlocalrepository.room.SearchDataBase

object RepositoryTestUtils{
    fun getRamSearchDatabase() : SearchDataBase{
        return Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext<Context>(), SearchDataBase::class.java).build()

    }
}