package com.yemeni.zawamelgenerator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.*

class MainActivity : AppCompatActivity() {

    val zawamelTemplates = listOf(
        "يا سلامي على {الكلمة} يوم جانا خبرها",
        "أهدي لك زامل عن {الكلمة} من قلبٍ وفي",
        "{الكلمة} يا عز الأوطان في كل حين",
        "يا {الكلمة} يا أغلى من العين والروح"
    )
    val shilatTemplates = listOf(
        "شيلة {الكلمة} تهز الجبال بصوت الرجال",
        "يا {الكلمة} فيك الحماسة والأمل",
        "شيلة على اسم {الكلمة} ما تغيب"
    )
    val qasaidTemplates = listOf(
        "يا {الكلمة} يا روح القصيدة في ليالي السمر",
        "قصيدة في حب {الكلمة} من الشاعر الفصيح",
        "يا {الكلمة} يا عنوان المجد والكرامة"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val typeSpinner = findViewById<Spinner>(R.id.typeSpinner)
        val keywordEditText = findViewById<EditText>(R.id.keywordEditText)
        val generateButton = findViewById<Button>(R.id.generateButton)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)

        generateButton.setOnClickListener {
            val type = typeSpinner.selectedItem.toString()
            val keyword = keywordEditText.text.toString().trim()
            val result = when (type) {
                "زامل" -> zawamelTemplates.random().replace("{الكلمة}", keyword)
                "شيلة" -> shilatTemplates.random().replace("{الكلمة}", keyword)
                "قصيدة" -> qasaidTemplates.random().replace("{الكلمة}", keyword)
                else -> "اختر نوع النص!"
            }
            resultTextView.text = result
        }
    }
}