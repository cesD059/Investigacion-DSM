package udb.edu.investigacion01_dsm

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView

class CustomAdapter(private val context: Context, private val items: ArrayList<String>) : BaseAdapter() {

    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        val itemText = view.findViewById<TextView>(R.id.item_text)
        val deleteButton = view.findViewById<Button>(R.id.delete_button)

        itemText.text = items[position]

        // Configurar la pulsación larga para tachar el texto
        view.setOnLongClickListener {
            itemText.paintFlags = itemText.paintFlags or android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
            true
        }

        // Configurar el botón de eliminar
        deleteButton.setOnClickListener {
            items.removeAt(position)
            notifyDataSetChanged()
        }

        return view
    }
}