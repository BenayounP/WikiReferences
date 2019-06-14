package eu.lecabinetnumerique.wikireferences.framework.roomlocalrepository.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import eu.lecabinetnumerique.wikireferences.domain.wikireferences.WikiReferencesModel

@Entity(tableName = RoomConstants.tableName)
data class SearchEntity(@PrimaryKey var id : Long?,
                        @ColumnInfo(name = "query") var query: String,
                        @ColumnInfo(name = "references") var references: Int){
    constructor():this(1,"",0)

    fun getWikiReferenceModel() : WikiReferencesModel {
           return WikiReferencesModel(
               query,
               references
           )
    }

    fun setColumns(wikiReferencesModel: WikiReferencesModel){
        query = wikiReferencesModel.query
        references = wikiReferencesModel.references
    }
}