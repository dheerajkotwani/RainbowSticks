package project.dheerajkotwani.rainbowsticks

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.DisplayMetrics
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import java.util.Timer
import java.util.TimerTask
import kotlin.math.cos
import kotlin.math.sin
import kotlinx.coroutines.delay
import project.dheerajkotwani.rainbowsticks.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val display = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(display)

        val h = display.heightPixels/2
        val w = display.widthPixels/2

        val list: ArrayList<StickView> = ArrayList()
        for (i in (0 until 24)) {

            val view = StickView(this)
            view.layoutParams = LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT).apply {
                marginStart = w - 200 + (cos(i*(Math.PI/12)) * 240).toInt()
                topMargin = h - 200 + (sin(i*(Math.PI/12)) * 240).toInt()
                gravity = Gravity.CENTER
            }
            view.rotation = i*15f
            binding.root.addView(view)
            list.add(view)
        }

    }
}