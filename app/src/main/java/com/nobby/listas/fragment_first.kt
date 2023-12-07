package com.nobby.listas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation


class fragment_first : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        val second = view.findViewById<Button>(R.id.second_button)
        val third = view.findViewById<Button>(R.id.third)

        second.setOnClickListener {
            val controller : NavController =
                Navigation.findNavController(view)
            controller.navigate(
                R.id.action_fragment_first_to_fragment_list)
        }

        third.setOnClickListener{
            val controller : NavController =
                Navigation.findNavController(view)
            controller.navigate(
                R.id.action_fragment_first_to_fragment_second)
        }




        return view
    }


}