package br.com.fiap.closerain;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText edtEmail;
    EditText edtSenha;
    CheckBox chkManterConectado;

    //Shared Preferences
    SharedPreferences sp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#7bb3e8")));
        edtEmail = findViewById(R.id.edtEmail);
        edtSenha = findViewById(R.id.edtSenha);
        chkManterConectado = findViewById(R.id.chkManterConectado);

        sp = getPreferences(MODE_PRIVATE);
        boolean conectado = sp.getBoolean("conectado", false);

        if (conectado){
            String email = sp.getString("email", null);
            String senha = sp.getString("senha", null);

            edtEmail.setText(email);
            edtSenha.setText(senha);
            chkManterConectado.setChecked(true);
        }


    }

    public void Logar(View view) {
        String email = edtEmail.getText().toString().trim();
        String senha =edtSenha.getText().toString().trim();
        boolean manterConectado = chkManterConectado.isChecked();



        if (edtEmail.getText().toString().trim().equals("") || (edtSenha.getText().toString().trim().equals(""))) {
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
        } else {
            SharedPreferences.Editor edit = sp.edit();
            if (manterConectado){
                edit.putString("email", email);
                edit.putString("senha", senha);
                edit.putBoolean("conectado", manterConectado);
            }else{
                edit.clear();
            }
            edit.commit();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    public void CadastrarUsuario(View view) {

        Intent intent = new Intent(this, CadastroActivity.class);
        startActivity(intent);

    }


}