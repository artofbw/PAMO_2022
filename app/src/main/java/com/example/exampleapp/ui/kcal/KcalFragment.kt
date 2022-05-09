package com.example.exampleapp.ui.kcal

import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.widget.EditText
import android.widget.RadioGroup
import com.example.exampleapp.ui.kcal.KcalFragment
import android.widget.TextView
import android.text.TextWatcher
import android.text.Editable
import android.view.View
import androidx.fragment.app.Fragment
import com.example.exampleapp.databinding.FragmentKcalBinding
import java.lang.NumberFormatException
import java.text.DecimalFormat
import java.text.NumberFormat

class KcalFragment : Fragment() {
    private var binding: FragmentKcalBinding? = null
    private var weight = 0.0 // weight entered by the user
    private var height = 0.0 // height entered by the user
    private var sex // sex selected by the user
            = 0
    private var age = 0 // age entered by the user

    // called when the activity is first created
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentKcalBinding.inflate(inflater, container, false)
        val root: View = binding!!.root
        sex = binding!!.sex.checkedRadioButtonId

        // set heightEditText's TextWatcher
        binding!!.heightEditNumber.addTextChangedListener(heightEditTextWatcher)

        // set weightEditText's TextWatcher
        binding!!.weightEditNumber.addTextChangedListener(weightEditTextWatcher)

        // set ageEditText's TextWatcher
        binding!!.ageEditNumber.addTextChangedListener(ageEditTextWatcher)

        // sex selection check change listener
        binding!!.sex.setOnCheckedChangeListener { group: RadioGroup?, checkedId: Int ->
            sex = checkedId
            calculate() // update the result
        }
        return root
    }

    // calculate and display BMR
    private fun calculate() {
        if (weight > 0 && height > 0 && age > 0) {
            val result: Double
            // calculate the BMR
            result = if (sex == binding!!.male.id) {
                66.5 + 13.75 * weight + 5.003 * height - 6.775 * age
            } else {
                655.1 + 9.563 * weight + 1.85 * height - 4.676 * age
            }

            // display result formatted as a number
            setText(resultFormat.format(result))
        } else {
            setText("")
        }
    }

    fun setText(text: String?) {
        binding!!.kcalTextView.text = text
    }

    // listener object for the EditText's text-changed events
    private val weightEditTextWatcher: TextWatcher = object : TextWatcher {
        // called when the user modifies the bill amount
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            try { // get weight and display kg formatted value
                weight = s.toString().toDouble()
                setText(parameterFormat.format(weight))
            } catch (e: NumberFormatException) { // if s is empty or non-numeric
                setText("")
            }
            calculate() // update the result
        }

        override fun afterTextChanged(s: Editable) {}
        override fun beforeTextChanged(
                s: CharSequence, start: Int, count: Int, after: Int) {
        }
    }

    // listener object for the EditText's text-changed events
    private val heightEditTextWatcher: TextWatcher = object : TextWatcher {
        // called when the user modifies the bill amount
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            try { // get height and display cm formatted value
                height = s.toString().toDouble()
                setText(parameterFormat.format(height))
            } catch (e: NumberFormatException) { // if s is empty or non-numeric
                setText("")
            }
            calculate() // update the result
        }

        override fun afterTextChanged(s: Editable) {}
        override fun beforeTextChanged(
                s: CharSequence, start: Int, count: Int, after: Int) {
        }
    }

    // listener object for the EditText's text-changed events
    private val ageEditTextWatcher: TextWatcher = object : TextWatcher {
        // called when the user modifies the bill amount
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            try { // get age and display formatted value
                age = s.toString().toInt()
                setText(parameterFormat.format(age.toLong()))
            } catch (e: NumberFormatException) { // if s is empty or non-numeric
                setText("")
            }
            calculate() // update the result
        }

        override fun afterTextChanged(s: Editable) {}
        override fun beforeTextChanged(
                s: CharSequence, start: Int, count: Int, after: Int) {
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        // result formatter objects
        private val resultFormat = DecimalFormat("0.00")

        // height and weight formatter objects
        private val parameterFormat = NumberFormat.getInstance()
    }
}