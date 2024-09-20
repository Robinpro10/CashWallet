package com.example.cashwallet

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TransfDin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_transf_din)

        val spinTra: Spinner = findViewById(R.id.transpin)
        val trans: Button=findViewById(R.id.Transferir)


        val usuario: Usuario? = intent.getParcelableExtra<Usuario>("usuario")

        val items3 = listOf("Nequi", "Avvillas","Caja social")



        val adapter3 = ArrayAdapter(this, android.R.layout.simple_spinner_item, items3)
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinTra.adapter= adapter3
        val dep_2: EditText = findViewById(R.id.dep2)

        trans.setOnClickListener {
            val enviar = dep_2.text.toString().toDoubleOrNull()  // Obtener el texto y convertirlo a Double

            if (enviar != null) {  // Verificar que el valor no sea nulo
                if (usuario != null) {
                    usuario.saldo -= enviar  // Sumar el depósito al saldo

                    // Crear un Intent para regresar a la actividad Home
                    val home = Intent(this, Home::class.java).apply {
                        putExtra("usuario", usuario)  // Pasar el objeto usuario actualizado
                    }
                    startActivity(home)  // Iniciar la actividad Home
                } else {
                    Toast.makeText(this, "Usuario no encontrado", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Ingrese un valor válido", Toast.LENGTH_SHORT).show()  // Mostrar un mensaje si el valor no es válido
            }
        }

        }
    }