package com.example.certamengithub;


//https://github.com/benjaelbakan/Certamen.git

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner sp;

    TextView IMC, mostrarRangos;

    EditText Peso, Estatura;

    Adapter adapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        sp = findViewById(R.id.spinner);
        Peso = findViewById(R.id.txtIngresarPeso);
        Estatura = findViewById(R.id.txtIngresarEstatura);
        IMC = findViewById(R.id.txtMostrarIMC);
        mostrarRangos = findViewById(R.id.txtMostrarRangos);

        ;

        String[] lista = {"Seleccione", "Femenino" , "Masculino"};
        //no supe como hacer el spinner


    }

    public void CaculoIMC(View view){

        String peso = Peso.getText().toString();
        String estatura = Estatura.getText().toString();

        Double Peso = Double.parseDouble(peso);
        Double Estatura = Double.parseDouble(estatura)/100.0;


        if(peso.isEmpty() || estatura.isEmpty()){
            Toast.makeText(this, "NO PUEDEN HABER CAMPOS VACIOS", Toast.LENGTH_SHORT).show();

        }else{
            Double IMCC = Peso / (Estatura * Estatura);
            IMC.setText(String.valueOf(IMCC));
            Toast.makeText(this, "EXITO", Toast.LENGTH_SHORT).show();
            if(IMCC <= 18.5) {
                mostrarRangos.setText("1.- Come con mas frecuencia. Empieza poco a poco a hacer 5 a 6 comidas mas pequeñas durante el día \n " +
                        "2.- Elige Alimentos con muchos nutrientes \n 3.-Agrega Aderezos \n 4.- Prueba licuados y batidos de frutas \n 5.- Controla que bebes y cuando \n 6.- Haz Ejercicio");
            } else if (IMCC >= 18.5 && IMCC <= 24.9) {
                mostrarRangos.setText("Felicitaciones usted mantiene una excelente alimentación");
            } else if (IMCC >= 25.0 && IMCC <= 29.9) {
                mostrarRangos.setText("1.- Haga 30 minutos de ejercicio aerobico 5 veces por semana \n 2.- Logre un equilibrio entre el consumo de calorias y la actividad física \n" +
                        "3.- Limite las grasas saturadas a no mas del 7% de las calorias totales \n 4.- Tenga una alimentacion baja en colesterol con carnes magras, frutas, verduras y cereales integrales");
            } else if (IMCC >= 30.0 && IMCC <= 34.9) {
                mostrarRangos.setText("1.- Haga 30 minutos de ejercicio aerobico 5 veces por semana \n 2.- Logre un equilibrio entre el consumo de calorias y la actividad física \n 3.- Limite las grasas saturadas a no mas del 7% de las calorias totales \n" +
                        "4.- Tenga una alimentacion baja en colesterol con carnes magras, frutas, verduras y cereales integrales");
            }
        }

        }
    }


