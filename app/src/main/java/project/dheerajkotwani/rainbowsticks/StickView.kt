package project.dheerajkotwani.rainbowsticks

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * Created by Dheeraj Kotwani on 08/07/23
 * Copyright (c) 2023 Zomato Media Pvt. Ltd . All rights reserved.
 */
class StickView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
): View(context, attrs, defStyleAttr) {

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawColor(context.getColor(R.color.transparent))

        val lineColor = Paint()
        lineColor.color = context.getColor(R.color.black)
        canvas?.drawLine(10f, 200f, 390f, 200f, lineColor)

        val leftColor = Paint()
        leftColor.color = context.getColor(R.color.purple_200)
        canvas?.drawCircle(10f, 200f, 10f, leftColor)

        val rightColor = Paint()
        rightColor.color = context.getColor(R.color.teal_200)
        canvas?.drawCircle(390f, 200f, 10f, rightColor)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(400, 400)
    }

}