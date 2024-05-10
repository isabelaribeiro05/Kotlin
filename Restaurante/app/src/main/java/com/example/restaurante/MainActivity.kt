package com.example.restaurante

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurante.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        // Infla o layout da Activity usando View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)

        // Define a view principal da Activity para o layout inflado
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Recupera o extra 'username' do Intent que iniciou esta Activity
        val username = intent.extras?.getString("username")

        // Configura a mensagem de boas-vindas se o username não estiver vazio ou nulo
        if (!username.isNullOrEmpty()) {
            binding.textOla.text = "Olá $username"
        }

        // Define um listener para o botão 'Fechar' que termina todas as atividades na pilha
        binding.buttonFechar.setOnClickListener {
            finishAffinity()  // Encerra todas as atividades anteriores
        }

        // Define um listener para o botão 'Pedir'
        binding.buttonPedir.setOnClickListener {
            val i = Intent(this, SplashActivity::class.java)
            // Passa as quantidades como extras para a próxima Activity
            i.putExtra("quantidadePizza", binding.editQuantidadePizza.text.toString())
            i.putExtra("quantidadeSalada", binding.editQuantidadeSalada.text.toString())
            i.putExtra("quantidadeHamburguer", binding.editQuantidadeHamburguer.text.toString())
            startActivity(i)  // Inicia a SplashActivity
            finish()  // Finaliza a MainActivity
        }

        // Define listeners para os checkboxes de cada item do menu
        // Ativa ou desativa os inputs de quantidade e visibilidade dos preços conforme o checkbox é marcado ou desmarcado
        binding.checkPizza.setOnClickListener {
            if (binding.checkPizza.isChecked) {
                binding.editQuantidadePizza.setText("1")
                binding.textPrecoPizza.visibility = View.VISIBLE
            } else {
                binding.editQuantidadePizza.setText("0")
                binding.textPrecoPizza.visibility = View.GONE
            }
        }

        binding.checkSalada.setOnClickListener {
            if (binding.checkSalada.isChecked) {
                binding.editQuantidadeSalada.setText("1")
                binding.textPrecoSalada.visibility = View.VISIBLE
            } else {
                binding.editQuantidadeSalada.setText("0")
                binding.textPrecoSalada.visibility = View.GONE
            }
        }

        binding.checkHamburger.setOnClickListener {
            if (binding.checkHamburger.isChecked) {
                binding.editQuantidadeHamburguer.setText("1")
                binding.textPrecoHamburguer.visibility = View.VISIBLE
            } else {
                binding.editQuantidadeHamburguer.setText("0")
                binding.textPrecoHamburguer.visibility = View.GONE
            }
        }

    }
}