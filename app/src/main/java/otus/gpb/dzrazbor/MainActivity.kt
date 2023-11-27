package otus.gpb.dzrazbor

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import otus.gpb.dzrazbor.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    private lateinit var binding: ActivityMainBinding
    private lateinit var answersAdapter: AnswersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
        setData()
    }

    private fun setupView() = with(binding) {
        close.setOnClickListener {
            Log.d(TAG, "Closed")
            finish()
        }

        next.setOnClickListener {
            Log.d(TAG, "Next")
        }

        setupAnswers()
    }

    private fun setData() {
        binding.imgWord.setImageResource(R.drawable.img_restaurant)
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