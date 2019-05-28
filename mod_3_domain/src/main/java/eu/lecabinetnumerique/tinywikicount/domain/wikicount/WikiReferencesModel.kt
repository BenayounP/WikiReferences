package eu.lecabinetnumerique.tinywikicount.domain.wikicount

import kotlin.properties.Delegates

data class WikiReferencesModel(val query : String="", val references : Int=-1, val timestamp : Long = System.currentTimeMillis()){
    fun isEmpty() : Boolean{
        return references==-1;
    }

    class Observer{

        var onChange: ((WikiReferencesModel, WikiReferencesModel) -> Unit)? = null
    }

    class Observable {

        private var observers = mutableListOf<Observer>()

        var wikiReferencesModel : WikiReferencesModel by Delegates.observable<WikiReferencesModel>(WikiReferencesModel()){ _, oldValue, newValue ->
            observers.forEach { e -> e.onChange?.invoke(oldValue, newValue)}
        }

        fun getObserver() : Observer{
            var searchStateObserver = Observer()
            observers.add(searchStateObserver)
            return searchStateObserver
        }
    }
}