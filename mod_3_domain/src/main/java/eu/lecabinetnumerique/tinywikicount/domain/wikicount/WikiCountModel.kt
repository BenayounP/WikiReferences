package eu.lecabinetnumerique.tinywikicount.domain.wikicount

import kotlin.properties.Delegates

data class WikiCountModel(val query : String="", val occurrences : Int=-1, val timestamp : Long = System.currentTimeMillis()){
    fun isEmpty() : Boolean{
        return occurrences==-1;
    }

    class Observer{

        var onChange: ((WikiCountModel, WikiCountModel) -> Unit)? = null
    }

    class Observable {

        private var observers = mutableListOf<Observer>()

        var wikiCountModel : WikiCountModel by Delegates.observable<WikiCountModel>(WikiCountModel()){ _, oldValue, newValue ->
            observers.forEach { e -> e.onChange?.invoke(oldValue, newValue)}
        }

        fun getObserver() : Observer{
            var searchStateObserver = Observer()
            observers.add(searchStateObserver)
            return searchStateObserver
        }
    }
}