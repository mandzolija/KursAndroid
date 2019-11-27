package com.example.kviz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_kvizactivity.*

class kvizactivity : AppCompatActivity() {

    //KONSTANTE
    val NEXT: Int = 1
    val PREVIUS: Int = -1

    //VARIJABLE
    var kviz = Kviz()
    var trenutniIndexPITANJE = 0
    var rezultat: Int = 0
    var trenutnoPITANJE = kviz.pitanja[trenutniIndexPITANJE]

    //FUNKCIJE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kvizactivity)


        textView_brojpitanja.text = "Pitanje: ${trenutniIndexPITANJE + 1}/ ${kviz.pitanja.size}"
        textViewpitanje.text = trenutnoPITANJE.textPitanja
        textView_rezultat.text = "Rezultat: $rezultat"
        button_dalje.isEnabled = true
        button_nazad.isEnabled = false
        button_kraj.isEnabled = false


        //ON CLICK LISTENERI

        button_dalje.setOnClickListener {
            updateIndex(NEXT)
        }

        button_nazad.setOnClickListener {
            updateIndex(PREVIUS)
        }

        button_kraj.setOnClickListener {
            val intent = Intent (this,KrajActivity::class.java)
            intent.putExtra(KrajActivity.REZULTAT, rezultat)
            startActivity (intent)

        }
        //dugme da

        button_da.setOnClickListener {
           odgovori(true)
        }

        button_ne.setOnClickListener {
            odgovori(false)
        }
    }

    fun updateIndex(index: Int) {

        if (index == NEXT) {
            trenutniIndexPITANJE += 1
        } else if (index == PREVIUS) {
            trenutniIndexPITANJE -= 1
        }

        //AKO SMO NA PRVOM PTANJU
        if (trenutniIndexPITANJE == 0) {
            button_dalje.isEnabled = true
            button_nazad.isEnabled = false
            button_kraj.isEnabled = false
        }

        //AKO SMO NA ZADNJEM PTANJU
        else if (trenutniIndexPITANJE == kviz.pitanja.size - 1) {
            button_dalje.isEnabled = false
            button_nazad.isEnabled = true
            button_kraj.isEnabled = true
        } else {
            button_dalje.isEnabled = true
            button_nazad.isEnabled = true
            button_kraj.isEnabled = true
        }

        trenutnoPITANJE = kviz.pitanja [trenutniIndexPITANJE]
        textView_brojpitanja.text = "Pitanje: ${trenutniIndexPITANJE + 1}/ ${kviz.pitanja.size}"
        textViewpitanje.text = trenutnoPITANJE.textPitanja
        updateDANE()

    }

    private fun updateDANE() {
        if (trenutnoPITANJE.daLijeOdgovoreno) {
            button_da.isEnabled = false
            button_ne.isEnabled = false
        } else {
            button_da.isEnabled = true
            button_ne.isEnabled = true
        }
    }

    private fun odgovori (odgovor: Boolean) {
        trenutnoPITANJE.daLijeOdgovoreno = true

        if (trenutnoPITANJE.daLiJeTacno == odgovor) {
            Toast.makeText(this, "Vas odgovor je tacan", Toast.LENGTH_SHORT) .show()
            rezultat +=10
            textView_rezultat.text = "Rezultat: $rezultat"

        } else {
            Toast.makeText(this, "Vas odgovor je netacan", Toast.LENGTH_SHORT) .show()
        }
        updateDANE()
    }
}

