package com.example.kotlintest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var texto : EditText//lateinit es que mas tarde la vas a dar valor
    //lateinit no puede ser de tipos primitivos (aka int, double..)3
    private lateinit var boton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val CONSTANT = "com.example.kotlintest.CONSTANT"
        texto=findViewById(R.id.textoo)//ahora le das valor
        boton=findViewById(R.id.button)

        if(this::texto.isInitialized){
            println("esta inicializada lol")}//si esta inicializada entonces haz esto

        val textoExit="EXIT"//consante, no se puede cambiar. Es como final
        val texto2="patata"//consante, no se puede cambiar. Es como final
        //textoExit="a"//ERROR no puedes reasignar un final

        val x:Int=1
        val y:Long= x.toLong()//casting. No se puede pasar de un tipo a otro aunque int pueda ser un long.
        //en vez de con  (long)x es x.toTIPO()
        val z:Double=y.toDouble()

        //String.format("%d,%.2f", x, y, z)//formatea a dos decimales
        println(textoExit+" a la $texto2")//"a $VAR" concatena
        println(textoExit+" a la ${texto2.uppercase()}")//si haces algo a la var (mayus en este caso) te lo pone entre {}

        boton.setOnClickListener{
            //no usamos interficie, no necesitamos sobrescribir metodos
            val intent=Intent(this, activity2::class.java).apply {
                putExtra(CONSTANT, texto.textScaleX)//constant es el mensaje este largo
            }
            startActivity(intent)
        }

        println("---------------------------------------")
        metodo()//llamas al metodo

        println("---------------------------------------")
        ifSentence()

        println("---------------------------------------")
        whenFunction()

        println("---------------------------------------")
        whenFunction2()

        println("---------------------------------------")
        arraysFunction()

        println("---------------------------------------")
        arraysClasseExtFunction()

        println("---------------------------------------")
        nullExample()
    }


    private fun ifSentence(){
        println("\nEstas en el metodo ifSentence")
        var x=1
        if(x==1){
            println("$x")
        }
        else if(x==2){
            println(x)
        }
        else{
            println(x)
        }

    }

    private fun whenFunction(){
        println("\nEstas en el metodo whenFunction")
        var x = 10
        when (x) {//esto es como un switch mas o menos
            0 -> {println("$x is 0") }//cuando es 0
            1, 2, 3 -> {println("$x is 1, 2 o 3")}//cuando es uno de estos tres numeros
            in 4..10 -> {println("$x is 4 ..10")}//cuando esta en este rango
            else -> {println("$x is else")}//los demas
        }
    }

    private fun whenFunction2(){
        println("\nEstas en el metodo whenFunction2")
        var country = "France"
        when (country) {//lo mismo pero con string
            "Spain" -> {println("$country is ES")}
            "France" -> {println("$country is FR")}
            "USA", "EEUU" -> {println("$country is US")}
            else -> {println("$country is unknown")}
        }
    }

    private fun arraysFunction(){
        println("\nEstas en el metodo arraysFunction")
        val array= arrayListOf<String>()//entre <> el tipo
        var var1="a"
        array.add(var1)
        array.add("b")
        array.add("c")
        array.add("d")

        println("valores array;")
        println(array)

        println("con for each")
        array.forEach{
            println(it)//it es el iterator, no se crea
        }
        array.removeAt(0)//0 es el primero de todos, como en java
        println(array)
    }

    private fun arraysClasseExtFunction(){
        println("\nEstas en el metodo arraysClasseExtFunction")

        var persona1=Persona("m","rajoy", 10, 50.50, false)
        //iniicializamos un objeto de clase
        var persona2=Persona("j","chanchez", 20, 100.50, true)
        var persona3=Persona("p","itico", 40, 500.0, true)
        var persona4=Persona("cindy","nero", 30, 0.1, false)

        //ahora lo metes en una array
        var arrayPersona= arrayListOf<Persona>()
        arrayPersona.add(persona1)
        arrayPersona.add(persona2)
        arrayPersona.add(persona3)
        arrayPersona.add(persona4)

        println("Manera 1")
        arrayPersona.forEach{
            print("Soy "+it.name+" "+it.lastName+" tengo "+it.age+" anyos y tengo un sueldo de ${it.balance} €")
            if(it.isEmployee==true){
                print(" y tengo trabajo\n")
            }
            else{
                print(" y no tengo trabajo\n")
            }
        }

        println("\nManera 2")
        for(elemento in arrayPersona){println("Hola soy ${elemento.name}")}

    }

    private fun nullExample(){
        println("\nEstas en el metodo nullExample")
        var texto:String?="value"//? es que puede ser nulo
        texto= null


        texto?.let {
            println("Esta var es nula")
        } ?: run {
            println("Esta var no es nulo!")
        }
    }

    private fun metodo(){//private FUNction. En vez de metodo
        println("\nEstas en el metodo metodo")
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