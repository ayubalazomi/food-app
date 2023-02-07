package com.example.applecationfood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.applecationfood.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
      var x= SharedPref(this)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navcontrolar = navHostFragment.navController
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.foodnav, R.id.settingnav)
        )
        binding.bottonall.setupWithNavController(navcontrolar)
        setupActionBarWithNavController(navcontrolar, appBarConfiguration)

          x.getFontSize()


    }
}