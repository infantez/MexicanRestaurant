package neiz.fz.compose.course.basic_kotlin

fun main(){

    println("Inicio de función")
    //Mutables
    var name:String = "Nestor Infante"
    name = "Nestor eduardo"

    //Inmutable
    val price = 30


    //Listas mutables
    val persons : MutableList<String> = mutableListOf("Nestor Infante")
    persons.add("Diego")

    // var remplazo completo a asignación directa


    //Listas inmutables
    val daysOfWeek:List<String> = listOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo")
    println(daysOfWeek[0])
    println(daysOfWeek.first())
    println(daysOfWeek.last())
    println(daysOfWeek.size)


    for (day in daysOfWeek){
        println(day)
    }

    daysOfWeek.forEach{ day ->
        println("El día de la semana es: $day")
    }

    val ratings = listOf(18,12,15,20,10)

    // LAMDA
    // name:(tipo de valor que te va a exponer) -> el tipo de valor de retorno
    val ratingFilter = ratings.filter {
        it >= 13
    }

    println(ratingFilter)

    // PROGRAMACIÓN ORIENTADA A OBJETOS : POO
    // CLASESs : ESTRUCTURAS

    val nestor : Person = Person("Nestor Infante", 30)
    println(nestor.name)
    println(nestor.age)
    nestor.age = 35

    println(nestor.age)

    val nestor2 : Person2 = Person2("Nestor Infante", 30)
            //Person2("Nestor Infante", 30)
    println(nestor2.name)
    println(nestor2.age)

    val otherPerson: Person2 = nestor2.copy(age = 35)
    val (name2, age2) = Person2("Diego", 32)

    println(otherPerson)
    println(name2 + age2)

    val steve = Person2(age = 28)


    //NULLSAFETY : Seguridad ante nulos
    var word : String? = "MitoCode" //8
    println(word?.length)
    getString(word!!)


    //NULL : Ausencia de valor, algo que no está definido
    //PLATOS : NULL
    //PLATOS.SIZE

    //En Klotin por defecto nada puede ser nulo
    //Protegerla/NULLSAFETY ?
    word = null
    /*
    if (word?.length != null){
        println(word.length)
    } else {
        println("0")
    }
    */
    //Simbolo Elvis ?:

    val result = word?.length ?: "0"
    println(result)

}

fun getString(word:String){

}