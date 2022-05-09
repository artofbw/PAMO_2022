package com.example.exampleapp.ui.recipes

import android.R
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.exampleapp.databinding.FragmentRecipesBinding

class RecipesFragment : Fragment() {
    private var binding: FragmentRecipesBinding? = null
    var recipesItems = arrayOf(
            "Dorsz w sosie curry\n - 400 g filetu (polędwiczki) z dorsza\n - 1 łyżka masła klarowanego\n -2 łyżki czerwonej pasty curry (tajskiej)\n -125 ml mleka kokosowego\n\nDorsza pokroić na porcje, doprawić solą i piepirzem, usmażyć, dodać pastę i mleko kokosowe. Podawać z ryżem",
            """
                  Hummus
                  Do przygotowania hummusu używamy ugotowanej ciecierzycy. Ja skorzystałam z dwóch puszek, każda po około 200 g. Płuczemy pod zimną wodą na sitku. Przekładamy do wysokiego naczynia.
                  
                  Dodajemy oliwę z oliwek (około 3 łyżki), suszone pomidory (6-8 szt), zalewę z suszonych pomidorów (2 łyżki), pastę tahini (lub 2 łyżki sezamu), gałkę muszkatołową (1/3 łyżeczki), oregano (1/3 łyżeczki), szczyptę soli i pieprzu. Opcjonalnie dodajemy jeszcze kilka kropel soku z cytryny. Blendujemy na gładki mus. Jeśli wyszedł zbyt gęsty to można dodać dwie lub trzy łyżki wody.
                  """.trimIndent()
    )

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentRecipesBinding.inflate(inflater, container, false)
        val root: View = binding!!.root
        val listView = binding!!.recipesList
        val listViewAdapter = ArrayAdapter(requireActivity(), R.layout.simple_list_item_1, recipesItems)
        listView.adapter = listViewAdapter
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}