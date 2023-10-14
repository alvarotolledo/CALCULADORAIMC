package com.example.primeiroprojeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // BOTTOM VISUAL PARA VOLTAR
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // IMPORTA ARQUIVOS
        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvclassificacao = findViewById<TextView>(R.id.textview_classificacao)
        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvResult.text = result.toString()


        var classificacao = " "
        if (result < 18.5f){
            classificacao  ="ABAIXO DO PESO"
        }else if (result >= 18.5f && result <= 24.9){
            classificacao  ="NORMAL"
        }else if (result >= 25f && result <= 29.9f){
            classificacao ="SOBREPESO"
        }else if ( result >= 30f && result <= 39.9f ){
            classificacao  ="OBSIDADE"
        }else if (result >= 50f  && result <= 59.9f){
            classificacao  ="OBSIDADE GRAVE"
        }else {
            classificacao  ="OBSIDADE GRAVISSIMA"
        }
        tvclassificacao.text = getString(R.string.menssage_classificacao, classificacao)


    }

      // AÇÃO DE VOLTAR

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)

    }
}
