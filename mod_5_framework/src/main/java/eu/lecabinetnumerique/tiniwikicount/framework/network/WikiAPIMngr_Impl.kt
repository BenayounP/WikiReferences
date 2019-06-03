package eu.lecabinetnumerique.tiniwikicount.framework.network

import android.widget.Toast
import eu.lecabinetnumerique.tiniwikicount.framework.MainApplication
import eu.lecabinetnumerique.tinywikicount.data.network.WikiAPIMngr_Int
import eu.lecabinetnumerique.tinywikicount.domain.searchstate.SearchStateModel
import eu.lecabinetnumerique.tinywikicount.domain.wikicount.WikiReferencesModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class WikiAPIMngr_Impl : WikiAPIMngr_Int {

    private val wikiApiServe by lazy {
        WikiApiService.create()
    }


    override fun searchreferencesOnWiki(queryString: String, wikiReferencesModelObservable: WikiReferencesModel.Observable, searchStateObservable : SearchStateModel.Observable) {
        searchStateObservable.searchState = SearchStateModel.Loading
        wikiApiServe.hitCountCheck("query", "json", "search", queryString)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result ->
                        wikiReferencesModelObservable.wikiReferencesModel = WikiReferencesModel(queryString,result.query.searchinfo.totalhits)
                        searchStateObservable.searchState = SearchStateModel.Idle
                },
                { error -> searchStateObservable.searchState = SearchStateModel.Error}
            )
    }


}