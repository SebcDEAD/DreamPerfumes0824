package com.proyecto024.dreamperfumes

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ActivityLogin : AppCompatActivity() {

    private lateinit var txtnCodVendedor: EditText
    private lateinit var txtContrasena: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        txtnCodVendedor = findViewById(R.id.txtnCodVendedor)
        txtContrasena = findViewById(R.id.txtContrasena)
    }

    fun login(view: View) {
        val username = txtnCodVendedor.text.toString()
        val contrasena = txtContrasena.text.toString()

        if (username.isNotEmpty() && contrasena.isNotEmpty()) {
            val pref = getSharedPreferences(username, Context.MODE_PRIVATE)
            val storedPassword = pref.getString("pass", "")

            if (storedPassword == contrasena) {
                Toast.makeText(this, "El usuario se ha logeado", Toast.LENGTH_LONG).show()
                // Iniciar SearchActivity
                val intent = Intent(this, SearchActivity::class.java)
                startActivity(intent)
                finish() // Cerrar la actividad de login para que no pueda volver con el botón de atrás
            } else {
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_LONG).show()
            }
        } else {
            Funciones.validar( "username", "password") { response ->
                if (response != null) {
                    // Handle the response here
                    println("Resultado JSON: $response")
                } else {
                    // Handle the error
                    println("Failed to get response")
                }
            }
            Toast.makeText(this, "Por favor, introduce ambos campos", Toast.LENGTH_LONG).show()
        }

        txtnCodVendedor.setText("")
        txtContrasena.setText("")
    }

    fun atras(view: View) {
        val registroIntent = Intent(this, RegistroUsuario::class.java)
        startActivity(registroIntent)
    }
}


