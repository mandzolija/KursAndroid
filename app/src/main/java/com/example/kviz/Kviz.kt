package com.example.kviz

class Kviz {

    //pitanje

    var pitanje1: PITANJE = PITANJE(textPitanja = "Pariz je glavni grad Njemačke? ", daLiJeTacno = false)
    var pitanje2: PITANJE = PITANJE(textPitanja = "Sarajevo je glavni grad Španije? ", daLiJeTacno = false)
    var pitanje3: PITANJE = PITANJE(textPitanja = "London je glavni grad Engleske? ", daLiJeTacno = true)
    var pitanje4: PITANJE = PITANJE(textPitanja = "Zagreb je glavni grad Hrvatske? ", daLiJeTacno = true)
    var pitanje5: PITANJE = PITANJE(textPitanja = "Tokio je glavni grad Japana? ", daLiJeTacno = true)

    var pitanja: List<PITANJE> = listOf(pitanje1, pitanje2, pitanje3, pitanje4, pitanje5 )
    

}