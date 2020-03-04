package id.agusbro.mobilsport

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.agusbro.mobilsport.Adapter.MobilAdapter
import java.util.concurrent.Executor

class MainActivity : AppCompatActivity() {

    private lateinit var rvMobil: RecyclerView
    private var list: ArrayList<MobilItem> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMobil = findViewById(R.id.RecylerList)
        rvMobil.setHasFixedSize(true)

        list.addAll(MobilData.listMobil)
        showRecycle()
    }

    private fun showRecycle() {
        rvMobil.layoutManager = LinearLayoutManager(this)
        val listAdapter = MobilAdapter(list)
        rvMobil.adapter = listAdapter

        listAdapter.setOnItemClickCallback(object : MobilAdapter.OnItemClickCallback{
            override fun onItemClicked(data: MobilItem) {
                val i = Intent(this@MainActivity,Details::class.java)
                i.putExtra("name", data.Name)
                i.putExtra("image", data.Image)
                i.putExtra("details",data.Details)
                i.putExtra("harga",data.Harga)
                i.putExtra("subName", data.SubName)
                startActivity(i)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_items, menu)
        return true
    }
}
