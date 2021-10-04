package com.example.moofwd_app.entities

import androidx.versionedparcelable.VersionedParcelize


@VersionedParcelize
data class ItemEnti(
    var id: Int = 0,
    var title: String = "",
    var date: String = "",
    var desc: String = "",
    var image: String = ""
)