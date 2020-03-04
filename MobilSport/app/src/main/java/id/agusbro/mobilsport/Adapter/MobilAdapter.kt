package id.agusbro.mobilsport.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import id.agusbro.mobilsport.MainActivity
import id.agusbro.mobilsport.MobilItem
import id.agusbro.mobilsport.R

class MobilAdapter(private val ListMobil: ArrayList<MobilItem>) : RecyclerView.Adapter<MobilAdapter.ViewMobilHolder>() {

    private lateinit var onCallBack: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onCallBack = onItemClickCallback
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MobilAdapter.ViewMobilHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_mobil,parent,false)
        return ViewMobilHolder(view)
    }

    override fun getItemCount(): Int {
        return ListMobil.size
    }

    override fun onBindViewHolder(holder: MobilAdapter.ViewMobilHolder, position: Int) {
        val mobil = ListMobil[position]

        Glide.with(holder.itemView.context)
            .load(mobil.Image)
            .apply(RequestOptions().override(100,70))
            .into(holder.idImage)

        holder.idName.text = mobil.Name
        holder.idSubName.text = mobil.SubName
        holder.idHarga.text = "$ ${mobil.Harga} Juta"
        holder.idClckItem.setOnClickListener {
            onCallBack.onItemClicked(ListMobil[holder.adapterPosition])
        }
    }

    inner class ViewMobilHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var idName: TextView = itemView.findViewById(R.id.Title)
        var idSubName: TextView = itemView.findViewById(R.id.SubTitle)
        var idImage: ImageView = itemView.findViewById(R.id.ImageMobil)
        var idHarga: TextView = itemView.findViewById(R.id.harga)
        var idClckItem: LinearLayout = itemView.findViewById(R.id.ItemClick)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: MobilItem)
    }

}
