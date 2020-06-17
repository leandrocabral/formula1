package com.leandroid.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fasterxml.jackson.annotation.JsonIgnoreType
import com.fasterxml.jackson.annotation.JsonInclude

@JsonIgnoreType
@Entity
data class Pilot(
    @PrimaryKey val id: Int?,
    val name: String?,
    val flag: String?,
    val photo:String?,
    val point:Int?,
    val team:String?,
    val date:String?
)