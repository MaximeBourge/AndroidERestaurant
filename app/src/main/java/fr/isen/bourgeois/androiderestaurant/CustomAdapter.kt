package fr.isen.bourgeois.androiderestaurant



import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import fr.isen.bourgeois.androiderestaurant.databinding.CellCustomBinding
import fr.isen.bourgeois.androiderestaurant.network.Plate


class CustomAdapter(val items: List<Plate> ,val clickListener: (Plate) -> Unit) : RecyclerView.Adapter<CustomAdapter.CellViewHolder>() {
    class CellViewHolder(binding: CellCustomBinding) : RecyclerView.ViewHolder(binding.root) {
        val textView: TextView = binding.itemName
        val imageView: ImageView = binding.itemImage
        val priceView: TextView = binding.itemPrice
        val root: ConstraintLayout = binding.root
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CellViewHolder {
        val binding = CellCustomBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CellViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(
        holder: CellViewHolder, position: Int
    ) {
        val plate = items[position]
        holder.textView.text = plate.name
        holder.priceView.text = plate.prices.first().price + "€"
        Picasso.get().load(getThumbnail(plate)).placeholder(R.drawable.poisson_error).into(holder.imageView)
        holder.root.setOnClickListener {
            Log.d("click", "click on ${position + 1}")
            clickListener(plate)
        }
    }

    private fun getThumbnail(plate: Plate): String? {
        return if (plate.images.isNotEmpty() && plate.images.firstOrNull()?.isNotEmpty() == true) {
            plate.images.firstOrNull()
        } else {
            null
        }
    }
}