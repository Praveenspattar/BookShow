package com.example.bookshow.UI.Activities

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bookshow.R

class MainActivity : AppCompatActivity() {

//    lateinit var movieRv :RecyclerView
//    lateinit var moviesAdapter: MoviesAdapter
    lateinit var movie1:ImageView
    lateinit var movie2:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        movie1 = findViewById(R.id.movie1)
        movie2 = findViewById(R.id.movie2)

//        movieRv = findViewById(R.id.movieRv)
//
//        val movieList = listOf(R.drawable.movie1, R.drawable.movie2)
//        moviesAdapter = MoviesAdapter(this,movieList)
//        movieRv.layoutManager = GridLayoutManager(this, 2)

        movie1.setOnClickListener {
            val intent = Intent(this@MainActivity, MovieDetailActivity::class.java)
            startActivity(intent)
        }

        movie2.setOnClickListener {
            val intent = Intent(this@MainActivity, MovieDetailActivity::class.java)
            startActivity(intent)
        }

    }
}