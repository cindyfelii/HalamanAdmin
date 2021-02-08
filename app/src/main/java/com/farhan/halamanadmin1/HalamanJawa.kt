package com.farhan.halamanadmin1

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.farhan.halamanadmin1.bantenn.Activity_ke3
import com.farhan.halamanadmin1.riauu.Activity_ke2


class HalamanJawa : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        val i = inflater.inflate(R.layout.halaman_jawa,
                container, false)
        val panggilBanten: Button = i.findViewById(R.id.btnBanten)

        panggilBanten.setOnClickListener {
            val intent = Intent(activity, Activity_ke3::class.java)
            startActivity(intent)
        }
        return i
    }

}