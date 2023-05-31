package ar.edu.ort.tpapp.ui.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import ar.edu.ort.tpapp.R


class SettingFragment : Fragment() {


    private lateinit var swDarkMode:Switch
    private lateinit var swNotifications:Switch

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_setting, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       initComponents()
       initListeners()
    }

    private fun initComponents(){
        swDarkMode= requireActivity().findViewById<Switch>(R.id.switch_dark_mode)
        swNotifications= requireActivity().findViewById<Switch>(R.id.switch_notifications)
    }

    private fun initListeners(){
       /*
        swDarkMode.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
            else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
            requireActivity().recreate()
        }
*/
        swNotifications.setOnCheckedChangeListener { buttonView, isChecked ->
            val text = if(isChecked) "Notificaciones activas" else "Notificaciones desactivadas"
            val duration = Toast.LENGTH_SHORT
            var toast:Toast

            if(isChecked){
                toast = Toast.makeText(requireContext(), text, duration)
                toast.show()
            }
            else {
                toast = Toast.makeText(requireContext(), text, duration)
                toast.show()
            }
        }
    }


}