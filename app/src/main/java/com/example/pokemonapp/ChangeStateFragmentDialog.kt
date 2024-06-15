package com.example.pokemonapp

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import android.view.Window
import android.widget.RadioGroup
import androidx.appcompat.app.ActionBar.LayoutParams
import androidx.constraintlayout.widget.ConstraintSet.Layout
import androidx.fragment.app.DialogFragment

class ChangeStateFragmentDialog() : DialogFragment() {
   private var OnCheckedChangeListener : RadioGroup.OnCheckedChangeListener? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val dialog = activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.create()
        }?:throw IllegalStateException()
        val view = layoutInflater.inflate(R.layout.fragment_change_state_dialog, null)
        dialog.setView(view)
        dialog.context.setTheme(R.style.StateAlertDialog)
        dialog.window?.attributes.let {
            it?.gravity = Gravity.END or Gravity.TOP
            it?.verticalMargin = 0.15f
            it?.horizontalMargin = 0.1f
        }
        val radioGroup = view.findViewById<RadioGroup>(R.id.ChangeStateMod)
        radioGroup.setOnCheckedChangeListener(OnCheckedChangeListener)
        return dialog
    }
fun setonCheckedChangeListener (listener: RadioGroup.OnCheckedChangeListener){
    OnCheckedChangeListener = listener}
}


