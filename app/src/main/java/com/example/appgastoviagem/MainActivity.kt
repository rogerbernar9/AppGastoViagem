package com.example.appgastoviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val id = v.id
        if (id == R.id.buttonCalculate) {
            calculate()
        }

    }

    private fun calculate() {
        if (validation()) {
            try {
                val distance = editDistance.text.toString().toFloat()
                val price = editPrice.text.toString().toFloat()
                val autonomy = editAutonomy.text.toString().toFloat()
                val valorFinal = (distance * price) / autonomy
                totalValue.text = "R$ ${"%.2f".format(valorFinal)}"
            } catch (nfe: NumberFormatException) {
                Toast.makeText(this, getString(R.string.valoresValidos), Toast.LENGTH_LONG).show()
            }

        } else
            Toast.makeText(this, getString(R.string.notificacao), Toast.LENGTH_LONG).show()
    }

    private fun validation(): Boolean {
        val distance = editDistance.text.toString()
        val price = editPrice.text.toString()
        val autonomy = editAutonomy.text.toString()
        if (distance == "" || price == "" || autonomy == "") {
            return false
        }
        return true
    }
}