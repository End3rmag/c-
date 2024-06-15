package com.example.pokemonapp.Screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ImageButton
import android.widget.RadioGroup
import android.widget.Toast
import com.example.pokemonapp.ChangeStateFragmentDialog
import com.example.pokemonapp.R


class MainScreen : Fragment(R.layout.fragment_activity) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val ChangeModeButton = view.findViewById<ImageButton>(R.id.ChangeMode)
        val dialog = ChangeStateFragmentDialog()
        val checkedChangeListener = RadioGroup.OnCheckedChangeListener{
            group: RadioGroup?, checkedId: Int ->
            when(checkedId){
                R.id.NumberCheck -> {
                    setSortByNumber(view)
                }

                R.id.NameCheck -> {
                    setSortByName(view)
                }
            }
            dialog.dismiss()
        }
        dialog.setonCheckedChangeListener(checkedChangeListener)
        ChangeModeButton.setOnClickListener{dialog.show(parentFragmentManager,
            "ChangesStateDialog")
        }

    }
    fun setSortByName(view:View){
        val imageButton = view.findViewById<ImageButton>(R.id.ChangeMode)
        imageButton.setImageResource(R.drawable.text_format)}

    fun setSortByNumber(view: View){
        val imageButton=view.findViewById<ImageButton>(R.id.ChangeMode)
        imageButton.setImageResource(R.drawable.tag_ic)
    }
}


