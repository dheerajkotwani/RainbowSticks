package project.dheerajkotwani.rainbowsticks

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * Created by Dheeraj Kotwani on 08/07/23
 */
class StickView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
): View(context, attrs, defStyleAttr) {

    var leftColorData = "#ff0000"
    var rightColorData = "#aaff00"

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawColor(context.getColor(R.color.transparent))

        val lineColor = Paint()
        lineColor.color = context.getColor(R.color.white)
        lineColor.strokeWidth = 4f
        canvas?.drawLine(15f, 200f, 390f, 200f, lineColor)

        val leftColor = Paint()
        leftColor.color = Color.parseColor(leftColorData)
        canvas?.drawCircle(15f, 200f, 15f, leftColor)

        val rightColor = Paint()
        rightColor.color = Color.parseColor(rightColorData)
        canvas?.drawCircle(385f, 200f, 15f, rightColor)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(400, 400)
    }

    fun setColor(first: String, second: String) {
        leftColorData = first
        rightColorData = second
        invalidate()
    }

}