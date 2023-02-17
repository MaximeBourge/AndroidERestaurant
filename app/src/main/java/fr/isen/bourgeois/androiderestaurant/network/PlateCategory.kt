package fr.isen.bourgeois.androiderestaurant.network

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class PlateCategory (
    @SerializedName("name_fr") val name: String,
    @SerializedName("items") val items: List<Plate>
    ):java.io.Serializable

