package com.farhan.halamanadmin1.kalimantantengah

data class DetilKalimantanTengah (
    val id: String,
    val alat: String,
    val bahan: String,
    val cara: String,
){
    constructor() : this("","","", "")
}
