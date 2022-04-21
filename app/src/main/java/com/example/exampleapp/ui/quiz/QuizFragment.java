package com.example.exampleapp.ui.quiz;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.exampleapp.R;
import com.example.exampleapp.databinding.FragmentQuizBinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class QuizFragment extends Fragment {

    private FragmentQuizBinding binding;

    private Button b_answer1, b_answer2, b_answer3, b_answer4;
    ImageView tv_food;
    List<FoodItem> foodItemList;

    Random r;
    int turn = 1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentQuizBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        tv_food = binding.ivFlag;

        b_answer1 = binding.bAnswer1;
        b_answer2 = binding.bAnswer2;
        b_answer3 = binding.bAnswer3;
        b_answer4 = binding.bAnswer4;

        foodItemList = new ArrayList<>();
        r = new Random();

        // add quiz stuff
        for (int i = 0; i < new Database().answers.length; i++) {
            foodItemList.add(new FoodItem(new Database().answers[i], new Database().foods[i]));
        }

        // shuffle quiz
        Collections.shuffle(foodItemList);
        newQuestion(turn);

        b_answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (b_answer1.getText().toString().equalsIgnoreCase(foodItemList.get(turn - 1).getName())) {
                    Toast.makeText(root.getContext(), "Correct", Toast.LENGTH_SHORT).show();

                    // check if the last question
                    if (turn < foodItemList.size()) {
                        turn++;
                        newQuestion(turn);
                    } else {
                        Toast.makeText(root.getContext(), "You finished the game", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(root.getContext(), "Wrong", Toast.LENGTH_SHORT).show();
                    Toast.makeText(root.getContext(), "You list the game", Toast.LENGTH_SHORT).show();
                }

            }
        });

        b_answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (b_answer2.getText().toString().equalsIgnoreCase(foodItemList.get(turn - 1).getName())) {
                    Toast.makeText(root.getContext(), "Correct", Toast.LENGTH_SHORT).show();

                    // check if the last question
                    if (turn < foodItemList.size()) {
                        turn++;
                        newQuestion(turn);
                    } else {
                        Toast.makeText(root.getContext(), "You finished the game", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(root.getContext(), "Wrong", Toast.LENGTH_SHORT).show();
                    Toast.makeText(root.getContext(), "You list the game", Toast.LENGTH_SHORT).show();
                }

            }
        });

        b_answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (b_answer3.getText().toString().equalsIgnoreCase(foodItemList.get(turn - 1).getName())) {
                    Toast.makeText(root.getContext(), "Correct", Toast.LENGTH_SHORT).show();

                    // check if the last question
                    if (turn < foodItemList.size()) {
                        turn++;
                        newQuestion(turn);
                    } else {
                        Toast.makeText(root.getContext(), "You finished the game", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(root.getContext(), "Wrong", Toast.LENGTH_SHORT).show();
                    Toast.makeText(root.getContext(), "You list the game", Toast.LENGTH_SHORT).show();
                }

            }
        });

        b_answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (b_answer4.getText().toString().equalsIgnoreCase(foodItemList.get(turn - 1).getName())) {
                    Toast.makeText(root.getContext(), "Correct", Toast.LENGTH_SHORT).show();

                    // check if the last question
                    if (turn < foodItemList.size()) {
                        turn++;
                        newQuestion(turn);
                    } else {
                        Toast.makeText(root.getContext(), "You finished the game", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(root.getContext(), "Wrong", Toast.LENGTH_SHORT).show();
                    Toast.makeText(root.getContext(), "You list the game", Toast.LENGTH_SHORT).show();
                }

            }
        });

        return root;
    }

    private void newQuestion(int number) {
        // set food image to the screen
        tv_food.setImageResource(foodItemList.get(number - 1).getImage());

        // button's correct answer setup
        int correct_answer = r.nextInt(4) + 1;

        int firstButton = number - 1;
        int secondButton;
        int thirdButton;
        int fourthButton;

        switch (correct_answer) {
            case 1:
                b_answer1.setText(foodItemList.get(firstButton).getName());

                do {
                    secondButton = r.nextInt(foodItemList.size());
                } while (secondButton == firstButton);

                do {
                    thirdButton = r.nextInt(foodItemList.size());
                } while (thirdButton == firstButton || thirdButton == secondButton);

                do {
                    fourthButton = r.nextInt(foodItemList.size());
                } while (fourthButton == firstButton || fourthButton == secondButton || fourthButton == thirdButton);

                b_answer2.setText(foodItemList.get(secondButton).getName());
                b_answer3.setText(foodItemList.get(thirdButton).getName());
                b_answer4.setText(foodItemList.get(fourthButton).getName());

                break;

            case 2:
                b_answer2.setText(foodItemList.get(firstButton).getName());

                do {
                    secondButton = r.nextInt(foodItemList.size());
                } while (secondButton == firstButton);

                do {
                    thirdButton = r.nextInt(foodItemList.size());
                } while (thirdButton == firstButton || thirdButton == secondButton);

                do {
                    fourthButton = r.nextInt(foodItemList.size());
                } while (fourthButton == firstButton || fourthButton == secondButton || fourthButton == thirdButton);

                b_answer1.setText(foodItemList.get(secondButton).getName());
                b_answer3.setText(foodItemList.get(thirdButton).getName());
                b_answer4.setText(foodItemList.get(fourthButton).getName());

                break;

            case 3:
                b_answer3.setText(foodItemList.get(firstButton).getName());

                do {
                    secondButton = r.nextInt(foodItemList.size());
                } while (secondButton == firstButton);

                do {
                    thirdButton = r.nextInt(foodItemList.size());
                } while (thirdButton == firstButton || thirdButton == secondButton);

                do {
                    fourthButton = r.nextInt(foodItemList.size());
                } while (fourthButton == firstButton || fourthButton == secondButton || fourthButton == thirdButton);

                b_answer2.setText(foodItemList.get(secondButton).getName());
                b_answer1.setText(foodItemList.get(thirdButton).getName());
                b_answer4.setText(foodItemList.get(fourthButton).getName());

                break;

            case 4:
                b_answer4.setText(foodItemList.get(firstButton).getName());

                do {
                    secondButton = r.nextInt(foodItemList.size());
                } while (secondButton == firstButton);

                do {
                    thirdButton = r.nextInt(foodItemList.size());
                } while (thirdButton == firstButton || thirdButton == secondButton);

                do {
                    fourthButton = r.nextInt(foodItemList.size());
                } while (fourthButton == firstButton || fourthButton == secondButton || fourthButton == thirdButton);

                b_answer2.setText(foodItemList.get(secondButton).getName());
                b_answer3.setText(foodItemList.get(thirdButton).getName());
                b_answer1.setText(foodItemList.get(fourthButton).getName());

                break;
        }

    }
}