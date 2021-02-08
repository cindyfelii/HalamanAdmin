package com.farhan.halamanadmin1.riauu

data class variabel_R_riau (
    val id: String,
    val nama: String,
    val bahan: String,
    val alat: String,
    val cara: String,
){
    constructor() : this("","","","","")
}