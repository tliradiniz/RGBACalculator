package com.example.thiago.rgbcalculator

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.Layout
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.*
import com.example.thiago.rgbcalculator.R.id.*
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {

    private lateinit var mViewColor: View
    private lateinit var mTextViewColor: TextView
    private lateinit var mSwitch: Switch
    private lateinit var mTextViewHexRed: TextView
    private lateinit var mTextViewHexGreen: TextView
    private lateinit var mTextViewHexBlue: TextView
    private lateinit var mTextViewHexColor: TextView
    private lateinit var mTextViewDecRed: TextView
    private lateinit var mTextViewDecGreen: TextView
    private lateinit var mTextViewDecBlue: TextView
    private lateinit var mTextViewDecColor: TextView

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

        mSwitch = findViewById(R.id.switch1)
        mTextViewColor = findViewById(R.id.textViewColor)
        mViewColor = findViewById(R.id.viewBackground)
        mTextViewHexRed = findViewById(R.id.textViewHexRed)
        mTextViewHexGreen = findViewById(R.id.textViewHexGreen)
        mTextViewHexBlue = findViewById(R.id.textViewHexBlue)
        mTextViewHexColor = findViewById(R.id.textViewHexAlpha)
        mTextViewDecRed = findViewById(R.id.textViewDecRed)
        mTextViewDecGreen = findViewById(R.id.textViewDecGreen)
        mTextViewDecBlue = findViewById(R.id.textViewDecBlue)
        mTextViewDecColor = findViewById(R.id.textViewDecAlpha)

        val alpha = findViewById(R.id.AlphaSeekBar) as SeekBar
        val sbR = findViewById(R.id.RedSeekBar) as SeekBar
        val sbG = findViewById(R.id.GreenSeekBar) as SeekBar
        val sbB = findViewById(R.id.BlueSeekBar) as SeekBar


        mSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                mSwitch.text = "Hexadecimal"
                HexRed.setVisibility(View.VISIBLE)
                HexGreen.setVisibility(View.VISIBLE)
                HexBlue.setVisibility(View.VISIBLE)
                HexColor.setVisibility(View.VISIBLE)
                mTextViewHexRed.setVisibility(View.VISIBLE)
                mTextViewHexGreen.setVisibility(View.VISIBLE)
                mTextViewHexBlue.setVisibility(View.VISIBLE)
                mTextViewHexColor.setVisibility(View.VISIBLE)
                DecRed.setVisibility(View.INVISIBLE)
                DecGreen.setVisibility(View.INVISIBLE)
                DecBlue.setVisibility(View.INVISIBLE)
                DecColor.setVisibility(View.INVISIBLE)
                textViewDecRed.setVisibility(View.INVISIBLE)
                textViewDecGreen.setVisibility(View.INVISIBLE)
                textViewDecBlue.setVisibility(View.INVISIBLE)
                textViewDecAlpha.setVisibility(View.INVISIBLE)


            } else {

                mSwitch.text = "Decimal"
                HexRed.setVisibility(View.INVISIBLE)
                HexGreen.setVisibility(View.INVISIBLE)
                HexBlue.setVisibility(View.INVISIBLE)
                HexColor.setVisibility(View.INVISIBLE)
                mTextViewHexRed.setVisibility(View.INVISIBLE)
                mTextViewHexGreen.setVisibility(View.INVISIBLE)
                mTextViewHexBlue.setVisibility(View.INVISIBLE)
                mTextViewHexColor.setVisibility(View.INVISIBLE)
                DecRed.setVisibility(View.VISIBLE)
                DecGreen.setVisibility(View.VISIBLE)
                DecBlue.setVisibility(View.VISIBLE)
                DecColor.setVisibility(View.VISIBLE)
                textViewDecRed.setVisibility(View.VISIBLE)
                textViewDecGreen.setVisibility(View.VISIBLE)
                textViewDecBlue.setVisibility(View.VISIBLE)
                textViewDecAlpha.setVisibility(View.VISIBLE)

            }
        }

        mTextViewColor.setOnEditorActionListener { view, actionId, event ->

            if (actionId == EditorInfo.IME_ACTION_DONE){
                var strs = mTextViewColor.text.split(",").toTypedArray()
                textViewHexAlpha.text = Editable.Factory.getInstance().newEditable(strs[0])
                textViewHexRed.text = Editable.Factory.getInstance().newEditable(strs[1])
                textViewHexGreen.text = Editable.Factory.getInstance().newEditable(strs[2])
                textViewHexBlue.text = Editable.Factory.getInstance().newEditable(strs[3])

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
        mTextViewHexRed.setOnEditorActionListener { view, actionId, event ->

            if (actionId == EditorInfo.IME_ACTION_DONE){
                var strs = mTextViewHexRed.text
                textViewHexRed.text = Editable.Factory.getInstance().newEditable(strs)
                strs = strs.replace("\\s".toRegex(),"")
                var v = java.lang.Integer.parseInt(strs, 16)
                sbR.setProgress(v)
            }

            false
        }

        mTextViewHexGreen.setOnEditorActionListener { view, actionId, event ->

            if (actionId == EditorInfo.IME_ACTION_DONE){
                var strs = mTextViewHexGreen.text
                textViewHexGreen.text = Editable.Factory.getInstance().newEditable(strs)
                strs = strs.replace("\\s".toRegex(),"")
                var v = java.lang.Integer.parseInt(strs as String, 16)
                sbG.setProgress(v)
            }

            false
        }

        mTextViewHexBlue.setOnEditorActionListener { view, actionId, event ->

            if (actionId == EditorInfo.IME_ACTION_DONE){
                var strs = mTextViewHexBlue.text
                textViewHexBlue.text = Editable.Factory.getInstance().newEditable(strs)
                strs = strs.replace("\\s".toRegex(),"")
                var v = java.lang.Integer.parseInt(strs as String, 16)
                sbB.setProgress(v)
            }

            false
        }

        mTextViewHexColor.setOnEditorActionListener { view, actionId, event ->

            if (actionId == EditorInfo.IME_ACTION_DONE){
                var strs = mTextViewHexColor.text
                mTextViewHexColor.text = Editable.Factory.getInstance().newEditable(strs)
                strs = strs.replace("\\s".toRegex(),"")
                var v = java.lang.Integer.parseInt(strs as String, 16)
                alpha.setProgress(v)
            }

            false
        }

        mTextViewDecRed.setOnEditorActionListener { view, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE){
                var strs = mTextViewDecRed.text
                mTextViewDecRed.text = Editable.Factory.getInstance().newEditable(strs)
                strs = strs.replace("\\s".toRegex(),"")
                var v = java.lang.Integer.parseInt(strs as String)
                sbR.setProgress(v)
            }

            false
        }

        mTextViewDecGreen.setOnEditorActionListener { view, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE){
                var strs = mTextViewDecGreen.text
                mTextViewDecGreen.text = Editable.Factory.getInstance().newEditable(strs)
                strs = strs.replace("\\s".toRegex(),"")
                var v = java.lang.Integer.parseInt(strs as String)
                sbG.setProgress(v)
            }
            false
        }

        mTextViewDecBlue.setOnEditorActionListener { view, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE){
                var strs = mTextViewDecBlue.text
                mTextViewDecBlue.text = Editable.Factory.getInstance().newEditable(strs)
                strs = strs.replace("\\s".toRegex(),"")
                var v = java.lang.Integer.parseInt(strs as String)
                sbB.setProgress(v)
            }
            false
        }

        mTextViewDecColor.setOnEditorActionListener { view, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE){
                var strs = mTextViewDecColor.text
                mTextViewDecColor.text = Editable.Factory.getInstance().newEditable(strs)
                strs = strs.replace("\\s".toRegex(),"")
                var v = java.lang.Integer.parseInt(strs as String)
                alpha.setProgress(v)
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
        textViewHexRed.text = Editable.Factory.getInstance().newEditable(hexStringRed)
        textViewHexGreen.text = Editable.Factory.getInstance().newEditable(hexStringGreen)
        textViewHexBlue.text = Editable.Factory.getInstance().newEditable(hexStringBlue)
        textViewHexAlpha.text = Editable.Factory.getInstance().newEditable(hexStringAlpha)
        textViewDecRed.text = Editable.Factory.getInstance().newEditable(seekR.toString())
        textViewDecGreen.text = Editable.Factory.getInstance().newEditable(seekG.toString())
        textViewDecBlue.text = Editable.Factory.getInstance().newEditable(seekB.toString())
        textViewDecAlpha.text = Editable.Factory.getInstance().newEditable(seekAlpha.toString())
        val text: String = hexStringAlpha+ ", "+hexStringRed+ ", "+hexStringGreen+ ", "+hexStringBlue
        textViewColor.text = Editable.Factory.getInstance().newEditable(text)

    }
}

