package com.example.toepapp.fragments

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.toepapp.R
import com.example.toepapp.models.Player
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.fragment_game.*

class GameFragment : Fragment() {

    private lateinit var fragmentTransaction: FragmentTransaction

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }


    private fun initViews() {



        addAPlayer.setOnClickListener {
            addPlayer()
        }
    }

    @SuppressLint("InflateParams")
    private fun addPlayer() {
        val dialogBuilder: AlertDialog.Builder = AlertDialog.Builder(context)
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val dialogView: View = inflater.inflate(R.layout.add_player,null)
        val editText = dialogView.findViewById<View>(R.id.et_playerName) as TextInputEditText

        dialogBuilder
            .setTitle("Add a player")
            .setView(dialogView)
            .setNegativeButton("Cancel") { _: DialogInterface, _: Int -> }
            .setPositiveButton("Add") { _: DialogInterface, _: Int ->
                val newPlayer = Player()
            }.create().show()
    }
}