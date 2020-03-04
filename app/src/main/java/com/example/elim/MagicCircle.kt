package com.example.elim

import android.graphics.Paint
import kotlin.random.Random

data class MagicCircle(val maxX: Int, val maxY: Int) {

    val rad: Float = Random.nextInt(2, 150).toFloat()
    var cx: Float = Random.nextInt(2, maxX).toFloat()
    var cy: Float = Random.nextInt(2, maxX).toFloat()
    var dx = Random.nextInt(1, 10).toFloat()
    var dy = Random.nextInt(1, 10).toFloat()
    var mColor = Paint()

    fun move() {
        when {
            cx !in 0..maxX -> dx = -dx
            cy !in 0..maxY -> dy = -dy
        }
        cx += dx
        cy += dy
    }

    fun initColor(){
        val rnd = java.util.Random()
        mColor.setARGB(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
    }

}