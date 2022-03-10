package com.example.kotlintest

import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class pruebas : AppCompatActivity() {
    private fun metodo(){//private FUNction. En vez de metodo
        var variable: Int=1 //es rebundante poner int porque poner 100 ya lo hace int
        var variable2 = 3_000_000_000 //poner _ es como decir que hay espacio
        //poner el raton sobre el nombre de la var te dice el tipo que es

        var variableBoolean= false
        var variableLong= 100L//L es long
        var variableDouble= 100.1
        var variableFloat= 100.1f//esto es igual que java
        var variableTexto="texto"
        var variableChar='k'

        var variableNull=Unit//ahora esto es null
        //var variableNull : Unit =Unit//Lo mismo que arriba

    }

}