package dev.moduloavanzado.android.practica1_androidavanzado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.next_button)

        val password = findViewById<TextInputLayout>(R.id.password_text_input)

        button.setOnClickListener {
            if (!isPasswordValid(password.editText!!.text)) {
                password.error = getString(R.string.shr_error_password)
            } else {
                // Clear the error.
                password.error = null

            }
        }

        password.setOnKeyListener { _, _, _ ->
            if (isPasswordValid(password.editText!!.text)) {
                // Clear the error.
                password.error = null
            }
            true
        }

    }

    private fun isPasswordValid(text: Editable?): Boolean {
        return text != null && text.length >= 8
    }
}