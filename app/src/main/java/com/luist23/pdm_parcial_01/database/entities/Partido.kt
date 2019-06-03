package com.luist23.pdm_parcial_01.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import java.sql.Date


@Entity(tableName = "partidos")
data class Partido(

    @PrimaryKey
    @field:Json(name="id")
    val id: Int,

    @ColumnInfo(name="equipoA")
    @field:Json(name = "equipoA")
    val equipoA: String,

    @ColumnInfo(name="equipoB")
    @field:Json(name = "equipoB")
    val equipoB: String,

    @ColumnInfo(name="puntosA")
    @field:Json(name = "puntosA")
    val puntosA: Int,

    @ColumnInfo(name="puntosB")
    @field:Json(name = "puntosB")
    val puntosB: Int,

    @ColumnInfo(name="fecha")
    @field:Json(name = "fecha")
    val fecha: Int,

    @ColumnInfo(name="hora")
    @field:Json(name = "hora")
    val hora: Int,

    @ColumnInfo(name="ganador")
    @field:Json(name = "ganador")
    val ganador: String


)