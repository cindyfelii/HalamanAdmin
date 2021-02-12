package com.farhan.halamanadmin1.papua

data class DetilPapua (
    val id: String,
    val alat: String,
    val bahan: String,
    val cara: String,
){
    constructor() : this("","","", "")
}
