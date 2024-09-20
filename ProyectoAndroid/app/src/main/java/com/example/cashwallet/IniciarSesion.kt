package com.example.cashwallet

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
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
        val bntMiraPass = findViewById<ImageView>(R.id.bntMiraPass)


        // Recuperar la lista de usuarios desde el Intent
        val listaUsuarios: ArrayList<Usuario> = intent.getParcelableArrayListExtra("listaUsuarios") ?: ArrayList()


        // Capturar el evento del clic del boton btnVolverRegistro
        btnVolver.setOnClickListener()
        {
            //redirigir al activity MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        bntMiraPass.setOnClickListener {
            if (txtContraseñaInicio.inputType == InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD) {
                // Mostrar la contraseña
                txtContraseñaInicio.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            } else {
                // Ocultar la contraseña
                txtContraseñaInicio.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            }

            // Mover el cursor al final del texto después de cambiar el inputType
            txtContraseñaInicio.setSelection(txtContraseñaInicio.text.length)
        }

        // Capturar el evento del clic del botón btnIniciarSesion
        btnIniciarSesion.setOnClickListener {

            if (txtContraseñaInicio.text.isNotEmpty()) {
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
}
