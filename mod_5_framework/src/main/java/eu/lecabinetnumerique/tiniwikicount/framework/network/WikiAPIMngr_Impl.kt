package eu.lecabinetnumerique.tiniwikicount.framework.network

import android.util.Log
import android.widget.Toast
import eu.lecabinetnumerique.tiniwikicount.framework.MainApplication
import eu.lecabinetnumerique.tinywikicount.data.network.WikiAPIMngr_Int
import eu.lecabinetnumerique.tinywikicount.domain.searchstate.SearchStateModel
import eu.lecabinetnumerique.tinywikicount.domain.wikicount.WikiCountModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class WikiAPIMngr_Impl : WikiAPIMngr_Int {

    private val wikiApiServe by lazy {
        WikiApiService.create()
    }


    override fun searchOccurrencesOnWiki(queryString: String, wikiCountModelObservable: WikiCountModel.Observable) {
        var searchStateObservable = SearchStateModel.Observable()
        wikiApiServe.hitCountCheck("query", "json", "search", queryString)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result ->
                        wikiCountModelObservable.wikiCountModel = WikiCountModel(queryString,result.query.searchinfo.totalhits)
                        searchStateObservable.searchState = SearchStateModel.Idle
                },
                { error -> searchStateObservable.searchState = SearchStateModel.Error
                    Toast.makeText(MainApplication.applicationContext(), "Error: ${error.message}", Toast.LENGTH_SHORT).show()}
            )
    }



}