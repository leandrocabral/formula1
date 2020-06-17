package com.leandroid.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fasterxml.jackson.annotation.JsonIgnoreType

@JsonIgnoreType
@Entity
data class Champion(
    @PrimaryKey val id: Int?,
    val name: String?,
    val photo: String?,
    val year:String?
)

