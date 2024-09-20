package com.example.cashwallet

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_third)


        val items = listOf("Nequi", "Avvilas","Caja social")
        val spin12: Spinner = findViewById(R.id.spinner12)
        val confirDep: Button = findViewById(R.id.ConfirDep)
        var depi: TextView = findViewById(R.id.deposito1)

        val bundle = intent.extras
        var dep = bundle?.getDouble("deposito") ?: 0.0
        depi.text= dep.toString()

        val usuario: Usuario? = intent.getParcelableExtra<Usuario>("usuario")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource (android.R.layout.simple_spinner_dropdown_item)

        spin12.adapter = adapter

        spin12.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long)
            {
                when(position){

                }


            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }

        // Sumar el depósito al saldo del usuario y actualizarlo
        confirDep.setOnClickListener {
            if (usuario != null) {
                usuario.saldo += dep  // Sumar el depósito al saldo

                // Crear un Intent para regresar a la actividad Home
                val home = Intent(this, Home::class.java).apply {
                    putExtra("usuario", usuario)  // Pasar el objeto usuario actualizado
                    putExtra("deposito", dep)  // Pasar depósito a ThirdActivity
                }
                startActivity(home)  // Iniciar la actividad Home
            } else {
                Toast.makeText(this, "Usuario no encontrado", Toast.LENGTH_SHORT).show()
            }
        }
    }
}