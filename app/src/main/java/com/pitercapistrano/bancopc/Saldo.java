package com.pitercapistrano.bancopc;

import android.content.Intent;  // Importa a classe Intent para navegação entre telas
import android.os.Bundle;  // Importa a classe Bundle para salvar e restaurar o estado da atividade
import android.view.View;  // Importa a classe View para manipulação de interações na interface

import androidx.activity.EdgeToEdge;  // Permite o uso otimizado da tela, aproveitando as bordas
import androidx.appcompat.app.AppCompatActivity;  // Classe base para atividades
import androidx.core.graphics.Insets;  // Gerenciamento de margens do sistema
import androidx.core.view.ViewCompat;  // Proporciona compatibilidade com versões antigas de Android
import androidx.core.view.WindowInsetsCompat;  // Manipula as margens das barras do sistema (status e navegação)

import com.pitercapistrano.bancopc.databinding.ActivitySaldoBinding;  // Vincula os componentes da interface com o código

public class Saldo extends AppCompatActivity {

    // Vinculação do layout da atividade Saldo com o código, permitindo acesso aos elementos da interface
    private ActivitySaldoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Habilita o uso completo da tela, incluindo áreas de barra de status e navegação
        EdgeToEdge.enable(this);

        // Infla o layout da atividade Saldo e vincula com o objeto `binding`
        binding = ActivitySaldoBinding.inflate(getLayoutInflater());

        // Define o layout da atividade a partir da raiz do objeto `binding`
        setContentView(binding.getRoot());

        // Ajusta as margens da interface para considerar as barras do sistema (status, navegação)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Esconde a barra de ação (ActionBar) da tela, proporcionando uma interface mais limpa
        getSupportActionBar().hide();

        // Define o comportamento do clique no botão de navegação na toolbar para voltar à tela anterior
        binding.toolbarSaldo.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finaliza a atividade atual, retornando para a tela anterior (MainActivity)
                finish();
            }
        });
    }
}
