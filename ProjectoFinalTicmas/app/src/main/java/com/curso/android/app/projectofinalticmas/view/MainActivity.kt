package com.curso.android.app.projectofinalticmas.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.curso.android.app.projectofinalticmas.viewModel.MainViewModel
import com.curso.android.app.projectofinalticmas.databinding.ActivityMainBinding


@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    private var viewModel: MainViewModel? = null
    private var binding: ActivityMainBinding? = null
    private val textoInicial = ""

   
    @SuppressLint("SetTextI18n")
    @Override
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        setContentView(view)
        binding!!.resultTextView.text = textoInicial

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        if (binding != null) {

            binding!!.compareButton.setOnClickListener {

                val text1 = binding!!.editText1.text.toString()
                val text2 = binding!!.editText2.text.toString()

                viewModel!!.compareTexts(text1, text2)

                viewModel!!.comparisonResult.observe(
                    this@MainActivity
                ) { result: Boolean ->
                    if (result) {
                        binding!!.resultTextView.text = "Los textos son iguales."
                    } else {
                        binding!!.resultTextView.text = "Los textos no son iguales."
                    }

                    Handler().postDelayed({
                        binding!!.resultTextView.text = textoInicial
                    }, 5000)
                }
            }
        }
    }
}
