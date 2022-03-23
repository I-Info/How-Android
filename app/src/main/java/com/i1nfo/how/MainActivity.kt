package com.i1nfo.how

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)

        // bind navigation actions
        val navBar = findViewById<BottomNavigationView>(R.id.navigationBar)
        navBar.setupWithNavController(navController)

//        navBar.setOnItemSelectedListener { item ->
//            when(item.itemId) {
//                R.id.page_main ->{
//                    navController.navigate(R.id.page_main)
////                    Toast.makeText(applicationContext,"main",Toast.LENGTH_SHORT).show()
//                    true
//                }
//                R.id.page_activity ->{
//                    navController.navigate(R.id.page_activity)
////                    Toast.makeText(applicationContext,"activity",Toast.LENGTH_SHORT).show()
//                    true
//                }
//                R.id.page_message ->{
//                    navController.navigate(R.id.page_message)
////                    Toast.makeText(applicationContext,"message",Toast.LENGTH_SHORT).show()
//                    true
//                }
//                R.id.page_user->{
//                    navController.navigate(R.id.page_user)
////                    Toast.makeText(applicationContext,"user",Toast.LENGTH_SHORT).show()
//                    true
//                }
//                else -> false
//            }
//        }



    }
}