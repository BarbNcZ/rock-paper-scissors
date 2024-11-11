package com.example.pedrapapeltesoura;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void selecionadoPedra(View view){
        this.opcaoSelecionada("pedra");
    }

    public void selecionadoPapel(View view){
        this.opcaoSelecionada("papel");
    }

    public void selecionadoTesoura(View view){
        this.opcaoSelecionada("tesoura");
    }
    public void opcaoSelecionada(String opcaoSelecionada){

        ImageView imageResultado = findViewById(R.id.imageResultado);
        TextView textoResultado = findViewById(R.id.textResultado);

        int numero = new Random().nextInt(3);
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String opcaoApp = opcoes [numero];

        switch (opcaoApp){
            case "pedra":
                imageResultado.setImageResource(R.drawable.pedra);
                break;

            case "papel":
                imageResultado.setImageResource(R.drawable.papel);
                break;

            case "tesoura":
                imageResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if(//App ganhador
                (opcaoApp == "tesoura" && opcaoSelecionada == "papel") ||
                (opcaoApp == "pedra" && opcaoSelecionada == "tesoura") ||
                (opcaoApp == "papel" && opcaoSelecionada == "pedra")
        ){

            textoResultado.setText("Você perdeu! :c");

        }else if(//Jogador ganhador

                (opcaoSelecionada == "tesoura" && opcaoApp == "papel") ||
                (opcaoSelecionada == "pedra" && opcaoApp == "tesoura") ||
                (opcaoSelecionada == "papel" && opcaoApp == "pedra")

        ){

            textoResultado.setText("Você ganhou! c:");

        }else{//Empate
            textoResultado.setText("Empate!");
        }


        System.out.println( opcaoSelecionada );

        //Random random = new Random();
        //random.nextInt()


    }

}