package eu.lecabinetnumerique.wikireferences.data;

import com.google.common.truth.Truth
import eu.lecabinetnumerique.wikireferences.data.local.LocalRepository_Fake
import eu.lecabinetnumerique.wikireferences.data.network.WikiAPIMngr_Fake
import eu.lecabinetnumerique.wikireferences.domain.searchstate.SearchStateModel
import eu.lecabinetnumerique.wikireferences.domain.wikireferences.WikiReferencesModel
import org.junit.Before
import org.junit.Test


class DataTest {

    // Data to test
    private lateinit var data : Data_Int

    // Dependencies
    private lateinit var wikiAPIMngr: WikiAPIMngr_Fake
    private lateinit var localRepository: LocalRepository_Fake

    @Before
    fun setup() {
        wikiAPIMngr = WikiAPIMngr_Fake()
        localRepository = LocalRepository_Fake()
        data = Data_Impl(wikiAPIMngr,localRepository)
    }

    @Test
    fun lastWikiReferencesLoading()
    {
        // Arrange and Act
        // nothing to do, data loaded WikiReferenceModel at startup

        // Assert
        Truth.assertThat(data.getWikiReferencesObserver().currentWikiReferences)
            .isEqualTo(localRepository.getLastSavedWikiReferencesModel())
    }

    @Test
    fun get_Wiki_References_via_API_SUCCESS(){
        // Arrange
        val expectedWikiReferencesModel =  WikiReferencesModel("Liverpool",2019)
        wikiAPIMngr.nextQueryAmountOfReferences = expectedWikiReferencesModel.references
        var wikiReferencesModelObserver = data.getWikiReferencesObserver()

        // Act
        data.searchReferencesOnWiki(expectedWikiReferencesModel.query)

        // Assert
        Truth.assertThat(wikiReferencesModelObserver.currentWikiReferences)
            .isEqualTo(expectedWikiReferencesModel)
    }

    @Test
    fun API_ERROR(){
        // Arrange
        wikiAPIMngr.setErrorModeON()

        // Act
        data.searchReferencesOnWiki("Liverpool")

        // Assert
        Truth.assertThat(data.getSearchStateObserver().currentState)
            .isEqualTo(SearchStateModel.Error)
    }
}