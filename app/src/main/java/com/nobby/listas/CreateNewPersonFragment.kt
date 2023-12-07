package com.nobby.listas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CreateNewPersonFragment : BottomSheetDialogFragment(){

    interface OnItemAddedListener {
        fun onItemAddedListener(newItem: Person)
    }

    private var itemAddedListener: OnItemAddedListener? = null

    fun setOnItemAddedListener(listener: OnItemAddedListener) {
        itemAddedListener = listener
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.bsd_new_country, container, false)

        val button = view.findViewById<Button>(R.id.bsd_submit)

        button.setOnClickListener {
            val caseta = Person(
                9,
                "China",
                "Pekin"
            )
            itemAddedListener?.onItemAddedListener(caseta)
            dismiss()
        }

        return view
    }
}

