package com.example.kviz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_kraj.*

class KrajActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kraj)

        val rezultat = intent.getIntExtra(REZULTAT, 0)
        textView.text = "VAS REZULTAT je $rezultat"

        }
    companion object  {
        const val REZULTAT = "REZULTAT"
    }
}
