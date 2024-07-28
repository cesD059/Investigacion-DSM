package udb.edu.investigacion01_dsm

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    // Variables
    private lateinit var context: Context
    private lateinit var items: ArrayList<String>
    private lateinit var customAdapter: CustomAdapter
    private lateinit var listView: ListView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        context = applicationContext
        listView = findViewById(R.id.listaTareas)
        button = findViewById(R.id.btnAdd)
        items = arrayListOf()

        button.setOnClickListener {
            addItem()
        }

        customAdapter = CustomAdapter(this, items)
        listView.adapter = customAdapter
    }

    private fun addItem() {
        val input: EditText = findViewById(R.id.editText)
        val tarea: String = input.text.toString()

        if (tarea.isNotEmpty()) {
            items.add(tarea)
            customAdapter.notifyDataSetChanged()
            input.setText("")
        } else {
            Toast.makeText(context, "No se aceptan tareas vacías", Toast.LENGTH_SHORT).show()
        }
    }
}