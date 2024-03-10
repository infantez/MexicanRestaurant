package neiz.fz.compose.course.basic_kotlin

class Person (var name:String, var age:Int)

data class Dish(val id:Int, val name:String)


// val = get
// var = get & set

/*
class Person {

    //Propiedades
    var name:String = ""
    var age:Int = 0

    {
        this.name = name
        this.age = age
    }
}
 */

/*
class Person constructor(name:String, age:Int) {

    //Propiedades
    var name:String = ""
    var age:Int = 0

    init {
        this.name = name
        this.age = age
    }

}
 */