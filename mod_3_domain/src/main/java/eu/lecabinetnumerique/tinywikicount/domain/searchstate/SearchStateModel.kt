package eu.lecabinetnumerique.tinywikicount.domain.searchstate

import eu.lecabinetnumerique.tinywikicount.domain.wikicount.WikiCountModel
import kotlin.properties.Delegates

sealed class SearchStateModel {
    object Idle : SearchStateModel()
    object Error : SearchStateModel()
    object Loading : SearchStateModel()


    class Observer{

        var onChange: ((SearchStateModel, SearchStateModel) -> Unit)? = null
    }

    class Observable {

        private var observers = mutableListOf<Observer>()

        var searchState : SearchStateModel by Delegates.observable<SearchStateModel>(SearchStateModel.Idle){ _, oldValue, newValue ->
            observers.forEach { e -> e.onChange?.invoke(oldValue, newValue)}
        }

        fun getObserver() : Observer{
            var searchStateObserver = Observer()
            observers.add(searchStateObserver)
            return searchStateObserver
        }
    }
}
