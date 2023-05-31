package ar.edu.ort.tpapp.ui.views.fragments

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import ar.edu.ort.tpapp.R
import ar.edu.ort.tpapp.databinding.FragmentHomeScreenBinding
import ar.edu.ort.tpapp.databinding.FragmentLoginBinding
import ar.edu.ort.tpapp.ui.views.activities.MainActivity
import com.google.android.material.bottomnavigation.BottomNavigationView


class LoginFragment : Fragment(R.layout.fragment_login) {

    private var _binding: FragmentLoginBinding?=null
    private val binding get()= _binding!!
    private lateinit var sharedPreferences:SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i("LoginFragment","onCreateView() - init")
        // Inflate the layout for this fragment
        _binding= FragmentLoginBinding.inflate(inflater,container,false)
        val view= binding.root
        Log.i("LoginFragment","onCreateView() - out")

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPreferences = requireContext().applicationContext.getSharedPreferences("loginPreferences", Context.MODE_PRIVATE)

        (requireActivity() as AppCompatActivity).supportActionBar?.hide()

        val bottomNavigationView = requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.visibility = View.GONE

        val btnLogin = view.findViewById<Button>(R.id.btnLogin)
        btnLogin.setOnClickListener{
            findNavController().navigate(R.id.action_loginFragment_to_homeScreenFragment)
        }

        initListeners(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        (requireActivity() as AppCompatActivity).supportActionBar?.show()
        requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigationView)
            .visibility = View.VISIBLE
    }

    private fun initListeners(view: View){
        binding.btnLogin.setOnClickListener {
            saveName(view.findViewById<TextView>(R.id.editTextTextPersonName).text.toString())
            (requireActivity() as MainActivity).updateHeaderName()
            findNavController().navigate(R.id.action_loginFragment_to_homeScreenFragment)
        }
    }

    private fun saveName(nombre:String){
        val editor = sharedPreferences.edit()
        editor.putString("nombre", nombre)
        editor.apply()
    }
}