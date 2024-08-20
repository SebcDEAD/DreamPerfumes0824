package com.proyecto024.dreamperfumes

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.proyecto024.dreamperfumes.databinding.ActivityMainBinding

class SearchActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var myAdapter: MyAdapter // Asegúrate de crear e inicializar tu adaptador

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configuración del RecyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        myAdapter = MyAdapter() // Inicializa tu adaptador
        binding.recyclerView.adapter = myAdapter

        // Configuración del SearchView
        binding.svDogs.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // Realiza la búsqueda aquí
                if (query != null) {
                    performSearch(query)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // Filtra los resultados aquí
                if (newText != null) {
                    filterResults(newText)
                }
                return true
            }
        })
    }

    private fun performSearch(query: String) {
        // Implementa la lógica para realizar la búsqueda
        // Por ejemplo, actualizar el adaptador con los resultados de la búsqueda
        myAdapter.performSearch(query)
    }

    private fun filterResults(newText: String) {
        // Implementa la lógica para filtrar los resultados en tiempo real
        // Por ejemplo, actualizar el adaptador con los resultados filtrados
        myAdapter.filterResults(newText)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.navedrawer, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> {
                // Lógica para la opción del menú "Home"
                return true
            }
            R.id.nav_gallery -> {
                // Lógica para la opción del menú "Gallery"
                return true
            }
            R.id.nav_slideshow -> {
                // Lógica para la opción del menú "Slideshow"
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}




