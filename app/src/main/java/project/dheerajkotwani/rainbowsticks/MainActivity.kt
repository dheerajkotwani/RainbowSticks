package project.dheerajkotwani.rainbowsticks

import android.animation.Animator
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.Gravity
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.cos
import kotlin.math.sin
import project.dheerajkotwani.rainbowsticks.databinding.ActivityMainBinding

/**
 * Created by Dheeraj Kotwani
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val list: ArrayList<StickView> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val display = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(display)

        val h = display.heightPixels/2
        val w = display.widthPixels/2

        val colorsList = resources.getStringArray(R.array.rainbow_colors)
        val colorsListSize = colorsList.size

        for (i in (0 until 24)) {

            val view = StickView(this)

            view.setColor(colorsList[i%colorsListSize], colorsList[i%colorsListSize])
            view.layoutParams = LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT).apply {
                marginStart = w - 200 + (cos(i*(Math.PI/12)) * 240).toInt()
                topMargin = h - 200 + (sin(i*(Math.PI/12)) * 240).toInt()
                gravity = Gravity.CENTER
            }
            view.rotation = i*15f
            binding.root.addView(view)
            list.add(view)
        }

        binding.root.setOnClickListener {
            startAnimation3()
        }

    }

    private fun startAnimation1() {
        for (view in list) {
            view.animate()
                .rotation(view.rotation + 180f)
                .setDuration(2_000L)
                .setListener(object : Animator.AnimatorListener {
                    override fun onAnimationStart(animation: Animator) = Unit
                    override fun onAnimationEnd(animation: Animator) {
                        view.animate()
                            .rotation(view.rotation - 180f)
                            .setDuration(2_000L)
                            .start()
                    }

                    override fun onAnimationCancel(animation: Animator) = Unit

                    override fun onAnimationRepeat(animation: Animator) = Unit

                })
                .start()
        }
    }

    private fun startAnimation2() {
        for (view in list) {
            view.animate()
                .rotation(view.rotation + 90f)
                .setDuration(1_000L)
                .setListener(object : Animator.AnimatorListener {
                    override fun onAnimationStart(animation: Animator) = Unit
                    override fun onAnimationEnd(animation: Animator) {
                        view.animate()
                            .rotation(view.rotation - 90f)
                            .setDuration(1_000L)
                            .start()
                    }

                    override fun onAnimationCancel(animation: Animator) = Unit

                    override fun onAnimationRepeat(animation: Animator) = Unit

                })
                .start()
        }
    }

    private fun startAnimation3() {
        for (position in (0 until list.size)) {
            list[position].animate()
                .rotation(list[position].rotation + 180f)
                .setDuration(600L)
                .setStartDelay(position * 150L)
                .start()
        }
    }

    private fun startAnimation4() {
        for (position in (0 until list.size)) {
            list[position].animate()
                .rotation(list[position].rotation - 180f)
                .setDuration(600L)
                .setStartDelay(position * 150L)
                .start()
        }
    }

}