package com.luist23.pdm_parcial_01.Utilities

import com.luist23.pdm_parcial_01.database.entities.Partido

interface Utils{
    fun changeDataSet(newDataSet : List<Partido>)
}