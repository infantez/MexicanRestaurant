package neiz.fz.compose.domain.model

import neiz.fz.compose.data.model.DishDTO

data class Dish(
    val id: Int,
    val name:String,
    val description:String,
    val thumbails:String,
    val image:String,
    val carbohydrates:Double,
    val proteins:Double,
    val rating:Double,
    val price:Double,
    val ingredients:String,
    val flagHeader:Boolean
)

fun List<DishDTO>.toDishList(): List<Dish> = map {
    Dish(
        id = it.id,
        name = it.name,
        description= it.description,
        thumbails= it.thumbails,
        image= it.image,
        carbohydrates= it.carbohydrates,
        proteins= it.proteins,
        rating= it.rating,
        price= it.price,
        ingredients= it.ingredients,
        flagHeader= it.flagHeader
    )
}
