package fr.isen.bourgeois.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import fr.isen.bourgeois.androiderestaurant.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        buttonsListener ()
    }

    private fun buttonsListener () {
        binding.starterButton.setOnClickListener {
        Log.d("button", "Click sur button entrée")
            Toast.makeText(this, "Entrée", Toast.LENGTH_LONG).show()
            val intent = Intent(this, MenuActivity::class.java)
            intent.putExtra("MenuActivity", "Entrées")
            showCategory(Category.STARTER)
        }

        binding.mainButton.setOnClickListener {
            Log.d( "button","Click sur button plats")
            Toast.makeText(this, "Plats", Toast.LENGTH_LONG).show()
            val intent = Intent(this, MenuActivity::class.java)
            intent.putExtra("MenuActivity", "Plats")
            showCategory(Category.MAIN)
        }

        binding.finishButton.setOnClickListener {
            Log.d( "button", "Click sur button dessert")
            Toast.makeText(this, "Desserts", Toast.LENGTH_LONG).show()
            val intent = Intent(this, MenuActivity::class.java)
            intent.putExtra("MenuActivity", "Desserts")
            showCategory(Category.DESSERT)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d( "LifeCycle", "HomeActivity onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d( "LifeCycle", "HomeActivity onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d( "LifeCycle", "HomeActivity onPause")
    }

    override fun onDestroy() {
        Log.d( "LifeCycle", "HomeActivity onDestroy")
        super.onDestroy()
    }

    private fun showCategory(category: Category) {
        val intent = Intent(this, MenuActivity::class.java)
        intent.putExtra(MenuActivity.extraKey, category)
        startActivity(intent)
    }

}