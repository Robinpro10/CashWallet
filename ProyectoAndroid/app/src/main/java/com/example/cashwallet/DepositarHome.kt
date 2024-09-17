package com.example.cashwallet

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DepositarHome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_depositar_home)

        val btnDepositarD = findViewById<ImageButton>(R.id.btnDepositarD)
        val btnCancelar = findViewById<ImageButton>(R.id.btnCancelar)
        val btnBorrar = findViewById<ImageButton>(R.id.btnBorrar)
        val lblSaldo = findViewById<TextView>(R.id.lblSaldo)
        val txtDepositar = findViewById<EditText>(R.id.txtDepositar)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)

        val usuario: Usuario? = intent.getParcelableExtra<Usuario>("usuario")

        if (usuario != null) {
            // Aquí puedes usar los atributos del usuario
            lblSaldo.text = "$ ${usuario.saldo}"
        }

        btnDepositarD.setOnClickListener()
        {
            val deposito = txtDepositar.text.toString().toDoubleOrNull()  // Convertir a número
            if (deposito != null && deposito > 0) {
                val intent = Intent(this, Home::class.java)  // Cambiar el nombre de la Activity si es necesario
                startActivity(intent)
            }
            else
            {
                // monto menor a 0
                txtResultado.text = "El doposito debe ser mayor a 0.0"
                txtDepositar.text.clear()
            }
        }

        // Capturar el evento del clic del boton btnCancelar
        btnCancelar.setOnClickListener()
        {
            val intent = Intent(this, Home::class.java).apply {
            putExtra("usuario", usuario) // Enviar el objeto Usuario
        }
            startActivity(intent)
        }

        // Capturar el evento del clic del boton btnCancelar
        btnBorrar.setOnClickListener()
        {
            txtDepositar.text.clear()
        }


    }
}