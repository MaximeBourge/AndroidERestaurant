package fr.isen.bourgeois.androiderestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.squareup.picasso.Picasso
import fr.isen.bourgeois.androiderestaurant.databinding.ActivityDetailBinding
import fr.isen.bourgeois.androiderestaurant.network.Plate


class DetailActivity : AppCompatActivity() {

    companion object {
        val extraKeyDetail = "extraKeyDetail"
    }


    lateinit var binding: ActivityDetailBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val plate = intent.getSerializableExtra(extraKeyDetail) as? Plate

        val ingredients = plate?.ingredient?.map {
            it.name
        }?.joinToString(",\n")

        binding.descriptionMeal.text = ingredients ?: ""
        binding.textView.text = plate?.name
        Picasso.get().load(getThumbnail(plate)).placeholder(R.drawable.poisson_error)
            .into(binding.imageView)
    }


    private fun getThumbnail(plate: Plate?): String? {
        return if (plate?.image?.isNotEmpty() == true && plate.image.firstOrNull()
                ?.isNotEmpty() == true
        ) {
            plate.image.firstOrNull()
        } else {
            null
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
}