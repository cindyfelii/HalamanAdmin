package com.farhan.halamanadmin1.bantenn

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.input_banten.*
import com.farhan.halamanadmin1.R

class Activity_ke3 : AppCompatActivity(), View.OnClickListener {

    private lateinit var edNama: EditText
    private lateinit var edAlat: EditText
    private lateinit var edBahan: EditText
    private lateinit var edCara: EditText
    private lateinit var btnSimpan: Button
    private lateinit var listData: ListView
    private lateinit var ref: DatabaseReference
    private lateinit var anggotaList : MutableList<variabel_R_banten>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.input_banten)

        ref = FirebaseDatabase.getInstance().getReference("anggota")

        edNama = findViewById(R.id.edt_nama)
        edAlat = findViewById(R.id.edt_alat)
        edBahan = findViewById(R.id.edt_bahan)
        edCara = findViewById(R.id.edt_cara)
        btnSimpan = findViewById(R.id.btn_simpan)
        listData = findViewById(R.id.lv_hasil)

        btnSimpan.setOnClickListener(this)
        anggotaList = mutableListOf()

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (a in snapshot.children){
                        val anggota = a.getValue(variabel_R_banten::class.java)
                        if (anggota !=null){
                            anggotaList.add(anggota)
                        }
                    }

                    val adapter = BantenAdapter( this@Activity_ke3,
                        R.layout.activity_item_banten, anggotaList)
                    listData.adapter = adapter

                    println("Output : " +anggotaList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@Activity_ke3, "error: "+error, Toast.LENGTH_LONG).show()
            }
        })

        listData.setOnItemClickListener { parent, view, position, id ->
            val anggota = anggotaList.get(position)
            val intent = Intent(this@Activity_ke3, TambahBanten::class.java)
            intent.putExtra(TambahBanten.EXTRA_ID, anggota.id)
            intent.putExtra(TambahBanten.EXTRA_NAMA, anggota.nama)
            startActivity(intent)
        }
    }

    override fun onClick(v: View?) {
        simpanData()
    }

    private fun simpanData(){
        val nama = edNama.text.toString().trim()
        val alat = edAlat.text.toString()
        val bahan = edBahan.text.toString()
        val cara = edCara.text.toString().trim()

        if (nama.isEmpty()or alat.isEmpty() or bahan.isEmpty() or cara.isEmpty()){
            Toast.makeText( this, "Isi data secara lengkap tidak boleh kosong",
                Toast.LENGTH_SHORT).show()
            return
        }

        val anggotaId = ref.push().key
        val anggota = variabel_R_banten(anggotaId!!, nama, alat, bahan, cara)

        ref.child(anggotaId).setValue(anggota).addOnCompleteListener {
            Toast.makeText(
                applicationContext, "Data berhasil ditambahkan",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}