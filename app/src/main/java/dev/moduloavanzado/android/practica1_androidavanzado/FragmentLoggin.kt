package dev.moduloavanzado.android.practica1_androidavanzado

import android.os.Bundle
import android.text.Editable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val USER_NOMBRE = "juan"
private const val USER_PASSWORD = "12345678"
lateinit var fragmento1:FragmentCorrecto
lateinit var fragmento2:FragmentError



/**
 * A simple [Fragment] subclass.
 * Use the [FragmentLoggin.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentLoggin : Fragment() {

    // TODO: Rename and change types of parameters


    lateinit var  fragmentCorrecto: FragmentCorrecto
    lateinit var fragmentError: FragmentError

    private val userTest: Map<String, String> = mapOf(USER_NOMBRE to USER_PASSWORD);

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_loggin, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentCorrecto = FragmentCorrecto()
        fragmentError = FragmentError()

        val nombreInput: TextInputLayout = view.findViewById(R.id.nombreTextInput)
        val passInput: TextInputLayout = view.findViewById(R.id.passwordTextInput)


        val enviarButton: MaterialButton = view.findViewById(R.id.next_button)


        val passText = passInput.editText!!.text

        val nombreText = nombreInput.editText!!.text

        enviarButton.setOnClickListener{

            val passValidado = isPasswordValidate (passText)

            passInput.error = if (!passValidado) "Password debe tener por lo menos 8 caracteres" else null


            val checarNombre = userTest.contains(nombreText.toString())

            var checarPassword = false

            if (checarNombre){
                var password= userTest.getValue(nombreText.toString())
                checarPassword = password == passText.toString()
            }
            Log.d( "[Debug] Check Email", checarNombre.toString())
            Log.d("[Debug] Check Password", checarPassword.toString())

            val fragmentManager = activity?.supportFragmentManager?.beginTransaction()

            val fragment = if(checarNombre && checarPassword) fragmentCorrecto else fragmentError
            fragmentManager?.replace(R.id.container,fragment)
            fragmentManager?.commit()
        }

        passInput.editText!!.addTextChangedListener {
            val passwordValidated = isPasswordValidate(passText)
            if (passwordValidated){passInput.error=null}
        }
    }



    private fun isPasswordValidate(passText: Editable): Boolean {
     return  passText.length >=8

    }



}