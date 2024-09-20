package com.example.cashwallet

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class DatosPSE : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.datos_pse)

        val spin1: Spinner = findViewById(R.id.TipoPer)
        val spin2: Spinner = findViewById(R.id.TipoDoc)
        val nom: EditText = findViewById(R.id.NomDat)
        val apell: EditText = findViewById(R.id.ApellDat)
        val num: EditText = findViewById(R.id.NumDat)
        val em: EditText = findViewById(R.id.Email)
        val spin3: Spinner = findViewById(R.id.TipoBanco)
        val continuar: Button = findViewById(R.id.Continuar)

        val usuario: Usuario? = intent.getParcelableExtra<Usuario>("usuario")


        val items = listOf("Natural", "Jurídica")
        val items2 = listOf("CC", "TI")
        val items3 = listOf("Nequi", "Avvillas","Caja social")


        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        val adapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, items2)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        val adapter3 = ArrayAdapter(this, android.R.layout.simple_spinner_item, items3)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spin1.adapter = adapter


        spin1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long)
            {
               when(position){

               }


            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }


    spin2.adapter=adapter2

    spin2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long)
        {
            when(position){

            }


        }

        override fun onNothingSelected(parent: AdapterView<*>) {

        }
    }


        spin3.adapter=adapter3

        spin3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long)
            {
                when(position){

                }


            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }


        continuar.setOnClickListener {
            val bundle = intent.extras
            val deposito = bundle?.getDouble("deposito")
            val saldo = usuario?.saldo

            if (saldo != null && deposito != null) {
                val conti = Intent(this, ThirdActivity::class.java).apply {
                    putExtra("deposito", deposito)  // Pasar depósito a ThirdActivity
                    putExtra("usuario", usuario) // Enviar el objeto Usuario
                }
                startActivity(conti)
            }
        }



    }
}












