package br.com.fiap.closerain;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

import br.com.fiap.closerain.models.UsuarioViewModel;

public class CadastroActivity extends AppCompatActivity {


    String url = "http://www.google.com";

    EditText edtEmailCadastro;
    EditText edtSenhaCadastro;
    EditText edtNome;
    EditText edtSenhaCadastroConfirmacao;
    EditText edtDataNasc;
    EditText edtTelefone;


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

    public void Cadastrar(View view) throws IOException {
        if (edtEmailCadastro.getText().toString().trim().equals("") || (edtNome.getText().toString().trim().equals("")
                || (edtSenhaCadastro.getText().toString().trim().equals("") || (edtSenhaCadastroConfirmacao.getText().toString().trim().equals(""))
                || (edtDataNasc.getText().toString().trim().equals("") || (edtTelefone.getText().toString().trim().equals("")))))) {
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
        } else if (!edtSenhaCadastro.getText().toString().trim().equals(edtSenhaCadastroConfirmacao.getText().toString().trim())) {
            Toast.makeText(this, "Senhas não correspondem!", Toast.LENGTH_SHORT).show();
            edtSenhaCadastro.setText("");
            edtSenhaCadastroConfirmacao.setText("");
        } else if (edtSenhaCadastro.getText().length() < 6) {
            Toast.makeText(this, "Senha fraca!", Toast.LENGTH_SHORT).show();
            edtSenhaCadastro.setText("");
            edtSenhaCadastroConfirmacao.setText("");
        } else {


            

//            final UsuarioViewModel usuarioViewModel = new UsuarioViewModel();
//
//            usuarioViewModel.setEmail(edtEmailCadastro.getText().toString());
//            usuarioViewModel.setNome(edtNome.getText().toString());
//            usuarioViewModel.setSenha(edtSenhaCadastro.toString());
//            usuarioViewModel.setNascimento(edtDataNasc.getText().toString());
//            usuarioViewModel.setTelefone(edtTelefone.getText().toString());
//
//JSONObject params = new JSONObject();
            //params.put("Email", usuarioViewModel.getEmail());
            //params.put("Nome", usuarioViewModel.getNome());
            //params.put("Senha", usuarioViewModel.getSenha());
            //params.put("Nascimento", usuarioViewModel.getNascimento());
            //params.put("Telefone", usuarioViewModel.getTelefone());
            
//            //Enviar esse usuario para o backend
//            JsonObjectRequest postRequest = new JsonObjectRequest(Request.Method.POST,url,params,new Response.Listener()) {
//                        @Override
//                        public void onResponse(String response) {
//                            // response
//
//                        }
//                    },
//                    new Response.ErrorListener() {
//                        @Override
//                        public void onErrorResponse(VolleyError error) {
//                            // error
//                        }
//                    }
//            ) {

                  
//            };
//            RequestQueue requestQueue = Volley.newRequestQueue(this);
//            requestQueue.add(postRequest);
        }
    }

    public void irTermos(View view) {
        Intent intent = new Intent(this, TermosActivity.class);
        startActivity(intent);
    }
}

    public void irTermos(View view) {
        Intent intent = new Intent(this, TermosActivity.class);
        startActivity(intent);
    }
}
