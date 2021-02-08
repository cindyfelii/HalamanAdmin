package com.farhan.halamanadmin1

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var toogle: ActionBarDrawerToggle
    lateinit var jawaFragment: HalamanJawa
    lateinit var kalimantanFragment: HalamanKalimantan
    lateinit var papuaFragment: HalamanPapua
    lateinit var sulawesiFragment: HalamanSulawesi
    lateinit var sumatraFragment: HalamanSumatra

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toogle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toogle)
        toogle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.hal_sumatra -> {
                sumatraFragment = HalamanSumatra()
                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, sumatraFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                Toast.makeText(applicationContext, "Sumatra", Toast.LENGTH_SHORT)
                        .show()
            }
            R.id.hal_jawa -> {
                jawaFragment = HalamanJawa()
                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, jawaFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                Toast.makeText(applicationContext, "Jawa", Toast.LENGTH_SHORT)
                        .show()
            }
            R.id.hal_kalimantan -> {
                kalimantanFragment = HalamanKalimantan()
                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, kalimantanFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                Toast.makeText(applicationContext, "Kalimantan", Toast.LENGTH_SHORT)
                        .show()
            }
            R.id.hal_sulawesi -> {
                sulawesiFragment = HalamanSulawesi()
                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, sulawesiFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                Toast.makeText(applicationContext, "Sulawesi", Toast.LENGTH_SHORT)
                        .show()
            }
            R.id.hal_papua -> {
                papuaFragment = HalamanPapua()
                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, papuaFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                Toast.makeText(applicationContext, "Papua", Toast.LENGTH_SHORT)
                        .show()
            }
        }
        drawerLayout.closeDrawers()
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toogle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}