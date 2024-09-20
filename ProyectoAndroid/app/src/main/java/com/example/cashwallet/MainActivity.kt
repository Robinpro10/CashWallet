package com.example.cashwallet

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    // Crear un ArrayList de usuarios
    private val listaUsuarios = ArrayList<Usuario>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Agregar usuarios directamente al ArrayList
        listaUsuarios.add(
            Usuario(
                "123456789",   // Cédula
                "Juan Pérez",  // Nombre
                "01/01/1990",  // Fecha de nacimiento
                "password123", // Contraseña
                1000.00, //saldo
                "1234",        // Pin
                "3001234567",  // Teléfono
                "2000",        // Ingresos
                "juanperez@mail.com" // Correo
            )
        )

        listaUsuarios.add(
            Usuario(
                "987654321",   // Cédula
                "Ana García",  // Nombre
                "02/02/1985",  // Fecha de nacimiento
                "ana2023",     // Contraseña
                50.0,      // Saldo
                "4321",        // Pin
                "3109876543",  // Teléfono
                "2500",        // Ingresos
                "ana.garcia@mail.com" // Correo
            )
        )

        val btnRegistro = findViewById<Button>(R.id.btnRegistro)//capturar el boton registro
        val btnInicioSesion = findViewById<Button>(R.id.btnInicioSesion)//capturar el boton InicioSesion


        // Capturar el evento del clic del boton btnRegistro
        btnRegistro.setOnClickListener() {
            // Crear un Intent para navegar a la nueva Activity
            val intent = Intent(this, Registro::class.java).apply {
                putParcelableArrayListExtra("listaUsuarios", listaUsuarios)
            }
            startActivity(intent)
        }
        // Capturar el evento del clic del boton  btnInicioSesion
        btnInicioSesion.setOnClickListener() {
            // Crear un Intent para enviar la lista a otro Activity
            val intentIncio = Intent(this, IniciarSesion::class.java).apply {
                putParcelableArrayListExtra("listaUsuarios", listaUsuarios)
            }
            startActivity(intentIncio)
        }
    }

    private fun putParcelableArrayListExtra(s: String, usuario: Usuario?) {

    }
}