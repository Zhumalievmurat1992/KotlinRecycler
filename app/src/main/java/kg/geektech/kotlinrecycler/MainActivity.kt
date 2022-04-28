package kg.geektech.kotlinrecycler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import kg.geektech.kotlinrecycler.`interface`.Clicks
import kg.geektech.kotlinrecycler.adapter.SecondAdapter
import kg.geektech.kotlinrecycler.adapter.SheepAdapter
import kg.geektech.kotlinrecycler.databinding.ActivityMainBinding
import kg.geektech.kotlinrecycler.model.Sheep

class MainActivity : AppCompatActivity(),Clicks {

    private lateinit var binding: ActivityMainBinding
    private var list = arrayListOf<Sheep>()

    private val images = arrayListOf(
        Sheep(R.drawable.img1), Sheep(R.drawable.img2),Sheep(R.drawable.img3),
        Sheep(R.drawable.img1), Sheep(R.drawable.img2),Sheep(R.drawable.img3),
        Sheep(R.drawable.img1), Sheep(R.drawable.img2),Sheep(R.drawable.img3),
        Sheep(R.drawable.img1), Sheep(R.drawable.img2),Sheep(R.drawable.img3),
        Sheep(R.drawable.img1), Sheep(R.drawable.img2),Sheep(R.drawable.img3),
        Sheep(R.drawable.img1), Sheep(R.drawable.img2),Sheep(R.drawable.img3),
        Sheep(R.drawable.img1), Sheep(R.drawable.img2),Sheep(R.drawable.img3),
        Sheep(R.drawable.img1), Sheep(R.drawable.img2),Sheep(R.drawable.img3),
        Sheep(R.drawable.img1), Sheep(R.drawable.img2), Sheep(R.drawable.img3))


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        binding.btnNext.setOnClickListener {
            val list2 = arrayListOf<Int>()
            for (i in list){
                list2.add(i.imageId)
            }
            val intent = Intent(this,SecondActivity::class.java)
            val aaa = Bundle()

            aaa.putIntegerArrayList("KEY",list2)
            startActivity(intent)
        }
    }

    private fun init() = with(binding) {
        rcView.layoutManager = GridLayoutManager(this@MainActivity, 3)
        rcView.adapter = SecondAdapter(images,this@MainActivity)
    }

    override fun click(currentItem: Sheep) {
       if (list.contains(currentItem) && ! currentItem.isClicked){
           list.remove(currentItem)
       } else {
           list.add(currentItem)
       }
    }
}

