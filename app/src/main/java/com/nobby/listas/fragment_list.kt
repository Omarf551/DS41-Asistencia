package com.nobby.listas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton

class fragment_list : Fragment() {

    private var persons: MutableList<Person> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        initData()

        val fab = view.findViewById<FloatingActionButton>(R.id.fab_new)
        val adapter = PersonAdapter(persons)
        val recyclerView = view.findViewById<RecyclerView>(R.id.personasRecycler)

        fab.setOnClickListener {
            val bottomSheetFragment = BottomSheetDialog(view.context)
            val parentView: View = layoutInflater.inflate(R.layout.bsd_new_country, null)
            bottomSheetFragment.setContentView(parentView)
            bottomSheetFragment.show()

            val newId = parentView.findViewById<EditText>(R.id.bsd_person_id)
            val newName = parentView.findViewById<EditText>(R.id.editTextNombre)
            val newLastname = parentView.findViewById<EditText>(R.id.editTextApellido)

            val button = parentView.findViewById<Button>(R.id.bsd_submit)

            button.setOnClickListener {
                val id = newId.text.toString().toIntOrNull()
                val name = newName.text.toString()
                val lastname = newLastname.text.toString()

                if (id != null) {
                    val newPerson = Person(
                        id = id,
                        name = name,
                        lastname = lastname
                    )

                    persons.add(newPerson)
                    adapter.notifyDataSetChanged()
                    bottomSheetFragment.dismiss()
                } else {
                    // Manejar el caso en el que el ID no sea válido (no sea un número)
                    // Podrías mostrar un mensaje de error aquí
                }
            }
        }

        val layoutManager = LinearLayoutManager(container?.context)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
        return view
    }

    private fun initData() {
        persons = mutableListOf(
            Person(1, "Juan", "Perez"),
            Person(2, "Maria", "Gonzalez"),
            Person(4,"Omar","Franco"),
            Person(5,"Cesar","Teran"),
            Person(6,"Luis","Serra"),
            Person(7,"Leon","Kenedy"),
            Person(8,"Evelyn","Lopez"),
            Person(9,"Cristian","Perez"),
            Person(10,"Adan","Salazar"),
            Person(11,"Barack","Obama"),
            Person(12,"Jose","Soto"),
            Person(13,"Sebastian","Machado"),
            Person(14,"Cintia","Hernadnez"),
            Person(15,"Abram","Sanchez"),

        )
    }
}
