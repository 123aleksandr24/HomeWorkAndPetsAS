package com.example.samodelkinkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Contacts
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

private const val CHARACTER_DATA_KEY = "CHARACTER_DATA_KEY"

class MainActivity : AppCompatActivity() {
    private var characterData = CharacterGenerator.generate()

    private var Bundle.characterData
        get() = getSerializable(CHARACTER_DATA_KEY) as CharacterGenerator.CharacterData
        set(value) = putSerializable(CHARACTER_DATA_KEY, value) // 426


    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState) // почему не outState? в скобках
        //savedInstanceState.putSerializable(CHARACTER_DATA_KEY, characterData)  // 423
        savedInstanceState.characterData = characterData
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            // чтение сериализованной информации персонажа
//        characterData = savedInstanceState?.let {
//            it.getSerializable(CHARACTER_DATA_KEY)
//                    as CharacterGenerator.CharacterData
//        } ?: CharacterGenerator.generate()
        characterData = savedInstanceState?.characterData ?:
                CharacterGenerator.generate()

//        generateButton.setOnClickListener {  //обработчик щелчков
//            characterData = //CharacterGenerator.//generate()
//                //fromApiData("halfling,Lars Kizzy,14,13,8")
//               fetchCharacterData() //434
//            displayCharacterData()
//        }

        generateButton.setOnClickListener {  // 438
            launch(Contacts.Intents.UI) {
                characterData = fetchCharacterData().await()
                displayCharacterData()
            }
        }

//        val nameTextView = findViewById<TextView>(R.id.nameTextView)
//        val raceTextView = findViewById<TextView>(R.id.raceTextView)
//        val dexterityTextView = findViewById<TextView>(R.id.dexterityTextView)
//        val wisdomTextView = findViewById<TextView>(R.id.wisdomTextView)
//        val strengthTextView = findViewById<TextView>(R.id.strengthTextView)
//        val generateButton = findViewById<Button>(R.id.generateButton)

        //вывод характеристик персонажа на экран
//        characterData.run {
//            nameTextView.text = name
//            raceTextView.text = race
//            dexterityTextView.text = dex
//            wisdomTextView.text = wis
//            strengthTextView.text = str

        displayCharacterData()
    }

    private fun displayCharacterData() {
        characterData.run {
            nameTextView.text = name
            raceTextView.text = race
            dexterityTextView.text = dex
            wisdomTextView.text = wis
            strengthTextView.text = str
        }
    }

}



