package com.proyecto024.dreamperfumes

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegistroUsuario : AppCompatActivity() {

    private lateinit var txtnCodVendedor: EditText
    private lateinit var txtNombre: EditText
    private lateinit var txtContrasena: EditText
    private lateinit var txtCID: EditText
    private lateinit var txtPostAddress: EditText
    private lateinit var txtPhone: EditText

    // Datos de Transferencia
    private lateinit var txtTrasNom: EditText
    private lateinit var txtCin: EditText
    private lateinit var txtTransNum: EditText
    private lateinit var txtBanco: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_usuario)

        txtnCodVendedor = findViewById(R.id.txtnCodVendedor)
        txtNombre = findViewById(R.id.txtNombre)
        txtContrasena = findViewById(R.id.txtContrasena)
        txtCID = findViewById(R.id.txtCID)
        txtPostAddress = findViewById(R.id.txtPostAddress)
        txtPhone = findViewById(R.id.txtPhone)
        // Datos de Transferencia
        txtTrasNom = findViewById(R.id.txtTrasNom)
        txtCin = findViewById(R.id.txtCin)
        txtTransNum = findViewById(R.id.txtTransNum)
        txtBanco = findViewById(R.id.txtBanco)
    }

    fun guardar(view: View) {
        val codigoVendedor = txtnCodVendedor.text.toString()
        val nombre = txtNombre.text.toString()
        val contrasena = txtContrasena.text.toString()
        val cid = txtCID.text.toString()
        val direccionPostal = txtPostAddress.text.toString()
        val telefono = txtPhone.text.toString()
        val nombreTransferencia = txtTrasNom.text.toString()
        val cin = txtCin.text.toString()
        val numeroTransferencia = txtTransNum.text.toString()
        val banco = txtBanco.text.toString()

        if (codigoVendedor.isNotEmpty() && nombre.isNotEmpty() && contrasena.isNotEmpty()) {
            val pref = getSharedPreferences(codigoVendedor, Context.MODE_PRIVATE)
            with(pref.edit()) {
                putString("nombre", nombre)
                putString("pass", contrasena)
                putString("cid", cid)
                putString("direccionPostal", direccionPostal)
                putString("telefono", telefono)
                putString("nombreTransferencia", nombreTransferencia)
                putString("cin", cin)
                putString("numeroTransferencia", numeroTransferencia)
                putString("banco", banco)
                apply()
            }
            Toast.makeText(this, "El usuario se ha registrado", Toast.LENGTH_LONG).show()
            limpiarCampos()
        } else {
            Toast.makeText(this, "Por favor, complete todos los campos obligatorios", Toast.LENGTH_LONG).show()
        }
    }

    private fun limpiarCampos() {
        txtnCodVendedor.setText("")
        txtNombre.setText("")
        txtContrasena.setText("")
        txtCID.setText("")
        txtPostAddress.setText("")
        txtPhone.setText("")
        txtTrasNom.setText("")
        txtCin.setText("")
        txtTransNum.setText("")
        txtBanco.setText("")
    }
}
