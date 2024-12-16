package Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.task3.R

class CapybaraAdapter (
    val context :Context,
    val imageList :ArrayList<Int>,
    val CapybaraName :ArrayList <String>,
    val CapybaraDesc :ArrayList <String>,
): RecyclerView.Adapter<CapybaraAdapter.CapyViewHolder>(){
    class CapyViewHolder(itemView : View) :RecyclerView.ViewHolder(itemView) {
        var image  :ImageView = itemView.findViewById(R.id.profile)
        var Name : TextView = itemView.findViewById(R.id.CapyName)
        var Desc : TextView = itemView.findViewById(R.id.capybaraDesc)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CapybaraAdapter.CapyViewHolder {
        val itemView : View = LayoutInflater.from(context).inflate(R.layout.capybara_picture, parent, false)
        return CapyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CapybaraAdapter.CapyViewHolder, position: Int) {
        holder.Name.text = CapybaraName[position]
        holder.Desc.text = CapybaraDesc[position]
        holder.image.setImageResource(imageList[position])
    }

    override fun getItemCount(): Int {
        return 3
    }


}