package fr.isen.bourgeois.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import fr.isen.bourgeois.androiderestaurant.databinding.ActivityDetailBinding
import fr.isen.bourgeois.androiderestaurant.network.Plate
import fr.isen.bourgeois.androiderestaurant.network.Price


class DetailActivity : AppCompatActivity() {

    companion object {
        val extraKeyDetail = "extraKeyDetail"
    }


    lateinit var binding: ActivityDetailBinding
    private var count = 0
    var plate: Plate? = null


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        plate = intent.getSerializableExtra(extraKeyDetail) as? Plate


        val ingredients = plate?.ingredients?.map {
            it.name
        }?.joinToString(",    ") ?: ""
        binding.descriptionMeal.text = ingredients

        var price = plate?.prices?.map {
            it.price
        }?.joinToString(",    ") ?: ""

        plate?.let {
            binding.viewPager2.adapter =PhotoAdapter(it.images, this)
        }

        val numberOfOrder = findViewById<TextView>(R.id.numberOfOrder)
        val ButtonAdd = findViewById<TextView>(R.id.buttonAdd)
        val ButtonMinus = findViewById<TextView>(R.id.buttonMinus)
        val ButtonToPay = findViewById<TextView>(R.id.numberOfOrder)
        // val viewPager2 = findViewById<TextView>(R.id.viewPager2)



        val prix = plate?.prices
        val priceString = java.lang.StringBuilder()
        val priceunique = plate?.prices?.get(0)?.price?.toDouble()
        price = plate?.prices?.get(0).toString()

        binding.buttonAdd.setOnClickListener {
            count++
            binding.numberOfOrder.text =
                Editable.Factory.getInstance().newEditable(count.toString())
            println("COUCOUuuuuuuuuuuuuuuuuuuuuuuuu" + binding.numberOfOrder.text )

            if (plate?.prices?.isNotEmpty() == true) {
                price.forEach { price ->
                    priceString.append(prix)
                }
                val number = count * priceunique!!
                binding.buttonToPay.text = "Total: " +  number.toString() + "€"
            }

        }


        binding.buttonMinus.setOnClickListener {
            if (count > 0) {
                count--
                binding.numberOfOrder.text =
                    Editable.Factory.getInstance().newEditable(count.toString())
                println("COUCOUuuuuuuuuuuuuuuuuuuuuuuuu" + binding.numberOfOrder.text)

                if (plate?.prices?.isNotEmpty() == true) {
                    price.forEach { price ->
                        priceString.append(prix)
                    }
                    val number = count * priceunique!!
                    binding.buttonToPay.text = "Total: " + number.toString() + "€"
                }

            }
        }

    }



    override fun onStart() {
        super.onStart()
        Log.d("LifeCycle", "DetailActivity onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("LifeCycle", "DetailActivity onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("LifeCycle", "DetailActivity onPause")
    }

    override fun onDestroy() {
        Log.d("LifeCycle", "DetailActivity onDestroy")
        super.onDestroy()
    }


    fun converString (price: String?): Any?{
        return try {
            price?.toInt()
        } catch (e :java.lang.NumberFormatException){
            price?.toFloat()
        }
    }

    fun multiply(newPrice : Any, count: Int): Any {
        return when (newPrice) {
            is Int -> {
                newPrice * count
            }
            is Float -> {
                newPrice * count
            }
            else -> {
                "Incompatible types"
            }
        }
    }


}