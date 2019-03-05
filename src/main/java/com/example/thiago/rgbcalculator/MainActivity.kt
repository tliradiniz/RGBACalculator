package com.example.thiago.rgbcalculator

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.Layout
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {

    private lateinit var mViewColor: View
    private lateinit var mTextViewColor: TextView

    private var seekR: Int = 0
    private var seekG: Int = 0
    private var seekB: Int = 0
    private var seekAlpha: Int = 255
    private var v2: IntArray = intArrayOf(0,0,0,0)
    var i: Int = 0
    var hexStringRed = java.lang.Integer.toHexString(i)
    var hexStringGreen = java.lang.Integer.toHexString(i)
    var hexStringBlue = java.lang.Integer.toHexString(i)
    var hexStringAlpha = java.lang.Integer.toHexString(i)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mTextViewColor = findViewById(R.id.textViewColor)
        mViewColor = findViewById(R.id.viewBackground)

        val alpha = findViewById(R.id.AlphaSeekBar) as SeekBar
        val sbR = findViewById(R.id.RedSeekBar) as SeekBar
        val sbG = findViewById(R.id.GreenSeekBar) as SeekBar
        val sbB = findViewById(R.id.BlueSeekBar) as SeekBar

        mTextViewColor.setOnEditorActionListener { view, actionId, event ->

            if (actionId == EditorInfo.IME_ACTION_DONE){
                var strs = mTextViewColor.text.split(",").toTypedArray()
                textViewHexAlpha.text = strs[0]
                textViewHexRed.text = strs[1]
                textViewHexGreen.text = strs[2]
                textViewHexBlue.text = strs[3]

                strs[0] = strs[0].replace("\\s".toRegex(),"")
                strs[1] = strs[1].replace("\\s".toRegex(),"")
                strs[2] = strs[2].replace("\\s".toRegex(),"")
                strs[3] = strs[3].replace("\\s".toRegex(),"")

                v2[0] = java.lang.Integer.parseInt(strs[0], 16)
                v2[1] = java.lang.Integer.parseInt(strs[1], 16)
                v2[2] = java.lang.Integer.parseInt(strs[2], 16)
                v2[3] = java.lang.Integer.parseInt(strs[3], 16)

                alpha.setProgress(v2[0])
                sbR.setProgress(v2[1])
                sbG.setProgress(v2[2])
                sbB.setProgress(v2[3])

            }

            false
        }
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
        val text: String = hexStringAlpha+ ", "+hexStringRed+ ", "+hexStringGreen+ ", "+hexStringBlue
        textViewColor.text = Editable.Factory.getInstance().newEditable(text)

    }
}

