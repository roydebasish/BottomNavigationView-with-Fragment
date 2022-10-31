package com.example.bottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.bottomnavigation.fragments.FavouriteFragment
import com.example.bottomnavigation.fragments.HomeFragment
import com.example.bottomnavigation.fragments.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener

class MainActivity : AppCompatActivity() {

    lateinit var bottom_nav : BottomNavigationView
    var selectedFragment : Fragment ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_nav = findViewById(R.id.bottom_nav)
        replaceFragment(HomeFragment())

        bottom_nav.setOnItemSelectedListener {

            when(it.itemId){
                R.id.home -> replaceFragment(HomeFragment())
                R.id.favourite -> replaceFragment(FavouriteFragment())
                R.id.profile -> replaceFragment(ProfileFragment())

                else ->{

                }
            }

            true
        }

    }

    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit()
    }
}