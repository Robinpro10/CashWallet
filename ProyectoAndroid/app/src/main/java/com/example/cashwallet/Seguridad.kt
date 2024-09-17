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

class Seguridad : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_seguridad)

        val btnVolverS = findViewById<ImageButton>(R.id.btnVolverS)
        val btnActualizarS = findViewById<Button>(R.id.btnActualizarS)
        val tctContrasenaS = findViewById<EditText>(R.id.tctContraseñaS)
        val txtPinS = findViewById<EditText>(R.id.txtPinS)
        val lblContrasenaS = findViewById<TextView>(R.id.lblContraseñaS)
        val lblPinS= findViewById<TextView>(R.id.lblPinS)

        val usuario: Usuario? = intent.getParcelableExtra<Usuario>("usuario")
        val listaUsuarios: ArrayList<Usuario> = intent.getParcelableArrayListExtra("listaUsuarios") ?: ArrayList()

        if (usuario != null) {
            // Aquí puedes usar los atributos del usuario
            lblContrasenaS.text = usuario.contraseña
            lblPinS.text = usuario.pin

        }
        btnActualizarS.setOnClickListener()
        {
            if (!(tctContrasenaS.text.isEmpty() && txtPinS.text.isEmpty())) {
                // Actualizar los valores del objeto usuario con los nuevos datos ingresados
                usuario?.contraseña = tctContrasenaS.text.toString()
                usuario?.pin = txtPinS.text.toString()

                // Reemplazar el usuario actualizado en la lista
                val index = listaUsuarios.indexOfFirst { it.cedula == usuario?.cedula}
                if (index != -1) {
                    if (usuario != null) {
                        listaUsuarios[index] = usuario
                    }
                }

                val intent = Intent(this, Seguridad::class.java).apply {
                    putExtra("usuario", usuario) // Enviar el objeto Usuario
                }
                startActivity(intent)
            }
        }

        // Capturar el evento del clic del boton btnVolverP
        btnVolverS.setOnClickListener()
        {
            val intent = Intent(this, Perfil::class.java).apply {
                putExtra("usuario", usuario) // Enviar el objeto Usuario
            }
            startActivity(intent)
        }
    }
}