package ar.edu.ort.tpapp.ui.views.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ar.edu.ort.tpapp.R

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.nombrePerfil).text = getName()
    }

    private fun getName():String{
        val sharedPreferences = requireContext().applicationContext.getSharedPreferences("loginPreferences", Context.MODE_PRIVATE)
        return sharedPreferences.getString("nombre", "") ?: ""
    }
}