package com.example.cashwallet

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CajasHome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cajas_home)

        val btnVolverHome2 = findViewById<ImageButton>(R.id.btnVolverHome2)
        val btnAgregar = findViewById<ImageButton>(R.id.btnAgregar)
        val lblNombreCaja = findViewById<TextView>(R.id.lblNombreCaja)
        val lblSaldoCajaT = findViewById<TextView>(R.id.lblSaldoCajaT)
        val lblrendimientoT = findViewById<TextView>(R.id.lblrendimientoT)
        val lblsaldoC = findViewById<TextView>(R.id.lblsaldoC)
        val lblrendimientoC = findViewById<TextView>(R.id.lblrendimientoC)
        val divCaja = findViewById<TextView>(R.id.divCaja)
        val btnDepositarCaja = findViewById<Button>(R.id.btnDepositarCaja)
        val btnRetirarC = findViewById<Button>(R.id.btnRetirarC)


        val usuario: Usuario? = intent.getParcelableExtra<Usuario>("usuario")
        /*val SaldoCajaT = intent.getStringExtra("saldoCajaT")
        val SaldoC = intent.getStringExtra("saldoC")*/
        val bundle = intent.extras

        var SaldoCajaT = bundle?.getDouble("saldoCajaT") ?: 0.0
        var SaldoC = bundle?.getDouble("saldoC") ?: 0.0

        if(SaldoCajaT != null  && SaldoC != null)
        {
            lblSaldoCajaT.text = "$ $SaldoCajaT"
            lblsaldoC.text = "$ $SaldoC"
        }


        // Inicialmente ocultamos los botones
        btnDepositarCaja.visibility = View.GONE
        btnRetirarC.visibility = View.GONE

        if (usuario != null) {
            // Aquí puedes usar los atributos del usuario
        }

        btnVolverHome2.setOnClickListener()
        {
            val intent = Intent(this, Home::class.java).apply {
                putExtra("usuario", usuario) // Enviar el objeto Usuario
            }
            startActivity(intent)
        }

        // Mostrar los botones cuando se hace clic en divCaja
        divCaja.setOnClickListener {
            // Cambiar la visibilidad de los botones
            if (btnDepositarCaja.visibility == View.GONE && btnRetirarC.visibility == View.GONE) {
                btnDepositarCaja.visibility = View.VISIBLE
                btnRetirarC.visibility = View.VISIBLE

                // Al hacer clic en el botón Depositar
                btnDepositarCaja.setOnClickListener {

                    // Enviar los valores a otra actividad (por ejemplo, una actividad de resumen)
                    val intent = Intent(this, RetiroCaja::class.java).apply {
                        putExtra("usuario", usuario) // Enviar el objeto Usuario
                        putExtra("saldoCajaT", SaldoCajaT)
                        putExtra("saldoC", SaldoC)
                    }
                    startActivity(intent)
                }
                // Al hacer clic en el botón Retirar
                btnRetirarC.setOnClickListener {

                    // Enviar los valores a otra actividad (por ejemplo, una actividad de resumen)
                    val intent = Intent(this, RetiroCaja::class.java).apply {
                        putExtra("usuario", usuario) // Enviar el objeto Usuario
                        putExtra("saldoCajaT", SaldoCajaT)
                        putExtra("saldoC", SaldoC)
                    }
                    startActivity(intent)
                }
            } else {
                btnDepositarCaja.visibility = View.GONE
                btnRetirarC.visibility = View.GONE
            }
        }


    }
}