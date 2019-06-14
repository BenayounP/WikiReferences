package eu.lecabinetnumerique.wikireferences.domain.wikireferences

import kotlin.properties.Delegates

/*
 * Represent a wiki reference research with the query, the amount of references and the timestamp of the research
 *
 * ex:
 * query = "Liverpool"
 * references = "60 284"
 * means that Liverpool had 60 284 references on wikipedia
 *
 * Observable and (multiple) Observers classes are available
 */

data class WikiReferencesModel(val query : String="", val references : Int=-1){
    fun isEmpty() : Boolean{
        return references==-1;
    }

    class Observer (var currentWikiReferences : WikiReferencesModel){
        var onChange: ((WikiReferencesModel, WikiReferencesModel) -> Unit)? = null
    }

    class Observable {

        private var observers = mutableListOf<Observer>()

        var wikiReferencesModel : WikiReferencesModel by Delegates.observable<WikiReferencesModel>(
            WikiReferencesModel()
        ){ _, oldValue, newValue ->
            observers.forEach { e -> e.currentWikiReferences = newValue
                e.onChange?.invoke(oldValue, newValue)}
        }

        fun getObserver() : Observer {
            var searchStateObserver =
                Observer(wikiReferencesModel)
            observers.add(searchStateObserver)
            return searchStateObserver
        }
    }
}