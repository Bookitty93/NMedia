package ru.netology.nmedia


import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.netology.nmedia.databinding.ActivityMainBinding
import ru.netology.nmedia.dto.Post
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
            "Нетология. Университет интернет-профессий будущего",
            "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
            "21 сентября в 11:29",
            0,
            0,
            0,
            likedByMe = false
        )

        with(binding) {

            root.setOnClickListener {
                println("root")
            }

            avatar.setOnClickListener {
                println("avatar")
            }
            content.setOnClickListener {
                println("content")
            }
            menu.setOnClickListener {
                println("menu")
            }

            author.text = post.author
            published.text = post.published
            content.text = post.content
            like.text = reduceNumber(post.likes)
            share.text = reduceNumber(post.share)
            views.text = post.views.toString()

            like.setIconResource(if (post.likedByMe) R.drawable.ic_liked else R.drawable.ic_baseline_favorite_border_24)
            like.iconTint =
                ColorStateList.valueOf(if (post.likedByMe) Color.RED else Color.BLACK)

            binding.like.setOnClickListener {
                post.likedByMe = !post.likedByMe

                if (post.likedByMe) {
                    post.likes += 99999
                    val shortLike = reduceNumber(post.likes)
                    like.text = shortLike
                    like.setIconResource(R.drawable.ic_liked)
                    like.iconTint = ColorStateList.valueOf(Color.RED)

                } else {
                    post.likes -= 100
                    val shortLike = reduceNumber(post.likes)
                    like.text = shortLike
                    like.setIconResource(R.drawable.ic_baseline_favorite_border_24)
                    like.iconTint = ColorStateList.valueOf(Color.BLACK)
                }
            }

            binding.share.setOnClickListener {
                post.share += 999
                val shortNumber = reduceNumber(post.share)
                share.text = shortNumber
            }

        }

    }
}
