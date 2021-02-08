package com.farhan.halamanadmin1.bantenn

data class variabel_R_banten (
    val id: String,
    val nama: String,
    val bahan: String,
    val alat: String,
    val cara: String,
){
    constructor() : this("","","","","")
}