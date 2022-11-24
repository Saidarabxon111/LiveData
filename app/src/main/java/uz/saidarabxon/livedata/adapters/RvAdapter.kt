package uz.saidarabxon.livedata.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import uz.saidarabxon.livedata.databinding.ItemView1Binding
import uz.saidarabxon.livedata.databinding.ItemView2Binding
import uz.saidarabxon.livedata.utils.MyData

class MyRvAdapter(val lifecycleOwner: LifecycleOwner) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class Vh1(var itemView1Binding: ItemView1Binding ):RecyclerView.ViewHolder(itemView1Binding.root) {
        fun onBind() {

            itemView1Binding.edt.addTextChangedListener {
//                MyData.myLiveData.postValue(it.toString())
                MyData.myLiveData.postValue (it.toString())
            }
        }
    }
        inner class Vh2(var itemView2Binding: ItemView2Binding ):RecyclerView.ViewHolder(itemView2Binding.root){
            fun onBind(){

//            MyData.myLiveData.observe(lifecycleOwner){
//                itemView2Binding.tv.text =it
                MyData.myLiveData.observe(lifecycleOwner){

                    itemView2Binding.tv.text =it
                }
//            }
            }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType ==0){

            return Vh1(ItemView1Binding.inflate(LayoutInflater.from(parent.context) , parent, false))
        }else{
            return Vh2(ItemView2Binding.inflate(LayoutInflater.from(parent.context) , parent, false))

        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (position==0){
            (holder as Vh1).onBind()
        }else{
            (holder as Vh2).onBind()

        }

    }

    override fun getItemCount(): Int = 2

    override fun getItemViewType(position: Int): Int {


        return  position
    }

}