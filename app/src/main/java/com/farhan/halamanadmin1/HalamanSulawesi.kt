package com.farhan.halamanadmin1

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.farhan.halamanadmin1.kalimantantengah.Activity_ke4
import com.farhan.halamanadmin1.sulawesiutara.Activity_ke5


class HalamanSulawesi : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        val i = inflater.inflate(R.layout.halaman_sulawesi,
                container, false)
        val panggilBanten: Button = i.findViewById(R.id.SulawesiUtara)

        panggilBanten.setOnClickListener {
            val intent = Intent(activity, Activity_ke5::class.java)
            startActivity(intent)
        }
        return i
    }

}