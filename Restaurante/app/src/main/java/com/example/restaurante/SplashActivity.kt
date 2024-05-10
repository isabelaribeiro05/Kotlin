package com.example.restaurante

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Configura o layout da tela de splash
        setContentView(R.layout.activity_splash)

        // Cria um handler que posta um runnable na thread principal após um delay
        Handler(Looper.getMainLooper()).postDelayed({
            // Captura o intent que iniciou esta atividade
            val currentIntent = intent

            // Cria um novo intent para iniciar a PedidoActivity
            val redirectToIntent = Intent(this, PedidoActivity::class.java)

            // Copia todos os extras do intent atual para o novo intent
            redirectToIntent.putExtras(currentIntent)

            // Inicia a PedidoActivity
            startActivity(redirectToIntent)

            // Encerra a SplashActivity
            finish()
        }, 2000) // Executa após um delay de 2 segundos

    }
}