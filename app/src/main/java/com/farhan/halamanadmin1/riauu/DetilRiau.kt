package com.farhan.halamanadmin1.riauu

data class DetilRiau (
    val id: String,
    val alat: String,
    val bahan: String,
    val cara: String,
){
    constructor() : this("","","", "")
}
