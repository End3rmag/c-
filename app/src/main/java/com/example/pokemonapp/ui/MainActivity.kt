package com.example.pokemonapp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.pokemonapp.R
import com.example.pokemonapp.ui.Screen.MainScreen
import com.example.pokemonapp.ui.models.MainScreenViewModel

class MainActivity : AppCompatActivity() {
    val viewModel:MainScreenViewModel by viewModels()
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.setFragmentManager(supportFragmentManager)
        supportFragmentManager.commit {
            add<MainScreen>(R.id.Host_fragment)
            addToBackStack(null)
        }
    }
}
