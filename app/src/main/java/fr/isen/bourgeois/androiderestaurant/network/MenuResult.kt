package fr.isen.bourgeois.androiderestaurant.network

import com.google.gson.annotations.SerializedName
import java.io.Serializable


class MenuResult(@SerializedName("data") val data: List<PlateCategory>): Serializable {

}