package com.andreslionel09.activitiesapp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    EditText eNombre, eTelefono, eFecha, eEmail, eDescripcion;
    AppCompatButton btnSiguiente;
    private int dia, mes, ano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eNombre = (EditText) findViewById(R.id.txtNombre);
        eTelefono = (EditText) findViewById(R.id.txtTelefono);
        eEmail = (EditText) findViewById(R.id.txtEmail);
        eDescripcion = (EditText) findViewById(R.id.txtDescripcion);

        eFecha = (EditText) findViewById(R.id.txtFecha);
        eFecha.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if(hasFocus){
                    openDatePicker();
                }
            }
        });

        btnSiguiente = (AppCompatButton) findViewById(R.id.btnSiguiente);
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ConfirmarDatosActivity.class);
                i.putExtra("NOMBRE", eNombre.getText().toString());
                i.putExtra("FECHA", eFecha.getText().toString());
                i.putExtra("TELEFONO", eTelefono.getText().toString());
                i.putExtra("EMAIL", eEmail.getText().toString());
                i.putExtra("DESCRIPCION", eDescripcion.getText().toString());

                startActivity(i);
            }
        });
    }

    private void openDatePicker (){
        final Calendar c = Calendar.getInstance();
        dia = c.get(Calendar.DAY_OF_MONTH);
        mes = c.get(Calendar.MONTH);
        ano = c.get(Calendar.YEAR);

        DatePickerDialog dpDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int ano, int mes, int dia) {
                eFecha.setText(dia + "/" + String.valueOf(mes + 1) + "/" + ano);
                eTelefono.requestFocus();
            }
        }
                ,ano, mes, dia);
        dpDialog.show();
    }
}
