package com.example.scientificcalculator

import android.content.pm.ActivityInfo
import android.os.Build
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import org.mariuszgromada.math.mxparser.Expression

class MainActivity : AppCompatActivity() {

    private lateinit var previousCal: TextView
    private lateinit var display: EditText
    var isPortrait=true
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        previousCal=findViewById(R.id.preCalcView)
        display=findViewById(R.id.displayText)
        display.showSoftInputOnFocus=false

    }

    private fun updateText(strToAdd : String){
        val oldStr=display.text.toString()
        val cursorPs=display.selectionStart
        val leftStr=oldStr.substring(0,cursorPs)
        val rightStr=oldStr.substring(cursorPs)
        display.setText(String.format("%s%s%s",leftStr,strToAdd,rightStr))
        display.setSelection(cursorPs+strToAdd.length)
    }

    @Suppress("UNUSED_PARAMETER")
    fun zeroBtn(v: View){
        updateText(resources.getString(R.string.zeroText))
    }

    @Suppress("UNUSED_PARAMETER")
    fun oneBtn(v: View){
        updateText(resources.getString(R.string.oneText))
    }

    @Suppress("UNUSED_PARAMETER")
    fun twoBtn(v: View){
        updateText(resources.getString(R.string.twoText))
    }

    @Suppress("UNUSED_PARAMETER")
    fun threeBtn(v: View){
        updateText(resources.getString(R.string.threeText))
    }

    @Suppress("UNUSED_PARAMETER")
    fun fourBtn(v: View){
        updateText(resources.getString(R.string.fourText))
    }

    @Suppress("UNUSED_PARAMETER")
    fun fiveBtn(v: View){
        updateText(resources.getString(R.string.fiveText))
    }

    @Suppress("UNUSED_PARAMETER")
    fun sixBtn(v: View){
        updateText(resources.getString(R.string.sixText))
    }

    @Suppress("UNUSED_PARAMETER")
    fun sevenBtn(v: View){
        updateText(resources.getString(R.string.sevenText))
    }

    @Suppress("UNUSED_PARAMETER")
    fun eightBtn(v: View){
        updateText(resources.getString(R.string.eightText))
    }

    @Suppress("UNUSED_PARAMETER")
    fun nineBtn(v: View){
        updateText(resources.getString(R.string.nineText))
    }

    @Suppress("UNUSED_PARAMETER")
    fun clearBtn(v: View){
        display.setText("")
        previousCal.text=""
    }

    @Suppress("UNUSED_PARAMETER")
    fun parOpenBtn(v: View){
        updateText(resources.getString(R.string.parenthesesOpenText))
    }

    @Suppress("UNUSED_PARAMETER")
    fun parCloseBtn(v: View){
        updateText(resources.getString(R.string.parenthesesCloseText))
    }

    @Suppress("UNUSED_PARAMETER")
    fun divideBtn(v: View){
        updateText(resources.getString(R.string.divideText))
    }

    @Suppress("UNUSED_PARAMETER")
    fun multiplyBtn(v: View){
        updateText(resources.getString(R.string.multiplyText))
    }

    @Suppress("UNUSED_PARAMETER")
    fun addBtn(v: View){
        updateText(resources.getString(R.string.addText))
    }

    @Suppress("UNUSED_PARAMETER")
    fun subtractBtn(v: View){
        updateText(resources.getString(R.string.subtractText))
    }

    @Suppress("UNUSED_PARAMETER")
    fun decimalBtn(v: View){
        updateText(resources.getString(R.string.decimalText))
    }

    @Suppress("UNUSED_PARAMETER")
    fun equalBtn(v: View){
        var userExp=display.text.toString()
        previousCal.text=userExp
        userExp=userExp.replace(resources.getString(R.string.divideText).toRegex(),"/")
        userExp=userExp.replace(resources.getString(R.string.multiplyText).toRegex(),"*")
        val exp=Expression(userExp)
        val result=exp.calculate().toString()
        display.setText(result)
    }

    @Suppress("UNUSED_PARAMETER")
    fun trigSinBtn(v: View){
        updateText("sin(")
    }

    @Suppress("UNUSED_PARAMETER")
    fun trgCosBtn(v: View){
        updateText("cos(")
    }

    @Suppress("UNUSED_PARAMETER")
    fun trigTanBtn(v: View){
        updateText("tan(")
    }

    @Suppress("UNUSED_PARAMETER")
    fun trigArcSinBtn(v: View){
        updateText("arcsin(")
    }

    @Suppress("UNUSED_PARAMETER")
    fun trigArcCosBtn(v: View){
        updateText("arccos(")
    }

    @Suppress("UNUSED_PARAMETER")
    fun trigArcTanBtn(v: View){
        updateText("arctan(")
    }

    @Suppress("UNUSED_PARAMETER")
    fun logBtn(v: View){
        updateText("log(")
    }

    @Suppress("UNUSED_PARAMETER")
    fun naturalLogBtn(v: View){
        updateText("ln(")
    }

    @Suppress("UNUSED_PARAMETER")
    fun absBtn(v: View){
        updateText("abs(")
    }

    @Suppress("UNUSED_PARAMETER")
    fun piBtn(v: View){
        updateText("pi(")
    }

    @Suppress("UNUSED_PARAMETER")
    fun eBtn(v: View){
        updateText("e(")
    }

    @Suppress("UNUSED_PARAMETER")
    fun sqrtBtn(v: View){
        updateText("sqrt(")
    }

    @Suppress("UNUSED_PARAMETER")
    fun xSquareBtn(v: View){
        updateText("^2")
    }

    @Suppress("UNUSED_PARAMETER")
    fun xPowerYBtn(v: View){
        updateText("^(")
    }

    @Suppress("UNUSED_PARAMETER")
    fun primeBtn(v: View){
        updateText("isprc(")
    }

    @Suppress("UNUSED_PARAMETER")
    fun backspaceBtn(v: View){
        val cursorPos=display.selectionStart
        val textLen=display.text.length
        if(cursorPos!=0 && textLen!=0){
            val selection=display.text as SpannableStringBuilder
            selection.replace(cursorPos-1,cursorPos,"")
            display.text=selection
            display.setSelection(cursorPos-1)
        }
    }

    @Suppress("UNUSED_PARAMETER")
    fun rotateBtn(v: View){

        requestedOrientation=if(isPortrait){
            ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE
        }
        else{
            ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT
        }
        isPortrait=!isPortrait
    }

}