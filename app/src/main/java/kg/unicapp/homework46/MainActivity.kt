package kg.unicapp.homework46

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.textView)
        val pref = getPreferences(Context.MODE_PRIVATE)
        val text = pref.getString("Text", "")
        textView.text = text
    }

    fun onSave(view: View) {
        val editText = findViewById<EditText>(R.id.editText)
        val textView = findViewById<TextView>(R.id.textView)
        val pref = getPreferences(Context.MODE_PRIVATE)
        val edit = pref.edit()
        edit.putString("Text", editText.text.toString())
        edit.apply()
        textView.text = editText.text.toString()
    }

    fun onDelete(view: View) {
        val editText = findViewById<EditText>(R.id.editText)
        val textView = findViewById<TextView>(R.id.textView)
        val pref = getPreferences(Context.MODE_PRIVATE)
        val edit = pref.edit()
        edit.clear()
        edit.apply()
        textView.text = ""
        editText.setText("")

    }
}