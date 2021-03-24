package dev.moduloavanzado.android.practica1_androidavanzado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


class MainActivity : AppCompatActivity() {

    lateinit var loginFragment: FragmentLoggin
    lateinit var errorFragment: FragmentError



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginFragment = FragmentLoggin()
        errorFragment = FragmentError()


        initFragment( loginFragment )



    }

    private  fun initFragment( fragment: Fragment ){
        val  fragmentManager = supportFragmentManager.beginTransaction()
        fragmentManager.replace( R.id.container, fragment )
        fragmentManager.commit()
    }




}