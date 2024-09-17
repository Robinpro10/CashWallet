package com.example.cashwallet

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView.EdgeEffectFactory.EdgeDirection

class IniciarSesion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_iniciar_sesion)


        val btnVolver = findViewById<ImageButton>(R.id.btnVolver)
        val btnIniciarSesion = findViewById<ImageButton>(R.id.btnIniciarSesion)
        val txtContraseñaInicio = findViewById<EditText>(R.id.txtContraseñaInicio)
        val txtResultado = findViewById<TextView>(R.id.txtResultado) //para mostrar si es correcta o incorrecta la contraseña

        // Recuperar la lista de usuarios desde el Intent
        val listaUsuarios: ArrayList<Usuario> = intent.getParcelableArrayListExtra("listaUsuarios") ?: ArrayList()


        // Capturar el evento del clic del boton btnVolverRegistro
        btnVolver.setOnClickListener()
        {
            //redirigir al activity MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // Capturar el evento del clic del botón btnIniciarSesion
        btnIniciarSesion.setOnClickListener {
            val contraseñaIngresada = txtContraseñaInicio.text.toString()
            val usuarioEncontrado = listaUsuarios.find { it.contraseña == contraseñaIngresada }

            if (usuarioEncontrado != null) {
                // Contraseña correcta
                txtResultado.text = "¡Inicio de sesión exitoso!"

                // Enviar los datos del usuario a otros Activitys
                val intentHome = Intent(this, Home::class.java).apply {
                    putExtra("usuario", usuarioEncontrado) // Enviar el objeto Usuario
                    //putParcelableArrayListExtra("listaUsuarios", listaUsuarios)
                }
                startActivity(intentHome)
            } else {
                // Contraseña incorrecta
                txtResultado.text = "Contraseña incorrecta. Inténtalo de nuevo."
                txtContraseñaInicio.text.clear()
            }

        }

    }
}
