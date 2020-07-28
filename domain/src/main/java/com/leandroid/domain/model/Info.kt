package com.leandroid.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fasterxml.jackson.annotation.JsonIgnoreType

@JsonIgnoreType
@Entity
data class Info(
    @PrimaryKey val id: Int?,
    val title: String?,
    val content: String?
)