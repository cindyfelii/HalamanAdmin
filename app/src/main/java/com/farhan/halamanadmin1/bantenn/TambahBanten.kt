package com.farhan.halamanadmin1.bantenn

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*
import com.farhan.halamanadmin1.R

class TambahBanten : AppCompatActivity(){
    private lateinit var judul : TextView
    private lateinit var edtAlat : EditText
    private lateinit var edtBahan : EditText
    private lateinit var edtCara : EditText
    private lateinit var btnSimpan : Button
    private lateinit var lvTambahDetil : ListView
    private lateinit var detilList : MutableList<DetilBanten>
    private lateinit var ref : DatabaseReference

    companion object{
        const val EXTRA_ID = "extra_id"
        const val EXTRA_NAMA ="extra_nama"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_detil_banten)

        judul = findViewById(R.id.txt_judul_detil)
        edtAlat = findViewById(R.id.edtAlat)
        edtBahan = findViewById(R.id.edt_bahan)
        edtCara = findViewById(R.id.edt_cara)
        btnSimpan = findViewById(R.id.btn_tambahDetil)
        lvTambahDetil = findViewById(R.id.lv_tambahDetil)

        val id = intent.getStringExtra(EXTRA_ID)
        val nama = intent.getStringExtra(EXTRA_NAMA)

        detilList = mutableListOf()
        ref = FirebaseDatabase.getInstance().getReference("detil anggota")
            .child(id!!)

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    detilList.clear()
                    for (a in snapshot.children){
                        val detil = a.getValue(DetilBanten::class.java)
                        if (detil != null){
                            detilList.add(detil)
                        }
                    }

                    val adapter = DetilBantenAdapter(this@TambahBanten,
                        R.layout.activity_item_detil_banten, detilList)
                    lvTambahDetil.adapter = adapter

                    println("Output : " + detilList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

        btnSimpan.setOnClickListener {
            simpanDetil()
        }
    }

    private fun simpanDetil(){
        val alat = edtAlat.text.toString().trim()
        val bahan = edtBahan.text.toString()
        val cara = edtCara.text.toString()

        if(alat.isEmpty()){
            edtAlat.error = "Isi alat terlebih dahulu"
            return
        }
        if(bahan.isEmpty()){
            edtBahan.error = "Isi bahan terlebih dahulu"
            return
        }
        if(cara.isEmpty()){
            edtCara.error = "Isi cara terlebih dahulu"
            return
        }
        val detilId = ref.push().key

        val detil = DetilBanten(detilId!!, alat, bahan, cara)

        ref.child(detilId).setValue(detil).addOnCompleteListener {
            Toast.makeText(applicationContext, "Informasi tambahan berhasil ditambahkan",
                Toast.LENGTH_SHORT)
                .show()
        }
    }

}