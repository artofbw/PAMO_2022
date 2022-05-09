package com.example.exampleapp.ui.bmi

import com.anychart.AnyChartView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.widget.EditText
import com.anychart.charts.Pie
import com.anychart.AnyChart
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.chart.common.dataentry.ValueDataEntry
import com.example.exampleapp.ui.bmi.BmiFragment
import android.widget.TextView
import android.text.TextWatcher
import android.text.Editable
import android.view.View
import androidx.fragment.app.Fragment
import com.example.exampleapp.databinding.FragmentBmiBinding
import java.lang.NumberFormatException
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.ArrayList

class BmiFragment : Fragment() {
    // Anychart PieChart
    var anyChartView: AnyChartView? = null
    private var binding: FragmentBmiBinding? = null
    private var weight = 0.0 // weight entered by the user
    private var height = 0.0 // height entered by the user

    // called when the activity is first created
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentBmiBinding.inflate(inflater, container, false)
        val root: View = binding!!.root

        // set heightEditText's TextWatcher
        binding!!.heightEditNumber.addTextChangedListener(heightEditTextWatcher)

        // set weightEditText's TextWatcher
        binding!!.weightEditNumber.addTextChangedListener(weightEditTextWatcher)
        anyChartView = binding!!.anyChartview
        return root
    }

    // setup pie chart
    fun setupPieChart() {
        val pie = AnyChart.pie()
        val dataEntryList: MutableList<DataEntry> = ArrayList()
        dataEntryList.add(ValueDataEntry("Weight", weight))
        dataEntryList.add(ValueDataEntry("Height", height))
        pie.data(dataEntryList)
        anyChartView!!.setChart(pie)
    }

    // calculate and display BMI
    private fun calculate() {
        if (weight > 0 && height > 0) {
            // calculate the BMI
            val result = weight / (height / 100 * (height / 100))

            // display result formatted as a number
            setText(resultFormat.format(result))
            setupPieChart()
        } else {
            setText("")
        }
    }

    fun setText(text: String?) {
        binding!!.bmiTextView.text = text
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