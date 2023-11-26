package otus.gpb.dzrazbor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    private lateinit var wordImg: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wordImg = findViewById(R.id.img_word)
        setImage()
    }

    private fun setImage() {
        wordImg.setImageResource(R.drawable.img_restaurant)
    }
}