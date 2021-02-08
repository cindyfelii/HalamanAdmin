package com.farhan.halamanadmin1.riauu

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.farhan.halamanadmin1.R
import com.farhan.halamanadmin1.riauu.DetilRiau

class DetilRiauAdapter (
    val detilContext: Context,
    val layoutResId : Int,
    val detilList: List<DetilRiau>
) : ArrayAdapter<DetilRiau>(detilContext, layoutResId, detilList){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater : LayoutInflater = LayoutInflater.from(detilContext)
        val view: View = layoutInflater.inflate(layoutResId, null)

        val tvAlat = view.findViewById<TextView>(R.id.ou_alat)
        val tvBahan = view.findViewById<TextView>(R.id.ou_bahan)
        val tvCara = view.findViewById<TextView>(R.id.ou_cara)

        val detil = detilList[position]
        tvAlat.text = detil.alat
        tvBahan.text = detil.bahan
        tvCara.text = detil.cara

        return view
    }

}