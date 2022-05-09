package com.example.exampleapp.ui.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.exampleapp.databinding.FragmentQuizBinding
import java.util.*

class QuizFragment : Fragment() {
    private var binding: FragmentQuizBinding? = null
    private var b_answer1: Button? = null
    private var b_answer2: Button? = null
    private var b_answer3: Button? = null
    private var b_answer4: Button? = null
    var tv_food: ImageView? = null
    var foodItemList: MutableList<FoodItem>? = null
    var r: Random? = null
    var turn = 1
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentQuizBinding.inflate(inflater, container, false)
        val root: View = binding!!.root
        tv_food = binding!!.ivFlag
        var b_answer1 = binding!!.bAnswer1
        var b_answer2 = binding!!.bAnswer2
        var b_answer3 = binding!!.bAnswer3
        var b_answer4 = binding!!.bAnswer4
        var foodItemList = ArrayList<FoodItem>()
        r = Random()

        // add quiz stuff
        for (i in Database().answers.indices) {
            foodItemList.add(FoodItem(Database().answers[i], Database().foods[i]))
        }

        // shuffle quiz
        Collections.shuffle(foodItemList)
        newQuestion(turn)
        b_answer1!!.setOnClickListener {
            if (b_answer1!!.text.toString().equals(foodItemList.get(turn - 1).name, ignoreCase = true)) {
                Toast.makeText(root.context, "Correct", Toast.LENGTH_SHORT).show()

                // check if the last question
                if (turn < foodItemList.size) {
                    turn++
                    newQuestion(turn)
                } else {
                    Toast.makeText(root.context, "You finished the game", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(root.context, "Wrong", Toast.LENGTH_SHORT).show()
                Toast.makeText(root.context, "You list the game", Toast.LENGTH_SHORT).show()
            }
        }
        b_answer2!!.setOnClickListener {
            if (b_answer2!!.text.toString().equals(foodItemList.get(turn - 1).name, ignoreCase = true)) {
                Toast.makeText(root.context, "Correct", Toast.LENGTH_SHORT).show()

                // check if the last question
                if (turn < foodItemList.size) {
                    turn++
                    newQuestion(turn)
                } else {
                    Toast.makeText(root.context, "You finished the game", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(root.context, "Wrong", Toast.LENGTH_SHORT).show()
                Toast.makeText(root.context, "You list the game", Toast.LENGTH_SHORT).show()
            }
        }
        b_answer3!!.setOnClickListener {
            if (b_answer3!!.text.toString().equals(foodItemList.get(turn - 1).name, ignoreCase = true)) {
                Toast.makeText(root.context, "Correct", Toast.LENGTH_SHORT).show()

                // check if the last question
                if (turn < foodItemList.size) {
                    turn++
                    newQuestion(turn)
                } else {
                    Toast.makeText(root.context, "You finished the game", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(root.context, "Wrong", Toast.LENGTH_SHORT).show()
                Toast.makeText(root.context, "You list the game", Toast.LENGTH_SHORT).show()
            }
        }
        b_answer4!!.setOnClickListener {
            if (b_answer4!!.text.toString().equals(foodItemList.get(turn - 1).name, ignoreCase = true)) {
                Toast.makeText(root.context, "Correct", Toast.LENGTH_SHORT).show()

                // check if the last question
                if (turn < foodItemList.size) {
                    turn++
                    newQuestion(turn)
                } else {
                    Toast.makeText(root.context, "You finished the game", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(root.context, "Wrong", Toast.LENGTH_SHORT).show()
                Toast.makeText(root.context, "You list the game", Toast.LENGTH_SHORT).show()
            }
        }
        return root
    }

    private fun newQuestion(number: Int) {
        // set food image to the screen
        tv_food!!.setImageResource(foodItemList!![number - 1].image)

        // button's correct answer setup
        val correct_answer = r!!.nextInt(4) + 1
        val firstButton = number - 1
        var secondButton: Int
        var thirdButton: Int
        var fourthButton: Int
        when (correct_answer) {
            1 -> {
                b_answer1?.setText(foodItemList!![firstButton].name)
                do {
                    secondButton = r!!.nextInt(foodItemList!!.size)
                } while (secondButton == firstButton)
                do {
                    thirdButton = r!!.nextInt(foodItemList!!.size)
                } while (thirdButton == firstButton || thirdButton == secondButton)
                do {
                    fourthButton = r!!.nextInt(foodItemList!!.size)
                } while (fourthButton == firstButton || fourthButton == secondButton || fourthButton == thirdButton)
                b_answer2?.setText(foodItemList!![secondButton].name)
                b_answer3?.setText(foodItemList!![thirdButton].name)
                b_answer4?.setText(foodItemList!![fourthButton].name)
            }
            2 -> {
                b_answer2?.setText(foodItemList!![firstButton].name)
                do {
                    secondButton = r!!.nextInt(foodItemList!!.size)
                } while (secondButton == firstButton)
                do {
                    thirdButton = r!!.nextInt(foodItemList!!.size)
                } while (thirdButton == firstButton || thirdButton == secondButton)
                do {
                    fourthButton = r!!.nextInt(foodItemList!!.size)
                } while (fourthButton == firstButton || fourthButton == secondButton || fourthButton == thirdButton)
                b_answer1?.setText(foodItemList!![secondButton].name)
                b_answer3?.setText(foodItemList!![thirdButton].name)
                b_answer4?.setText(foodItemList!![fourthButton].name)
            }
            3 -> {
                b_answer3?.setText(foodItemList!![firstButton].name)
                do {
                    secondButton = r!!.nextInt(foodItemList!!.size)
                } while (secondButton == firstButton)
                do {
                    thirdButton = r!!.nextInt(foodItemList!!.size)
                } while (thirdButton == firstButton || thirdButton == secondButton)
                do {
                    fourthButton = r!!.nextInt(foodItemList!!.size)
                } while (fourthButton == firstButton || fourthButton == secondButton || fourthButton == thirdButton)
                b_answer2?.setText(foodItemList!![secondButton].name)
                b_answer1?.setText(foodItemList!![thirdButton].name)
                b_answer4?.setText(foodItemList!![fourthButton].name)
            }
            4 -> {
                b_answer4?.setText(foodItemList!![firstButton].name)
                do {
                    secondButton = r!!.nextInt(foodItemList!!.size)
                } while (secondButton == firstButton)
                do {
                    thirdButton = r!!.nextInt(foodItemList!!.size)
                } while (thirdButton == firstButton || thirdButton == secondButton)
                do {
                    fourthButton = r!!.nextInt(foodItemList!!.size)
                } while (fourthButton == firstButton || fourthButton == secondButton || fourthButton == thirdButton)
                b_answer2?.setText(foodItemList!![secondButton].name)
                b_answer3?.setText(foodItemList!![thirdButton].name)
                b_answer1?.setText(foodItemList!![fourthButton].name)
            }
        }
    }
}