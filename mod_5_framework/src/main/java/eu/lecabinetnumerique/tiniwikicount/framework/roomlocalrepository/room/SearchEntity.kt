package eu.lecabinetnumerique.tiniwikicount.framework.roomlocalrepository.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import eu.lecabinetnumerique.tinywikicount.domain.wikicount.WikiReferencesModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

@Entity(tableName = RoomConstants.tableName)
data class SearchEntity(@PrimaryKey(autoGenerate = true) var id : Long?,
                        @ColumnInfo(name = "query") var query: String,
                        @ColumnInfo(name = "references") var references: Int,
                        @ColumnInfo(name = "timestamp") var timestamp: Long){
    constructor():this(null,"",0,0)

    fun getWikiReferenceModel() : WikiReferencesModel{
           return  WikiReferencesModel(query,references,timestamp)
    }

    fun setColumns(wikiReferencesModel: WikiReferencesModel){
        query = wikiReferencesModel.query
        references = wikiReferencesModel.references
        timestamp = wikiReferencesModel.timestamp
    }
}