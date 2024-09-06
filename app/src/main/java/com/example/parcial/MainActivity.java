package com.example.parcial;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText usuario, contraseña;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = findViewById(R.id.usuario);
        contraseña = findViewById(R.id.contraseña);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = usuario.getText().toString();
                String pass = contraseña.getText().toString();

                // Validación de campos vacíos
                if (user.isEmpty() || pass.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Por favor llenar los campos", Toast.LENGTH_SHORT).show();
                } else {
                    // Validación de credenciales
                    if (user.equals("uac123") && pass.equals("12345678")) {
                        // Si las credenciales son correctas, cambiar a la segunda actividad
                        Intent intent = new Intent(MainActivity.this, SegundaActivity.class);
                        startActivity(intent);
                    } else {
                        // Si las credenciales son incorrectas, mostrar mensaje
                        Toast.makeText(MainActivity.this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
