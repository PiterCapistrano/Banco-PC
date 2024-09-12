package com.pitercapistrano.bancopc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.pitercapistrano.bancopc.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding.imgSaldo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Cria a intenção da navegação da tela main para a tela Saldo
                Intent navegarTelaDeSaldo = new Intent(MainActivity.this, Saldo.class);
                // O comando abaixo executa a nossa intenção acima
                startActivity(navegarTelaDeSaldo);
                /* O código abaixo finaliza o contesto atual e bloqueia o botão voltar do celular,
                impossibilitando a volta para página main */
                //finish();
            }
        });

        binding.imgFaturas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navegarTelaDeFatura = new Intent(MainActivity.this, Fatura.class);
                startActivity(navegarTelaDeFatura);
            }
        });

        binding.imgTransferencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navegarTelaDeTransferencia = new Intent(MainActivity.this, Transferencia.class);
                startActivity(navegarTelaDeTransferencia);
            }
        });

        binding.imgPoupanca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navegarTelaDePoupanca = new Intent(MainActivity.this, Poupanca.class);
                startActivity(navegarTelaDePoupanca);
            }
        });
    }
}