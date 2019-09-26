package br.com.fiap.closerain;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#7bb3e8")));

        getSupportActionBar().setTitle(Html.fromHtml("Localização"));
        trocaFragment(new AlertarMapsActivity());




    }



    public void trocaFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .addToBackStack(null)
                .commit();
    }

    private void goToUrl(String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

    private void ConfirmarAlerta() {

        AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(this);

        alertDialog2.setTitle("Confirmação de Alerta");

        alertDialog2.setMessage("Você deseja alertar perigo nessa área?");

        alertDialog2.setPositiveButton(Html.fromHtml("<font color='#7bb3e8'>SIM</font>"),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        Toast.makeText(getApplicationContext(),
                                "Autoridades alertadas!", Toast.LENGTH_SHORT)
                                .show();
                    }
                });

        alertDialog2.setNegativeButton(Html.fromHtml("<font color='#7bb3e8'>NÃO</font>"),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        Toast.makeText(getApplicationContext(),
                                "Operação cancelada", Toast.LENGTH_SHORT)
                                .show();
                        dialog.cancel();
                    }
                });
        alertDialog2.show();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {


            switch (item.getItemId()) {
                case R.id.localizacao:

                    getSupportActionBar().setTitle(Html.fromHtml("Localização"));
                    trocaFragment(new AlertarMapsActivity());

                    return true;
                case R.id.minha_conta:

                    trocaFragment(new MinhaContaActivity());
                    getSupportActionBar().setTitle(Html.fromHtml("Minha Conta"));
                    return true;

                case R.id.social:

                    trocaFragment(new SobreNosActivity());
                    getSupportActionBar().setTitle(Html.fromHtml("Sobre Nós"));


                    return true;
                case R.id.telefones:
                    trocaFragment(new EmergenciaActivity());
                    getSupportActionBar().setTitle(Html.fromHtml("Emergência"));
                    return true;
            }
            return false;
        }
    };


    public void LigarBombeiros(View view) {

        Uri uri = Uri.parse("tel:" + 192);
        Intent intent = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(intent);
    }

    public void LigarPolicia(View view) {
        Uri uri = Uri.parse("tel:" + 190);
        Intent intent = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(intent);
    }


    public void Alertar(View view) {
        ConfirmarAlerta();
    }


    public void irTwitter(View view) {
        goToUrl("https://twitter.com/close_rain");
    }

    public void irFacebook(View view) {
    }

    public void irInstagram(View view) {
        goToUrl("https://www.instagram.com/closerain_");
    }

    public void EditarDados(View view) {
        trocaFragment(new EditarDadosActivity());
    }

    public void SalvarDados(View view) {
        trocaFragment(new MinhaContaActivity());
    }
}
