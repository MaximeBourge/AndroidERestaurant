package fr.isen.bourgeois.androiderestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import fr.isen.bourgeois.androiderestaurant.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        buttonsListener ()
    }

    private fun buttonsListener () {
        binding.starterButton.setOnClickListener {
        Log.d("button", "Click sur button entrée")
            Toast.makeText(this, "Entrée", Toast.LENGTH_LONG).show()
        }

        binding.mainButton.setOnClickListener {
            Log.d( "button","Click sur button plats")
        }
        binding.finishButton.setOnClickListener {
            Log.d( "button", "Click sur button dessert")
        }
    }
}