package dev.moduloavanzado.android.practica1_androidavanzado

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.button.MaterialButton

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class FragmentCorrecto : Fragment() {
    // TODO: Rename and change types of parameters
    lateinit var  loginFragment: FragmentLoggin



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_correcto, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginFragment= FragmentLoggin()

        val goToLoginButton: MaterialButton = view.findViewById(R.id.goToLoginButton)

        goToLoginButton.setOnClickListener{
            val fragmentManager = activity?.supportFragmentManager?.beginTransaction()
            fragmentManager?.replace(R.id.container,loginFragment)
            fragmentManager?.commit()
        }

    }

}