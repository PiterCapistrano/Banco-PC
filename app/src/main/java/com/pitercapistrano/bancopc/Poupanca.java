package com.pitercapistrano.bancopc;

import android.content.Intent;  // Importa a classe Intent para permitir navegação entre telas
import android.os.Bundle;  // Importa a classe Bundle para salvar e restaurar o estado da atividade
import android.view.View;  // Importa a classe View para manipular interações com a interface do usuário

import androidx.activity.EdgeToEdge;  // Importa a classe EdgeToEdge para otimizar o uso da tela inteira
import androidx.appcompat.app.AppCompatActivity;  // Importa a classe AppCompatActivity, que é a base para atividades com suporte de ação
import androidx.core.graphics.Insets;  // Importa a classe Insets para manipular margens de barras de status e navegação
import androidx.core.view.ViewCompat;  // Proporciona compatibilidade entre versões antigas e atuais do Android
import androidx.core.view.WindowInsetsCompat;  // Manipula as margens das barras do sistema (status e navegação)

import com.pitercapistrano.bancopc.databinding.ActivityPoupancaBinding;  // Importa a classe de vinculação gerada automaticamente para o layout

public class Poupanca extends AppCompatActivity {

    // Declara o objeto `binding` para vincular o layout XML à lógica da interface
    private ActivityPoupancaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Habilita a utilização total da tela até as bordas, incluindo áreas de status e navegação
        EdgeToEdge.enable(this);

        // Infla o layout da atividade `Poupanca` e vincula-o ao objeto `binding`
        binding = ActivityPoupancaBinding.inflate(getLayoutInflater());

        // Define o conteúdo da atividade para o layout associado ao `binding`
        setContentView(binding.getRoot());

        // Configura as margens da interface para considerar as barras de status e navegação
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Esconde a ActionBar (barra de ação) para deixar a interface mais limpa
        getSupportActionBar().hide();

        // Define uma ação para o botão de navegação na toolbar, que volta para a tela principal
        binding.toolbarPoupanca.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cria uma intenção para navegar de volta à tela principal
                Intent voltarTelaPrincipal = new Intent(Poupanca.this, MainActivity.class);

                // Inicia a atividade da tela principal
                startActivity(voltarTelaPrincipal);

                // Finaliza a atividade atual (Poupanca), impedindo a volta para essa tela
                finish();
            }
        });
    }
}
