package eu.lecabinetnumerique.wikireferences.framework.roomlocalrepository

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import eu.lecabinetnumerique.wikireferences.domain.wikireferences.WikiReferencesModel
import eu.lecabinetnumerique.wikireferences.framework.roomlocalrepository.room.SearchDao
import eu.lecabinetnumerique.wikireferences.framework.roomlocalrepository.room.SearchDataBase
import eu.lecabinetnumerique.wikireferences.framework.roomlocalrepository.room.SearchEntity
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class DaoTest{

    // Dao
    private lateinit var searchDao: SearchDao
    private lateinit var db: SearchDataBase

    @Before
    fun createDb() {
        db = RepositoryTestUtils.getRamSearchDatabase()
        searchDao = db.searchDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }



    // DAO
    @Test
    @Throws(Exception::class)
    fun testDaoWriteAndRetrieve() {
        //ARRANGE
        val expectedWikiReferenceModel = WikiReferencesModel("Liverpool", 2019)
        val searchEntity = SearchEntity()
        searchEntity.setColumns(expectedWikiReferenceModel)

        // ACT
        searchDao.insert(searchEntity)

        // ASSERT
        Truth.assertThat(searchDao.getLastSearch().getWikiReferenceModel())
            .isEqualTo(expectedWikiReferenceModel)
    }
}