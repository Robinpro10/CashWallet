package com.example.cashwallet

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        val btnPerfil = findViewById<ImageButton>(R.id.btnPerfil)
        val btnDepositar = findViewById<ImageButton>(R.id.btnDepositar)
        val BtnEnviar = findViewById<ImageButton>(R.id.BtnEnviar)
        val btnCuenta = findViewById<ImageButton>(R.id.btnCuenta)
        val lblNombreUsuario = findViewById<TextView>(R.id.lblNombreUsuario)
        val lblSaldo = findViewById<TextView>(R.id.lblSaldo)

        val usuario: Usuario? = intent.getParcelableExtra<Usuario>("usuario")

        if (usuario != null) {
            // Aquí puedes usar los atributos del usuario
            lblNombreUsuario.text = "Hola, ${usuario.nombre}"
            lblSaldo.text = "$ ${usuario.saldo}"
        }

        // Capturar el evento del clic del boton btnPerfil
        btnPerfil.setOnClickListener()
        {
            val intent = Intent(this, Perfil::class.java).apply {
                putExtra("usuario", usuario) // Enviar el objeto Usuario
            }
            startActivity(intent)
        }

        // Capturar el evento del clic del boton btnDepositar
        btnDepositar.setOnClickListener()
        {
            val intent = Intent(this, DepositarHome::class.java).apply {
                    putExtra("usuario", usuario) // Enviar el objeto Usuario
            }
            startActivity(intent)
        }

        // Capturar el evento del clic del boton BtnEnviar
        BtnEnviar.setOnClickListener()
        {
            val intent = Intent(this, DepositarHome::class.java)
            startActivity(intent)
        }

    }
}