package br.com.fiap.closerain;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

public class CadastroActivity extends AppCompatActivity {

    EditText edtEmailCadastro;
    EditText edtSenhaCadastro;
    EditText edtNome;
    EditText edtSenhaCadastroConfirmacao;
    EditText edtDataNasc;
    EditText edtTelefone;

    //Tela de minha conta
//    EditText edtEmailDados;
//    EditText edtNomeDados;
//    EditText edtSenhaDados;
//    EditText edtSenhaConfirmacaoDados;
//    EditText edtDataNascDados;
//    EditText edtTelefoneDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#7bb3e8")));
        edtEmailCadastro = findViewById(R.id.edtEmailCadastro);
        edtSenhaCadastro = findViewById(R.id.edtSenhaCadastro);
        edtSenhaCadastroConfirmacao = findViewById(R.id.edtSenhaCadastroConfirmacao);
        edtNome = findViewById(R.id.edtNome);
        edtDataNasc = findViewById(R.id.edtDataNasc);
        edtTelefone = findViewById(R.id.edtTelefone);

        //Tela de minha conta
//        edtEmailDados = findViewById(R.id.edtEmailDados);
//        edtNomeDados = findViewById(R.id.edtNomeDados);
//        edtSenhaDados = findViewById(R.id.edtSenhaDados);


        //Criando mascara telefone
        SimpleMaskFormatter smf = new SimpleMaskFormatter("(NN)NNNNN - NNNN");
        MaskTextWatcher mtw = new MaskTextWatcher(edtTelefone, smf);
        edtTelefone.addTextChangedListener(mtw);

        //Mascara para data nasc
        SimpleMaskFormatter smf2 = new SimpleMaskFormatter("NN/NN/NNNN");
        MaskTextWatcher mtw2 = new MaskTextWatcher(edtDataNasc, smf2);
        edtDataNasc.addTextChangedListener(mtw2);
    }

    public void Cadastrar(View view) {
        if (edtEmailCadastro.getText().toString().trim().equals("") || (edtNome.getText().toString().trim().equals("")
                || (edtSenhaCadastro.getText().toString().trim().equals("") || (edtSenhaCadastroConfirmacao.getText().toString().trim().equals(""))
                || (edtDataNasc.getText().toString().trim().equals("") || (edtTelefone.getText().toString().trim().equals("")))))) {
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
        } else if (!edtSenhaCadastro.getText().toString().trim().equals(edtSenhaCadastroConfirmacao.getText().toString().trim())) {
            Toast.makeText(this, "Senhas não correspondem!", Toast.LENGTH_SHORT).show();
            edtSenhaCadastro.setText("");
            edtSenhaCadastroConfirmacao.setText("");
        }else if(edtSenhaCadastro.getText().length()<6){
            Toast.makeText(this, "Senha fraca!", Toast.LENGTH_SHORT).show();
            edtSenhaCadastro.setText("");
            edtSenhaCadastroConfirmacao.setText("");
        } else {

            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
    }

    public void irTermos(View view) {
        Intent intent = new Intent(this, TermosActivity.class);
        startActivity(intent);
    }
}
