package eu.lecabinetnumerique.wikireferences.framework.roomlocalrepository

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import eu.lecabinetnumerique.wikireferences.data.local.LocalRepository_Int
import eu.lecabinetnumerique.wikireferences.domain.wikireferences.WikiReferencesModel
import eu.lecabinetnumerique.wikireferences.framework.roomlocalrepository.room.SearchDao
import eu.lecabinetnumerique.wikireferences.framework.roomlocalrepository.room.repository.AbstractRoomLocalRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers.Unconfined
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AbstractRoomLocalRepositoryTest {

    private lateinit var roomLocalRepository: LocalRepository_Int

    @Before
    fun before() {
        roomLocalRepository = object : AbstractRoomLocalRepository(){
            override fun getCoroutineDispatcher(): CoroutineDispatcher {
                return Unconfined
            }

            override suspend fun getSearchDao(): SearchDao? {
                return RepositoryTestUtils.getRamSearchDatabase().searchDao()
            }

        }
    }

    @Test
    fun testSaveAndRetrieve() = runBlocking{
        // todo make it work!

        // Arrange
        val expectedWikiReferencesModel = WikiReferencesModel("Manchester", 2019)

        // Act
        roomLocalRepository.saveLastSavedSearch(expectedWikiReferencesModel)

        // Assert
        val resultWikiReferenceModel = roomLocalRepository.getLastSavedWikiReferencesModel()
        Truth.assertThat(resultWikiReferenceModel)
            .isEqualTo(expectedWikiReferencesModel)
    }



}