package com.example.dimitri.pedrapapeloutesoura;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void opcaoSelecionada(String escolhaUsuario) {

        ImageView imagemJogador = findViewById(R.id.imagemJogador);

        switch (escolhaUsuario) {
            case "Pedra":
                imagemJogador.setImageResource(R.drawable.pedra);
                break;

            case "Papel":
                imagemJogador.setImageResource(R.drawable.papel);
                break;

            case "Tesoura":
                imagemJogador.setImageResource(R.drawable.tesoura);
                break;
        }

        ImageView imagemResultado = findViewById(R.id.imageResultado);
        TextView textoResultado = findViewById(R.id.textResultado);

        //gerar numero aleatório para escolha da opção do App
        String[] opcoes = {"Pedra", "Papel", "Tesoura"};
        int numero = new Random().nextInt(3);
        String escolhaApp = opcoes[numero];

        switch (escolhaApp) {
            case "Pedra" :
                imagemResultado.setImageResource(R.drawable.pedra);
                break;

            case "Papel" :
                imagemResultado.setImageResource(R.drawable.papel);
                break;

            case "Tesoura" :
                imagemResultado.setImageResource(R.drawable.tesoura);
                break;

        }

        if (
                (escolhaApp == "Pedra" && escolhaUsuario == "Tesoura") ||
                (escolhaApp == "Tesoura" && escolhaUsuario == "Papel") ||
                (escolhaApp == "Papel" && escolhaUsuario == "Pedra")

                ) {//App é o ganhador
            textoResultado.setText("Você perdeu! :( ");

        }else if(

                (escolhaUsuario == "Pedra" && escolhaApp == "Tesoura") ||
                (escolhaUsuario == "Tesoura" && escolhaApp == "Papel") ||
                (escolhaUsuario == "Papel" && escolhaApp == "Pedra")

                ) {//Jogador é o ganhador

            textoResultado.setText("Você ganhou! :) ");

        }else {//Empate
            textoResultado.setText("Empatamos! ;) ");

        }

    }

    public void selecionarPedra(View view) {
        this.opcaoSelecionada("Pedra");
    }

    public void selecionarPapel(View view) {
        this.opcaoSelecionada("Papel");
    }

    public void selecionarTesoura(View view) {
        this.opcaoSelecionada("Tesoura");
    }
}
