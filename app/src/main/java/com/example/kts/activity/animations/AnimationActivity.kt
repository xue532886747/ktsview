package com.example.kts.activity.animations

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.kts.R

/**
 * @author 53288
 * @description
 * @date 2021/11/15
 */
class AnimationActivity : AppCompatActivity() {
    lateinit var bt_daxiao: Button
    lateinit var bt_alpha: Button
    lateinit var bt_rotate: Button
    lateinit var bt_translate: Button
    lateinit var bt_set: Button
    lateinit var iv_image: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)
        bt_alpha = findViewById(R.id.bt_alpha)
        bt_daxiao = findViewById(R.id.bt_daxiao)
        bt_rotate = findViewById(R.id.bt_rotate)
        bt_translate = findViewById(R.id.bt_translate)
        bt_set = findViewById(R.id.bt_set)
        iv_image = findViewById(R.id.iv_image)

        bt_daxiao.setOnClickListener {
            initScale()
        }
        bt_alpha.setOnClickListener {
            initAlpha()
        }
        bt_rotate.setOnClickListener {
            initRotate()
        }

        bt_translate.setOnClickListener {
            initTranslate()
        }
        bt_set.setOnClickListener {
            initSet()
        }
    }

    private fun initSet() {
        val anim: Animation = AnimationUtils.loadAnimation(this, R.anim.anim_set).also {
            iv_image.startAnimation(it)
        }
        anim.repeatCount = 10
        anim.duration = 1000


    }

    private fun initTranslate() {

        val anim: Animation = AnimationUtils.loadAnimation(this, R.anim.anim_translate).also {
            iv_image.startAnimation(it)
        }
        anim.repeatCount = 10
        anim.duration = 1000
        anim.repeatMode = Animation.REVERSE
    }

    private fun initRotate() {
        val anim: Animation = AnimationUtils.loadAnimation(this, R.anim.anim_rotate).also {
            iv_image.startAnimation(it)
        }
        anim.repeatCount = 10
        anim.duration = 1000
        anim.repeatMode = Animation.REVERSE
    }

    private fun initAlpha() {
        val anim: Animation = AnimationUtils.loadAnimation(this, R.anim.anim_alpha).also {
            iv_image.startAnimation(it)
        }
        anim.repeatCount = 10
        anim.duration = 1000
        anim.repeatMode = Animation.REVERSE
    }

    private fun initScale() {
        val anim: Animation = AnimationUtils.loadAnimation(this, R.anim.anim_scale).also {
            iv_image.startAnimation(it)
        }

        anim.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(p0: Animation?) {

            }

            override fun onAnimationEnd(p0: Animation?) {

            }

            override fun onAnimationRepeat(p0: Animation?) {

            }
        })
        anim.repeatCount = 10
        anim.duration = 1000
        anim.repeatMode = Animation.REVERSE
    }
}