package com.pitercapistrano.bancopc;

import android.content.Intent;  // Importa a classe Intent para navegação entre telas
import android.os.Bundle;  // Importa a classe Bundle para salvar e restaurar o estado da atividade
import android.view.View;  // Importa a classe View para manipulação de interações na interface

import androidx.activity.EdgeToEdge;  // Permite o uso otimizado da tela, aproveitando as bordas
import androidx.appcompat.app.AppCompatActivity;  // Classe base para atividades
import androidx.core.graphics.Insets;  // Gerenciamento de margens do sistema
import androidx.core.view.ViewCompat;  // Proporciona compatibilidade com versões antigas de Android
import androidx.core.view.WindowInsetsCompat;  // Manipula as margens das barras do sistema (status e navegação)

import com.pitercapistrano.bancopc.databinding.ActivityMainBinding;  // Vincula os componentes da interface com o código

// Implementação da interface View.OnClickListener para gerenciar cliques e navegação entre telas
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Vinculação do layout da atividade principal com o código, permitindo acesso aos elementos da interface
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Habilita o uso completo da tela, incluindo áreas de barra de status e navegação
        EdgeToEdge.enable(this);

        // Infla o layout da atividade principal e vincula com o objeto `binding`
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        // Define o layout da atividade a partir da raiz do objeto `binding`
        setContentView(binding.getRoot());

        // Ajusta as margens da interface para considerar as barras do sistema (status, navegação)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Define o comportamento do clique na imagem de saldo, que navega para a tela "Saldo"
        binding.imgSaldo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Cria uma intenção de navegação da tela principal para a tela Saldo
                Intent navegarTelaDeSaldo = new Intent(MainActivity.this, Saldo.class);

                // Inicia a navegação para a tela de saldo
                startActivity(navegarTelaDeSaldo);

                /* O código abaixo finaliza a atividade atual, bloqueando o botão "Voltar",
                evitando o retorno para a tela principal. No entanto, ele está comentado. */
                // finish();
            }
        });

        // Define o comportamento do clique na imagem de faturas, usando o método `onClick` implementado abaixo
        binding.imgFaturas.setOnClickListener(this);

        // Define o comportamento do clique na imagem de transferência, que navega para a tela "Transferência"
        binding.imgTransferencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cria uma intenção de navegação da tela principal para a tela Transferência
                Intent navegarTelaDeTransferencia = new Intent(MainActivity.this, Transferencia.class);

                // Inicia a navegação para a tela de transferência
                startActivity(navegarTelaDeTransferencia);
            }
        });

        // Define o comportamento do clique na imagem de poupança, usando o método `onClick` implementado abaixo
        binding.imgPoupanca.setOnClickListener(this);
    }

    // Método que captura o clique em objetos que implementam `View.OnClickListener`
    @Override
    public void onClick(View view) {
        // Captura o ID do objeto clicado
        int id = view.getId();

        // Verifica se o objeto clicado é o ícone de faturas e navega para a tela correspondente
        if (id == R.id.imgFaturas) {
            // Cria uma intenção de navegação da tela principal para a tela Fatura
            Intent navegarTelaDeFatura = new Intent(MainActivity.this, Fatura.class);

            // Inicia a navegação para a tela de faturas
            startActivity(navegarTelaDeFatura);

            // Verifica se o objeto clicado é o ícone de poupança e navega para a tela correspondente
        } else if (id == R.id.imgPoupanca) {
            // Cria uma intenção de navegação da tela principal para a tela Poupança
            Intent navegarTelaDePoupanca = new Intent(MainActivity.this, Poupanca.class);

            // Inicia a navegação para a tela de poupança
            startActivity(navegarTelaDePoupanca);
        }
    }
}
