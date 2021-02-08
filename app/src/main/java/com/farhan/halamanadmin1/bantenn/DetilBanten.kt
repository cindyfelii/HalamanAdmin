package com.farhan.halamanadmin1.bantenn

data class DetilBanten (
    val id: String,
    val alat: String,
    val bahan: String,
    val cara: String,
){
    constructor() : this("","","", "")
}
