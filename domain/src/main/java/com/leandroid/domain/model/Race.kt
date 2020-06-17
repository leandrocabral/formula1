package com.leandroid.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fasterxml.jackson.annotation.JsonInclude

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
data class Race(
    @PrimaryKey val id: Int?,
    val name: String?,
    val flag: String?
)

