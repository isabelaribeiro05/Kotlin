package com.example.restaurante

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurante.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
//Criação da variável binding que servirá para manipular a tela.
    private lateinit var binding:ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicialização do binding, inflando o layout associado a esta Activity.
        binding = ActivityLoginBinding.inflate(layoutInflater)

        // Configurando o conteúdo da tela para o layout inflado pelo binding.
        setContentView(binding.root)

        // Definindo o listener para o botão "Entrar".
        binding.buttonEntrar.setOnClickListener {
            // Captura os valores dos campos de texto e remove espaços adicionais.
            val username = binding.editUsername.text.toString().trim()
            val password = binding.editPassword.text.toString().trim()

            // Verificação de credenciais do usuário.
            if (username == "abc" && password == "123") {
                // Criação de Intent para mudar de Activity caso as credenciais sejam válidas.
                val i = Intent(this, MainActivity::class.java)
                // Passando o nome de usuário como extra no Intent.
                i.putExtra("username", username)
                // Iniciando a MainActivity.
                startActivity(i)
                // Finalizando a LoginActivity para que o usuário não possa voltar a ela pressionando o botão de voltar.
                finish()
            } else {
                // Exibição de uma mensagem de erro caso as credenciais estejam incorretas.
                Toast.makeText(applicationContext, "Errou", Toast.LENGTH_LONG).show()
            }
        }

    }
}