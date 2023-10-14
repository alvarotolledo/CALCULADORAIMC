package com.example.primeiroprojeto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity() : AppCompatActivity(), Parcelable {

    constructor(parcel: Parcel) : this() {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivity> {
        override fun createFromParcel(parcel: Parcel): MainActivity {
            return MainActivity(parcel)
        }

        override fun newArray(size: Int): Array<MainActivity?> {
            return arrayOfNulls(size)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalcular: Button = findViewById(R.id.bntCaucular)
        val edtPeso: EditText = findViewById(R.id.edttextpeso)
        val edtAltura: EditText = findViewById(R.id.edttextaltura)
        val tvResultado: TextView = findViewById(R.id.txtMsg)

        btnCalcular.setOnClickListener {


            val alturaStr = edtAltura.text.toString()
            val pesoStr = edtPeso.text.toString()

            if (alturaStr.isNotEmpty() && pesoStr.isNotEmpty()) {


                val altura: Float = alturaStr.toFloat()
                val alturaFinal: Float = altura * altura

                val peso: Float = pesoStr.toFloat()
                val result = peso / alturaFinal

                //mostrar resultado
                tvResultado.text = result.toString()
                val intent = Intent(this, ResultActivity::class.java)
                    .apply {
                        putExtra("EXTRA_RESULT", result)
                    }
                startActivity(intent)
            } else {
                Toast.makeText(this, "PREENCHER TODOS OS CAMPOS", Toast.LENGTH_LONG).show()
            }
        }
    }
}
