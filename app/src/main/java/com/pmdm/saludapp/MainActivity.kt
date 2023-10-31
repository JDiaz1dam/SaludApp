package com.pmdm.saludapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnhello: Button = findViewById(R.id.btmhello)
        val etName: AppCompatEditText = findViewById(R.id.etName)

        btnhello.setOnClickListener {
            //Log.i("Test", "Botón pulsado")
            val name = etName.text.toString()
            //Toast.makeText(this, "Hola $name!",Toast.LENGTH_LONG).show()
            if (name.isNotEmpty()) {
                Snackbar.make(btnhello, "Hola $name!", Snackbar.LENGTH_LONG)
                    .setAnchorView(etName)
                    .setAction("NEXT SCREEN") {
                        val intentGA = Intent(this, GreetingActivity::class.java)
                        intentGA.putExtra("EXTRA_NAME", name)
                        startActivity(intentGA)
                    }
                    .show()
            } else {
                Toast.makeText(this, "Introduce el nombre", Toast.LENGTH_LONG).show()
            }
        }
    }
}

//.setAction("RESET") {
    //finishAffinity()
    //etName.setText(null)