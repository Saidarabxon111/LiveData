package uz.saidarabxon.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.saidarabxon.livedata.adapters.MyRvAdapter
import uz.saidarabxon.livedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var rvAdapter: MyRvAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        rvAdapter =MyRvAdapter(this)
        binding.myViewPager2.adapter =rvAdapter



    }
}