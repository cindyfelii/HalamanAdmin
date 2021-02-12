package com.farhan.halamanadmin1.kalimantantengah

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.farhan.halamanadmin1.R
import com.google.firebase.database.FirebaseDatabase

class KalimantanTengahAdapter (
    val anggotaContext: Context,
    val layoutResId: Int,
    val anggotaList: List<variabel_R_kalimantantengah>
) : ArrayAdapter<variabel_R_kalimantantengah>(anggotaContext, layoutResId, anggotaList){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(anggotaContext)
        val view: View = layoutInflater.inflate(layoutResId, null)

        val o_nama: TextView = view.findViewById(R.id.ou_nama)
        val o_alat: TextView = view.findViewById(R.id.ou_alat)
        val o_bahan: TextView = view.findViewById(R.id.ou_bahan)
        val o_cara: TextView = view.findViewById(R.id.ou_cara)
        val imgEdit: ImageView = view.findViewById(R.id.icn_edit)

        val anggota = anggotaList[position]

        imgEdit.setOnClickListener{
            updateDialog(anggota)
        }
        o_nama.text ="Nama : " + anggota.nama
        o_alat.text ="Alat : " + anggota.alat
        o_bahan.text ="Bahan : " + anggota.bahan
        o_cara.text ="Cara : " + anggota.cara

        return view

    }

    private fun updateDialog(anggota: variabel_R_kalimantantengah){
        val builder = AlertDialog.Builder(anggotaContext)
        builder.setTitle("Update Data")
        val inflater = LayoutInflater.from(anggotaContext)
        val view = inflater.inflate(R.layout.activity_update_kalimantantengah, null)

        val  edtNama = view.findViewById<EditText>(R.id.upNama)
        val  edtAlat = view.findViewById<EditText>(R.id.upAlat)
        val  edtBahan = view.findViewById<EditText>(R.id.upBahan)
        val  edtCara = view.findViewById<EditText>(R.id.upCara)

        edtNama.setText(anggota.nama)
        edtAlat.setText(anggota.alat)
        edtBahan.setText(anggota.bahan)
        edtCara.setText(anggota.cara)

        builder.setView(view)

        builder.setPositiveButton("Ubah") {p0, p1 ->
            val dbAnggota = FirebaseDatabase.getInstance().getReference("anggota")
            val nama = edtNama.text.toString().trim()
            val alat = edtAlat.text.toString().trim()
            val bahan = edtBahan.text.toString()
            val cara = edtCara.text.toString()

            if (nama.isEmpty() or alat.isEmpty() or bahan.isEmpty() or cara.isEmpty()) {
                Toast.makeText(anggotaContext, "Isi data secara lengkap tidak boleh kosong",
                    Toast.LENGTH_SHORT)
                    .show()
                return@setPositiveButton
            }

            val anggota = variabel_R_kalimantantengah(anggota.id, nama, alat, bahan, cara )

            dbAnggota.child(anggota.id).setValue(anggota)
            Toast.makeText(anggotaContext, "Data berhasil di update", Toast.LENGTH_SHORT)
                .show()
        }
        builder.setNeutralButton("Batal") { p0, p1 -> }
        builder.setNegativeButton("Hapus") {p0, p1 ->
            val dbAnggota = FirebaseDatabase.getInstance().getReference( "anggota")
                .child(anggota.id)
            val dbDetil = FirebaseDatabase.getInstance().getReference( " detil anggota")
                .child(anggota.id)

            dbAnggota.removeValue()
            dbDetil.removeValue()

            Toast.makeText(anggotaContext, "Data berhasil di hapus", Toast.LENGTH_SHORT)
                .show()
        }

        val alert = builder.create()
        alert.show()

    }
}