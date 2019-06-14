package eu.lecabinetnumerique.wikireferences.domain.searchstate

import kotlin.properties.Delegates


/*
 * Represent the searching state of the app
 *
 * 3 states:
 * Idle : by default. Nothing is happening
 * loading : if app is searching wiki references on wikipedia
 * Error: if there was an error
 *
 * Observable and (multiple) Observers classes are available
 */

sealed class SearchStateModel {
    object Idle : SearchStateModel()
    object Searching : SearchStateModel()
    object Error : SearchStateModel()


    class Observer(var currentState : SearchStateModel){
        var onChange: ((SearchStateModel, SearchStateModel) -> Unit)? = null
    }

    class Observable {

        private var observers = mutableListOf<Observer>()

        var searchState : SearchStateModel by Delegates.observable<SearchStateModel>(
            Idle
        ){ _, oldValue, newValue ->
            observers.forEach { e -> e.currentState = newValue
                e.onChange?.invoke(oldValue, newValue)}
        }

        fun getObserver() : Observer {
            var searchStateObserver =
                Observer(searchState)
            observers.add(searchStateObserver)
            return searchStateObserver
        }
    }
}
