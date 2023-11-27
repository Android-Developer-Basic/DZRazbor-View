package otus.gpb.dzrazbor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    private lateinit var wordImg: ImageView
    private lateinit var answersAdapter: AnswersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupView()
        setData()
    }

    private fun setupView() {
        wordImg = findViewById(R.id.img_word)

        findViewById<ImageButton>(R.id.close).setOnClickListener {
            Log.d(TAG, "Closed")
            finish()
        }

        findViewById<Button>(R.id.next).setOnClickListener {
            Log.d(TAG, "Next")
        }

        setupAnswers()
    }

    private fun setData() {
        wordImg.setImageResource(R.drawable.img_restaurant)
        answersAdapter.submitList(
            listOf(
                Answer("Магазин"),
                Answer("Больница"),
                Answer("АЗС"),
                Answer("Ресторан", true),
            )
        )
    }

    private fun setupAnswers() {
        answersAdapter = AnswersAdapter()
        findViewById<RecyclerView>(R.id.answers).apply {
            adapter = answersAdapter
            layoutManager = GridLayoutManager(
                this@MainActivity,
                2,
                RecyclerView.VERTICAL,
                false
            )
        }
    }
}