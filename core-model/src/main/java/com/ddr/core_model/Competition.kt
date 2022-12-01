package com.ddr.core_model

/**
 * Created by Dede Dari Rahmadi on 01/12/22
 */

data class Competition(
    val id: Int,
    val name: String
){
    constructor() : this(
        id = -1,
        name = ""
    )
}