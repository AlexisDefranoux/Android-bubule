package com.example.elim

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class CustomView : View {

    private var mCircles = MutableList<MagicCircle?>(2){null}

    constructor(context: Context?) : super(context, null)

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        for(mCircle in mCircles) {
            if (mCircle != null) {
                mCircle.move()
                canvas?.drawCircle(mCircle.cx, mCircle.cy, mCircle.rad, mCircle.mColor)
                invalidate()
            }
        }
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bot: Int) {
        super.onLayout(changed, left, top, right, bot)
        mCircles = MutableList(2){MagicCircle(width, height)}
        for(mCircle in mCircles) {
            mCircle?.initColor()
        }
    }

    override fun onTouchEvent(e: MotionEvent): Boolean {
        val mCircle = MagicCircle(width, height)
        mCircle.initColor()
        mCircles.add(mCircle)
        return true
    }
}