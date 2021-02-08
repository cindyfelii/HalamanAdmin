package com.farhan.halamanadmin1

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.halaman_sumatra.*

class Riau: Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstance: Bundle?
    ): View? {
        val i = inflater.inflate(R.layout.halaman_sumatra, container, false)
        val panggilBanten: Button = i.findViewById(R.id.btnRiau)

        panggilBanten.setOnClickListener {
            val intent = Intent(activity, btnRiau::class.java)
            startActivity(intent)
        }
        return i
    }
}
