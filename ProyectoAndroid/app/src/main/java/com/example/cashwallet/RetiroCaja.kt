package com.example.cashwallet

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class RetiroCaja : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_retiro_caja)

        val btnDepositarR = findViewById<ImageButton>(R.id.btnDepositarR)
        val btnVolverC = findViewById<ImageButton>(R.id.btnVolverC)
        val btnBorrarR = findViewById<ImageButton>(R.id.btnBorrarR)
        val lblSaldoCaja = findViewById<TextView>(R.id.lblSaldoCaja)
        val txtCajaDepo = findViewById<EditText>(R.id.txtCajaDepo)
        val txtResultadoR = findViewById<TextView>(R.id.txtResultadoR)

        val usuario: Usuario? = intent.getParcelableExtra<Usuario>("usuario")


        val bundle = intent.extras
        var SaldoCajaT = bundle?.getDouble("saldoCajaT") ?: 0.0
        lblSaldoCaja.text= SaldoCajaT.toString()
        var SaldoC = bundle?.getDouble("saldoC") ?: 0.0


        btnDepositarR.setOnClickListener()
        {
            if (usuario != null) {
                val deposito = txtCajaDepo.text.toString().toDoubleOrNull()  // Convertir a

                if (txtCajaDepo.text.isEmpty()) {
                    txtResultadoR.text = "El campo de depósito no puede estar vacío"
                } else if (deposito != null && deposito > 0 && deposito <= usuario.saldo) {

                    usuario.saldo -= deposito
                    SaldoCajaT += deposito
                    SaldoC += deposito
                    val intent = Intent(this, CajasHome::class.java).apply {
                        putExtra("usuario", usuario) // Enviar el objeto Usuario
                        putExtra("saldoCajaT", SaldoCajaT)
                        putExtra("saldoC", SaldoC)
                    }
                    startActivity(intent)
                } else {
                    txtResultadoR.text = "El depósito debe ser mayor a 0.0"
                    txtCajaDepo.text.clear()
                }
            }else {
                Toast.makeText(this, "Usuario no encontrado", Toast.LENGTH_SHORT).show()
            }
        }

        btnBorrarR.setOnClickListener()
        {
            txtCajaDepo.text.clear()
        }

        btnVolverC.setOnClickListener()
        {
            val intent = Intent(this, CajasHome::class.java).apply {
                putExtra("usuario", usuario) // Enviar el objeto Usuario
            }
            startActivity(intent)
        }

    }
}