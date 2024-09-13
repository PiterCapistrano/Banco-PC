package com.pitercapistrano.bancopc;

import android.content.Intent;  // Importa a classe Intent para permitir a navegação entre telas
import android.os.Bundle;  // Importa a classe Bundle para salvar/restaurar o estado da atividade
import android.view.View;  // Importa a classe View para manipular as interações com a interface

import androidx.activity.EdgeToEdge;  // Classe para otimizar o uso da tela até as bordas
import androidx.appcompat.app.AppCompatActivity;  // Classe base para atividades com compatibilidade de ação
import androidx.core.graphics.Insets;  // Gerenciamento de margens de sistema, como barras de status e navegação
import androidx.core.view.ViewCompat;  // Proporciona compatibilidade de visualização entre versões antigas e atuais do Android
import androidx.core.view.WindowInsetsCompat;  // Manipula as margens das barras do sistema, como status e navegação

import com.pitercapistrano.bancopc.databinding.ActivityFaturaBinding;  // Classe gerada automaticamente para vincular o layout à lógica de código
import com.vinaygaba.creditcardview.CardType;  // Enum que define os tipos de cartões de crédito
import com.vinaygaba.creditcardview.CreditCardView;  // Classe usada para criar e manipular uma visualização de cartão de crédito

public class Fatura extends AppCompatActivity {

    // Declara uma instância do objeto `binding` para vincular o layout XML da atividade à lógica de código
    private ActivityFaturaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Habilita a utilização total da tela, incluindo áreas de status e navegação
        EdgeToEdge.enable(this);

        // Infla o layout da atividade `Fatura` e vincula-o ao objeto `binding`
        binding = ActivityFaturaBinding.inflate(getLayoutInflater());

        // Define o layout da atividade com a raiz do layout inflado
        setContentView(binding.getRoot());

        // Configura a interface para considerar as margens do sistema (barras de status e navegação)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Esconde a barra de ação (ActionBar) para deixar a interface mais limpa
        getSupportActionBar().hide();

        // Configura o botão de navegação na toolbar para voltar à tela principal
        binding.toolbarFatura.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cria uma intenção para navegar de volta à tela principal
                Intent voltarTelaPrincipal = new Intent(Fatura.this, MainActivity.class);

                // Inicia a atividade da tela principal
                startActivity(voltarTelaPrincipal);

                // Finaliza a atividade atual (Fatura), impedindo a volta
                finish();
            }
        });

        // Instancia e configura a visualização do cartão de crédito usando os dados fornecidos
        CreditCardView cartaoDeCredito = binding.cartaoDeCredito;

        // Define o número do cartão de crédito na visualização
        cartaoDeCredito.setCardNumber("4652 8856 9712 3548");

        // Define o nome do titular do cartão de crédito
        cartaoDeCredito.setCardName("PITER CAPISTRANO");

        // Define a data de validade do cartão
        cartaoDeCredito.setExpiryDate("08/30");

        // Define o tipo de cartão de crédito (no caso, American Express)
        cartaoDeCredito.setType(CardType.AMERICAN_EXPRESS);
    }
}
