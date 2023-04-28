package com.romanmikhailenko.weaterapp.data.model.city

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.romanmikhailenko.weaterapp.utils.Constants.Companion.TABLE_CITY

@Entity(
    tableName = TABLE_CITY
)
data class City(
    @PrimaryKey(autoGenerate = false)
    var id: Int? = null,

    @ColumnInfo(name = "name")
    var name: String? = null,

    @ColumnInfo(name = "state")
    var state: String? = null,

    @ColumnInfo(name = "country")
    var country: String? = null,

    @ColumnInfo(name = "coord_lon")
    var lon: Double? = null,

    @ColumnInfo(name = "coord_lat")
    var lat: Double? = null,

    @ColumnInfo(name = "isSaved")
    var isSaved: Int? = null
)