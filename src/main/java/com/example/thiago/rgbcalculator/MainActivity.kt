package com.example.thiago.rgbcalculator

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.View
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {

    private lateinit var mViewColor: View

    private var seekR: Int = 0
    private var seekG: Int = 0
    private var seekB: Int = 0
    private var seekAlpha: Int = 255
    var i: Int = 0
    var hexStringRed = java.lang.Integer.toHexString(i)
    var hexStringGreen = java.lang.Integer.toHexString(i)
    var hexStringBlue = java.lang.Integer.toHexString(i)
    var hexStringAlpha = java.lang.Integer.toHexString(i)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mViewColor = findViewById(R.id.viewBackground)

        val alpha = findViewById(R.id.AlphaSeekBar) as SeekBar
        val sbR = findViewById(R.id.RedSeekBar) as SeekBar
        val sbG = findViewById(R.id.GreenSeekBar) as SeekBar
        val sbB = findViewById(R.id.BlueSeekBar) as SeekBar

        sbR.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onStopTrackingTouch(seekBar: SeekBar) {}

            override fun onStartTrackingTouch(seekBar: SeekBar) {}

            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                seekR = progress



                doSomethingWithColor()
            }
        })

        sbG.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onStopTrackingTouch(seekBar: SeekBar) {}

            override fun onStartTrackingTouch(seekBar: SeekBar) {}

            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                seekG = progress


                doSomethingWithColor()
            }
        })

        sbB.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onStopTrackingTouch(seekBar: SeekBar) {}

            override fun onStartTrackingTouch(seekBar: SeekBar) {}

            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                seekB = progress


                doSomethingWithColor()
            }
        })

        alpha.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onStopTrackingTouch(seekBar: SeekBar) {}

            override fun onStartTrackingTouch(seekBar: SeekBar) {}

            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                seekAlpha= progress


                doSomethingWithColor()


            }
        })

    }

    private fun doSomethingWithColor() {
        val color = Color.argb(seekAlpha, seekR, seekG, seekB)
        mViewColor.setBackgroundColor(color)
        hexStringRed = java.lang.Integer.toHexString(seekR)
        hexStringGreen = java.lang.Integer.toHexString(seekG)
        hexStringBlue = java.lang.Integer.toHexString(seekB)
        hexStringAlpha = java.lang.Integer.toHexString(seekAlpha)
        textViewHexRed.text = hexStringRed
        textViewHexGreen.text = hexStringGreen
        textViewHexBlue.text = hexStringBlue
        textViewHexAlpha.text = hexStringAlpha
        val text: String = "(" +hexStringAlpha+ ", "+hexStringRed+ ", "+hexStringGreen+ ", "+hexStringBlue+")"
        textViewColor.text = text


    }
}

