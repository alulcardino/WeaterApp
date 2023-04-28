package com.romanmikhailenko.weaterapp.data.model.city

import androidx.room.ColumnInfo

data class UpdateCity(
    @ColumnInfo(name = "id")
    var id: Int? = null,

    @ColumnInfo(name = "isSaved")
    var isSaved: Int? = null
)