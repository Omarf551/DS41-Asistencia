package com.nobby.listas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

    class PersonAdapter(private var personas: List<Person>): RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {

            val inflater = LayoutInflater.from(parent.context)

            val view = inflater.inflate(R.layout.item_person, parent, false)
            return PersonViewHolder(view)
        }

        override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
            val persona = personas[position]
            holder.render(persona)


        }

        override fun getItemCount(): Int {
            return personas.size
        }

        class PersonViewHolder(view: View): RecyclerView.ViewHolder(view) {

            val name: TextView = view.findViewById(R.id.person_name)
            val lastName: TextView = view.findViewById(R.id.person_last_name)


            fun render(persona: Person) {
                name.text = persona.name
                lastName.text = persona.lastname

            }
        }
    }