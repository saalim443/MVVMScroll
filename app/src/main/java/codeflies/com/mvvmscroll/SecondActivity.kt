package codeflies.com.mvvmscroll

import android.graphics.Color
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import codeflies.com.mvvmscroll.databinding.ActivitySecondBinding
import codeflies.com.mvvmscroll.model.PostResultItem

class SecondActivity : AppCompatActivity() {
    companion object {
        lateinit var data: PostResultItem
    }

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set the formatted text to textView2
        binding.textView2.text = formatData(data)

        // Log the data
        Log.e("salim", data.toString())
    }

    private fun formatData(data: PostResultItem): SpannableStringBuilder {
        // Create a SpannableStringBuilder to format the text
        val formattedText = SpannableStringBuilder()

        // Append "title:" as normal text in black color
        val titleStartIndex = formattedText.length
        formattedText.append("title: ")
        formattedText.setSpan(StyleSpan(android.graphics.Typeface.BOLD), titleStartIndex, formattedText.length, 0)
        formattedText.setSpan(ForegroundColorSpan(Color.BLACK), 0, titleStartIndex, 0)
        formattedText.append(data.title)
        // Append new line
        formattedText.append("\n")
        // Append the content with blue color and bold
        val contentStartIndex = formattedText.length
        formattedText.append("category: ${data.content}")
        formattedText.setSpan(ForegroundColorSpan(Color.BLUE), contentStartIndex, formattedText.length, 0)
        formattedText.setSpan(StyleSpan(android.graphics.Typeface.BOLD), contentStartIndex, formattedText.length, 0)

        return formattedText
    }
}


