package kg.geektech.kotlinrecycler.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import kg.geektech.kotlinrecycler.R
import kg.geektech.kotlinrecycler.`interface`.Clicks
import kg.geektech.kotlinrecycler.model.Sheep

class SheepAdapter(private val sheepList: ArrayList<Int>): RecyclerView.Adapter<SheepAdapter.SheepHolder>() {

    class SheepHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img: ImageView = itemView.findViewById(R.id.im)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SheepHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_sheep, parent, false)
        return SheepHolder(itemView)
    }

    override fun onBindViewHolder(holder: SheepHolder, position: Int) {
        val currentItem = sheepList[position]
        holder.img.setImageResource(currentItem)
    }

    override fun getItemCount(): Int {
        return sheepList.size
    }

}
