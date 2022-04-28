package kg.geektech.kotlinrecycler.adapter

import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kg.geektech.kotlinrecycler.R
import kg.geektech.kotlinrecycler.`interface`.Clicks
import kg.geektech.kotlinrecycler.databinding.ItemShBinding
import kg.geektech.kotlinrecycler.model.Sheep

class SecondAdapter(private val sheepList: List<Sheep>, private var clicks: Clicks) :
    RecyclerView.Adapter<SecondAdapter.SecondHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecondHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_sheep, parent, false)
        return SecondHolder(itemView)
    }

    override fun onBindViewHolder(holder: SecondHolder, position: Int) {
        val currentItem = sheepList[position]
        holder.bind(sheepList[position])
        holder.itemView.setOnClickListener {
            currentItem.isClicked = !currentItem.isClicked
            clicks.click(currentItem)
            holder.clicked(currentItem)
        }
    }

    override fun getItemCount(): Int {
        return sheepList.size

    }

    class SecondHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemShBinding.bind(itemView)
        fun bind(sheep: Sheep) = with(binding) {
            Glide.with(root).load(sheep.imageId).into(im)
            if (sheep.isClicked) {
                im.setColorFilter(R.color.black, PorterDuff.Mode.DARKEN)
            } else {
                im.clearColorFilter()
            }
        }

        fun clicked(currentItem: Sheep) {
            if (currentItem.isClicked) {
                binding.im.setColorFilter(R.color.black, PorterDuff.Mode.DARKEN)
            } else {
                binding.im.clearColorFilter()
            }
        }
    }
}