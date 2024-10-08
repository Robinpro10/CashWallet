package com.example.cashwallet

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Registro : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registro)

        // Puedes seguir agregando más usuarios de la misma manera
        val btnVolverRegistro = findViewById<ImageButton>(R.id.btnContinuarRegistro)
        val btnContinuarRegistro = findViewById<ImageButton>(R.id.btnContinuarRegistro)
        val txtNcedula = findViewById<EditText>(R.id.txtNcedula)
        val txtNombre = findViewById<EditText>(R.id.txtNombre)
        val txtFachaNacimiento = findViewById<EditText>(R.id.txtFachaNacimiento)
        val txtContraseña = findViewById<EditText>(R.id.txtContraseña)
        val txtSaldo = findViewById<EditText>(R.id.lblSaldo)
        val txtPin = findViewById<EditText>(R.id.txtPin)
        val txtTelefono = findViewById<EditText>(R.id.txtTelefono)
        val txtIngresos = findViewById<EditText>(R.id.txtIngresos)
        val txtCorreo = findViewById<EditText>(R.id.txtCorreo)
        val spnTipoC = findViewById<Spinner>(R.id.spnTipoC)

        // Recuperar la lista de usuarios desde el Intent
        val listaUsuarios: ArrayList<Usuario> = intent.getParcelableArrayListExtra("listaUsuarios") ?: ArrayList()
        val usuario: Usuario? = intent.getParcelableExtra<Usuario>("usuario")

        //mostrar los valores del spinner
        val itemTipoC = listOf("Cedula", "Tarjeta Identidad","Identificacion Extrangera")
        val adapter3 = ArrayAdapter(this, android.R.layout.simple_spinner_item, itemTipoC)
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spnTipoC.adapter= adapter3


        // Capturar el evento del clic del boton btnVolverRegistro
        btnVolverRegistro.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // Capturar el evento del clic del boton btnContinuarRegistro
        btnContinuarRegistro.setOnClickListener() {

            val saldo = txtSaldo.text.toString().toDoubleOrNull() ?: 0.0

            if(txtNcedula.text.isNotEmpty() && txtNombre.text.isNotEmpty() && txtFachaNacimiento.text.isNotEmpty() && txtContraseña.text.isNotEmpty() &&
                txtSaldo.text.isNotEmpty() && txtPin.text.isNotEmpty() && txtTelefono.text.isNotEmpty() && txtIngresos.text.isNotEmpty() && txtCorreo.text.isNotEmpty() )
            {
                // Crear un nuevo objeto Usuario con los datos ingresados
                val nuevoUsuario = Usuario(
                    txtNcedula.text.toString(),
                    txtNombre.text.toString(),
                    txtFachaNacimiento.text.toString(),
                    txtContraseña.text.toString(),
                    saldo,
                    txtPin.text.toString(),
                    txtTelefono.text.toString(),
                    txtIngresos.text.toString(),
                    txtCorreo.text.toString()
                )
                // Agregar el nuevo usuario a la listas
                listaUsuarios.add(nuevoUsuario)

                // Crear un Intent para enviar la lista a otro Activity
                val intentIncio = Intent(this, IniciarSesion::class.java).apply {
                    putExtra("listaUsuarios", listaUsuarios) // Enviar el objeto Usuario
                }
                startActivity(intentIncio)
            }
        }
    }
}