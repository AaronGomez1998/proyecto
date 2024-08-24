import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.formulario.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameEditText: EditText = findViewById(R.id.editTextName)
        val radioGroupGender: RadioGroup = findViewById(R.id.radioGroupGender)
        val checkBoxTecnologia: CheckBox = findViewById(R.id.checkBoxTecnologia)
        val checkBoxDeportes: CheckBox = findViewById(R.id.checkBoxDeportes)
        val checkBoxMusica: CheckBox = findViewById(R.id.checkBoxMusica)
        val checkBoxViajes: CheckBox = findViewById(R.id.checkBoxViajes)
        val registerButton: Button = findViewById(R.id.buttonRegister)

        registerButton.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                val name = nameEditText.text.toString()
                val selectedGenderId = radioGroupGender.checkedRadioButtonId
                val selectedGender = findViewById<RadioButton>(selectedGenderId).text.toString()
                val interests = mutableListOf<String>()

                if (checkBoxTecnologia.isChecked) interests.add("Tecnología")
                if (checkBoxDeportes.isChecked) interests.add("Deportes")
                if (checkBoxMusica.isChecked) interests.add("Música")
                if (checkBoxViajes.isChecked) interests.add("Viajes")

                // Aquí puedes hacer lo que necesites con los datos, por ejemplo, mostrarlos en un Toast
                Toast.makeText(this@MainActivity, "Nombre: $name\nGénero: $selectedGender\nIntereses: ${interests.joinToString(", ")}", Toast.LENGTH_LONG).show()
            }
        }
    }
}