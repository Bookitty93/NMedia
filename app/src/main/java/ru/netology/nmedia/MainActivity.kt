package ru.netology.nmedia

import android.app.Activity
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.button.MaterialButton
import ru.netology.nmedia.databinding.ActivityMainBinding
import ru.netology.nmedia.dto.Post
import ru.netology.nmedia.FormatCounter.formatNumber
import ru.netology.nmedia.FormatNumber.reduceNumber


class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val post = Post(
            1,
            "Anvar Mubashirov",
            "Hello, world! Check my link → http://netolo.gy/fyb",
            "21 сентября в 11:29",
            0,
            0,
            0,
            likedByMe = false
        )

        with(binding) {
            author.text = post.author
            published.text = post.published
            content.text = post.content
            like.text = reduceNumber(post.likes)
            share.text = reduceNumber(post.share)
            views.text = post.views.toString()

            like.setIconResource(R.drawable.ic_liked)
            like.iconTint = intArrayOf(Color.RED)
//            like.setIconResource(if (post.likedByMe) R.drawable.ic_liked else R.drawable.ic_baseline_favorite_border_24)

//            binding.like.setOnClickListener {
//                post.likedByMe = !post.likedByMe
//
//                if (post.likedByMe) {
//                    post.likes += 99999
//                    val shortLike = reduceNumber(post.likes)
//                    like.text = shortLike.toString()
//                    like.setIconResource(R.drawable.ic_liked)
//
//                } else {
//                    post.likes -= 100
//                    val shortLike = reduceNumber(post.likes)
//                    like.text = shortLike
//                    like.setIconResource(R.drawable.ic_baseline_favorite_border_24)
//                }
//            }

            binding.share.setOnClickListener {
                post.share += 999
                val shortNumber = reduceNumber(post.share)
                share.text = shortNumber
            }

        }

    }
}