package com.example.restaurante

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.restaurante.databinding.ActivityPedidoBinding

class PedidoActivity : AppCompatActivity() {
    // Inicializa a variável de binding para acessar as views da Activity
    private lateinit var binding: ActivityPedidoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        // Infla o layout usando View Binding
        binding = ActivityPedidoBinding.inflate(layoutInflater)

        // Chama a implementação de onCreate do AppCompatActivity com o Bundle
        super.onCreate(savedInstanceState)

        // Define a raiz do layout inflado como a view da atividade
        setContentView(binding.root)

        // Captura o intent que iniciou esta atividade
        val intent = intent

        // Extrai os extras do intent e converte para int, com valor padrão em caso de erro
        val quantidadePizza = intent.getStringExtra("quantidadePizza")?.toIntOrNull() ?: 0
        val quantidadeSalada = intent.getStringExtra("quantidadeSalada")?.toIntOrNull() ?: 0
        val quantidadeHamburguer = intent.getStringExtra("quantidadeHamburguer")?.toIntOrNull() ?: 0

        // Constrói a string de resumo do pedido
        val texto = buildString {
            append("Resumo do Pedido\n")
            append("Pizza: $quantidadePizza Preço: ${quantidadePizza * 8}\n")
            append("Salada: $quantidadeSalada Preço: ${quantidadeSalada * 10}\n")
            append("Hamburguer: $quantidadeHamburguer Preço: ${quantidadeHamburguer * 12}\n")
        }

        // Define o texto do TextView para exibir o resumo do pedido
        binding.textResumo.text = texto

    }
}