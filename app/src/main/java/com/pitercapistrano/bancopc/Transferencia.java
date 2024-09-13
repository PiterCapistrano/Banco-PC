package com.pitercapistrano.bancopc;

import android.content.Intent;  // Importa a classe Intent para permitir navegação entre telas
import android.os.Bundle;  // Importa a classe Bundle para salvar e restaurar o estado da atividade
import android.view.View;  // Importa a classe View para manipular interações com a interface do usuário
import android.widget.Toast;  // Importa a classe Toast para exibir mensagens breves ao usuário

import androidx.activity.EdgeToEdge;  // Importa a classe EdgeToEdge para otimizar o uso da tela completa
import androidx.appcompat.app.AppCompatActivity;  // Importa a classe AppCompatActivity, base para atividades
import androidx.core.graphics.Insets;  // Importa a classe Insets para manipular margens de barras de status e navegação
import androidx.core.view.ViewCompat;  // Proporciona compatibilidade entre versões antigas e atuais do Android
import androidx.core.view.WindowInsetsCompat;  // Manipula as margens das barras do sistema (status e navegação)

import com.pitercapistrano.bancopc.databinding.ActivityTransferenciaBinding;  // Importa a classe de vinculação gerada automaticamente para o layout

public class Transferencia extends AppCompatActivity {

    // Declaração da variável `binding`, usada para vincular o layout XML com o código
    private ActivityTransferenciaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Habilita a utilização total da tela até as bordas, incluindo áreas de status e navegação
        EdgeToEdge.enable(this);

        // Infla o layout da atividade `Transferencia` e vincula-o ao objeto `binding`
        binding = ActivityTransferenciaBinding.inflate(getLayoutInflater());

        // Define o conteúdo da atividade com o layout associado ao `binding`
        setContentView(binding.getRoot());

        // Configura as margens da interface para considerar as barras de status e navegação
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Esconde a ActionBar (barra de ação) para deixar a interface mais limpa
        getSupportActionBar().hide();

        // Define uma ação para o botão de navegação na toolbar, voltando para a tela principal
        binding.toolbarTransferencia.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cria uma intenção para voltar à tela principal
                Intent voltarTelaPrincipal = new Intent(Transferencia.this, MainActivity.class);

                // Inicia a atividade da tela principal
                startActivity(voltarTelaPrincipal);

                // Finaliza a atividade atual (Transferencia), impedindo que o usuário retorne a esta tela
                finish();
            }
        });

        // Define a ação para o botão "Enviar" ao clicar
        binding.btEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Limpa os campos de agência, conta, dígito e valor após o envio da transferência
                binding.txtAgencia.setText("");
                binding.txtConta.setText("");
                binding.txtDigito.setText("");
                binding.txtValor.setText("");

                // Exibe uma mensagem Toast indicando o sucesso da transferência
                Toast.makeText(getApplicationContext(), "Transferência efetuada com sucesso! ", Toast.LENGTH_LONG).show();
            }
        });
    }
}
