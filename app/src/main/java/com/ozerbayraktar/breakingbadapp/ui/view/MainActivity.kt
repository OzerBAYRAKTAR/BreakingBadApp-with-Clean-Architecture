package com.ozerbayraktar.breakingbadapp.ui.view

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.PopupMenu
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.ozerbayraktar.breakingbadapp.R
import com.ozerbayraktar.breakingbadapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.toolbarApp.setBackgroundColor(Color.parseColor("#DCCE4B"))

       /* val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        val navController = navHostFragment.navController
        val appbarConfig = AppBarConfiguration(
            navGraph = navController.graph
        )
        binding.toolbarApp.setupWithNavController(navController, appbarConfig)

        binding.bottomNavigation.setupWithNavController(navHostFragment.navController)

        */

         binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {

                R.id.characterList -> replaceFragment(CharacterList())
                R.id.episodeList -> replaceFragment(EpisodeList())
                R.id.quoteList -> replaceFragment(QuoteList())
            }
            true
        }

    }
    fun replaceFragment(fragment: Fragment) {
        val fragmentManager=supportFragmentManager
        val fragmentTransaction=fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.nav_host_fragment,fragment)
        fragmentTransaction.commit()
    }
}
