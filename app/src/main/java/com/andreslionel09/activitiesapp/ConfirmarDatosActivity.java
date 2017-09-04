package com.andreslionel09.activitiesapp;

import android.content.Intent;
import android.support.annotation.StringDef;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ConfirmarDatosActivity extends AppCompatActivity {

    TextView tvNombre,tvFecha,tvTelefono,tvEmail,tvDescripcion;
    Button btnEditar;
    String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);
        btnEditar = (Button) findViewById(R.id.btnEditar);
        Bundle extras = getIntent().getExtras();

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvFecha = (TextView) findViewById(R.id.tvFecha);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);

        //Seteo de valores en los camops del activity
        tvNombre.setText(extras.getString("NOMBRE"));
        tvFecha.setText(extras.getString("FECHA"));
        tvTelefono.setText(extras.getString("TELEFONO"));
        tvEmail.setText(extras.getString("EMAIL"));
        tvDescripcion.setText(extras.getString("DESCRIPCION"));

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ConfirmarDatosActivity.this, MainActivity.class);
                /*i.putExtra("NOMBRE", eNombre.getText().toString());
                i.putExtra("FECHA", eFecha.getText());
                i.putExtra("TELEFONO", eTelefono.getText());
                i.putExtra("EMAIL", eEmail.getText());
                i.putExtra("DESCRIPCION", eDescripcion.getText());*/
                startActivity(i);
            }
        });
    }
}
