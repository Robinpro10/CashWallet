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

class DatosPersonales : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_datos_personales)

        val btnVolverP = findViewById<ImageButton>(R.id.btnVolverP)
        val btnActualizarC = findViewById<Button>(R.id.btnActualizarC)
        val txtNombreC = findViewById<EditText>(R.id.txtNombreC)
        val txtCorreoC = findViewById<EditText>(R.id.txtCorreoC)
        val txtTelefonoC = findViewById<EditText>(R.id.txtTelefonoC)
        val txtIngresosC = findViewById<EditText>(R.id.txtIngresosC)
        val lblNombreC = findViewById<TextView>(R.id.lblNombreC)
        val lblCorreoC = findViewById<TextView>(R.id.lblCorreoC)
        val lblTelefonoC = findViewById<TextView>(R.id.lblTelefonoC)
        val lblIngresosC = findViewById<TextView>(R.id.lblIngresosC)

        val usuario: Usuario? = intent.getParcelableExtra<Usuario>("usuario")
        val listaUsuarios: ArrayList<Usuario> = intent.getParcelableArrayListExtra("listaUsuarios") ?: ArrayList()

        if (usuario != null) {
            //atributos del usuario
            lblNombreC.text = usuario.nombre
            lblCorreoC.text = usuario.correo
            lblTelefonoC.text = usuario.telefono
            lblIngresosC.text = usuario.ingresos
        }

        // Capturar el evento del clic del boton btnActualizarC
        btnActualizarC.setOnClickListener()
        {
            if (!(txtNombreC.text.isEmpty() && txtCorreoC.text.isEmpty() && txtTelefonoC.text.isEmpty() && txtIngresosC.text.isEmpty())) {
                // Actualizar los valores del objeto usuario con los nuevos datos ingresados
                usuario?.nombre = txtNombreC.text.toString()
                usuario?.correo = txtCorreoC.text.toString()
                usuario?.telefono = txtTelefonoC.text.toString()
                usuario?.ingresos = txtIngresosC.text.toString()

                // Reemplazar el usuario actualizado en la lista
                val index = listaUsuarios.indexOfFirst { it.cedula == usuario?.cedula}
                if (index != -1) {
                    if (usuario != null) {
                        listaUsuarios[index] = usuario
                    }
                }

                val intent = Intent(this, DatosPersonales::class.java).apply {
                    putExtra("usuario", usuario) // Enviar el objeto Usuario
                }
                startActivity(intent)
            }
        }

        // Capturar el evento del clic del boton btnVolverP
        btnVolverP.setOnClickListener()
        {
            val intent = Intent(this, Perfil::class.java).apply {
                putExtra("usuario", usuario) // Enviar el objeto Usuario
            }
            startActivity(intent)
        }
    }
}