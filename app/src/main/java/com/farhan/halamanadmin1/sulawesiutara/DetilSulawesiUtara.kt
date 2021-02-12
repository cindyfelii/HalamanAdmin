package com.farhan.halamanadmin1.sulawesiutara

data class DetilSulawesiUtara (
    val id: String,
    val alat: String,
    val bahan: String,
    val cara: String,
){
    constructor() : this("","","", "")
}
