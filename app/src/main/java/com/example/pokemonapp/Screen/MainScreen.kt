package com.example.pokemonapp.Screen

import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import androidx.fragment.app.Fragment
import android.view.MenuInflater
import android.view.View
import android.widget.ImageButton
import androidx.annotation.StyleRes
import androidx.appcompat.widget.PopupMenu
import com.example.pokemonapp.R


class MainScreen : Fragment(R.layout.fragment_activity){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val ChangeModeButton = view.findViewById<ImageButton>(R.id.ChangeMode)
        ChangeModeButton.setOnClickListener{
            val menu = PopupMenu(requireContext(),it)

            val inflater: MenuInflater = menu.menuInflater
            inflater.inflate(R.menu.search_menu,menu.menu)
            menu.show()
        }

    }
}
