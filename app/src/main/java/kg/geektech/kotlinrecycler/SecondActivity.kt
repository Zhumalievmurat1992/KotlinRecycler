package kg.geektech.kotlinrecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import kg.geektech.kotlinrecycler.adapter.SecondAdapter
import kg.geektech.kotlinrecycler.adapter.SheepAdapter
import kg.geektech.kotlinrecycler.databinding.ActivitySecondBinding
import java.util.ArrayList

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private var list = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_second)
        val bundle = intent.getIntegerArrayListExtra("KEY")
        if (bundle != null) {
            println("---------------------------" )
            list = bundle
        }
            init()
    }

    private fun init() = with(binding) {
        rcView2.layoutManager = GridLayoutManager(this@SecondActivity, 3)
        rcView2.adapter = SheepAdapter(list)
        // rcView2.adapter = SecondAdapter()


    }
}