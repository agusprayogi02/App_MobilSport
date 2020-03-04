package id.agusbro.mobilsport

import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class Details : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val name = findViewById<TextView>(R.id.Dname)
        val image = findViewById<ImageView>(R.id.Dimage)
        val detail = findViewById<TextView>(R.id.Ddetail)
        val kap = findViewById<TextView>(R.id.kapasitas)
        val ten = findViewById<TextView>(R.id.tenaga)
        val kec = findViewById<TextView>(R.id.kecepatan)
        val tor = findViewById<TextView>(R.id.torsi)
        val ber = findViewById<TextView>(R.id.berat)
        val har = findViewById<TextView>(R.id.harga)

        val bund = intent.extras!!
        name.text = bund.getString("name")
        val dis = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(dis)
        val widh = dis.widthPixels - 30
        val h = (widh / 1.4367816092).toInt()
        detail.text = "    " + bund.getString("details")
        Glide.with(this)
            .load(bund.getInt("image"))
            .apply(RequestOptions().override(widh, h))
            .into(image)

        val arr = bund.getStringArray("spek")
        val harga = bund.getFloat("harga")
        kap.text = ":  " + arr!![0]
        ten.text = ":  " + arr[1]
        kec.text = ":  " + arr[2]
        tor.text = ":  " + arr[3]
        ber.text = ":  " + arr[4]
        har.text = ":  " + "$ ${harga} Juta Dollar"

    }
}