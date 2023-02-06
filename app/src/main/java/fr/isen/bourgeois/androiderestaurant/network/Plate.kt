package fr.isen.bourgeois.androiderestaurant.network

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Plate (
    @SerializedName("images") val image: List<String>,
    @SerializedName("name_fr") val name: String,
    @SerializedName("prices") val price: List<Price>,
    @SerializedName("ingredients") val ingredient: List<Ingredient>
): Serializable
