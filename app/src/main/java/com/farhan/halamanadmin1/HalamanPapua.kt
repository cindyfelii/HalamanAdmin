package com.farhan.halamanadmin1

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.halaman_kalimantan.*


class HalamanPapua  : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstance: Bundle?
    ): View? {
        val i = inflater.inflate(R.layout.halaman_papua, container, false)
        val panggilBanten: Button = i.findViewById(R.id.Papua)

        panggilBanten.setOnClickListener {
            val intent = Intent(activity, Papua::class.java)
            startActivity(intent)
        }
        return i
    }
}