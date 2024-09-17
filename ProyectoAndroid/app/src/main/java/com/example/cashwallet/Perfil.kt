package com.example.cashwallet

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Perfil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_perfil)

        val btnVolverHome = findViewById<ImageButton>(R.id.btnVolverHome)
        val btnConfiguracion = findViewById<ImageButton>(R.id.btnConfiguracion)
        val btnSeguridad = findViewById<ImageButton>(R.id.btnSeguridad)
        val btnSalirApp = findViewById<ImageButton>(R.id.btnSalirApp)
        val lblNombreUsuario = findViewById<TextView>(R.id.lblNombre)

        val usuario: Usuario? = intent.getParcelableExtra<Usuario>("usuario")
        val listaUsuarios: ArrayList<Usuario> = intent.getParcelableArrayListExtra("listaUsuarios") ?: ArrayList()

        if (usuario != null) {
            // Aquí puedes usar los atributos del usuario
            lblNombreUsuario.text = "Hola, ${usuario.nombre}"
        }

        // Capturar el evento del clic del boton btnVolverHome
        btnVolverHome.setOnClickListener()
        {
            val intent = Intent(this, Home::class.java).apply {
                putExtra("usuario", usuario) // Enviar el objeto Usuario
            }

            startActivity(intent)
        }

        // Capturar el evento del clic del boton btnConfiguracion
        btnConfiguracion.setOnClickListener()
        {
            val intent = Intent(this, DatosPersonales::class.java).apply {
                putExtra("usuario", usuario) // Enviar el objeto Usuario
            }
            startActivity(intent)
        }

        // Capturar el evento del clic del boton btnSeguridad
        btnSeguridad.setOnClickListener()
        {
            val intent = Intent(this, Seguridad::class.java).apply {
                putExtra("usuario", usuario) // Enviar el objeto Usuario
            }
            startActivity(intent)
        }

        // Capturar el evento del clic del boton btnSalirApp
        btnSalirApp.setOnClickListener()
        {
            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra("usuario", usuario) // Enviar el objeto Usuario
                putParcelableArrayListExtra("listaUsuarios", listaUsuarios)
            }
            startActivity(intent)
        }




    }
}