package br.com.fiap.closerain;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

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
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    String mensagem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#7bb3e8")));
    }

    public void trocaFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .addToBackStack(null)
                .commit();
    }


    private void ConfirmarAlerta() {

        AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(this);

// Setting Dialog Title
        alertDialog2.setTitle("Confirmação de Alerta");

// Setting Dialog Message
        alertDialog2.setMessage("Você deseja alertar perigo nessa área?");

// Setting Icon to Dialog
    //    alertDialog2.setIcon(R.drawable.delete);

// Setting Positive "Yes" Btn
        alertDialog2.setPositiveButton(Html.fromHtml("<font color='#7bb3e8'>SIM</font>"),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to execute after dialog
                        Toast.makeText(getApplicationContext(),
                                "Autoridades alertadas!", Toast.LENGTH_SHORT)
                                .show();
                    }
                });
// Setting Negative "NO" Btn
        alertDialog2.setNegativeButton(Html.fromHtml("<font color='#7bb3e8'>NÃO</font>"),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to execute after dialog
                        Toast.makeText(getApplicationContext(),
                                "Operação cancelada", Toast.LENGTH_SHORT)
                                .show();
                        dialog.cancel();
                    }
                });

// Showing Alert Dialog
        alertDialog2.show();


    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.minha_conta:

                    getSupportActionBar().setTitle(Html.fromHtml("Minha Conta"));
                    return true;
                case R.id.localizacao:

                    getSupportActionBar().setTitle(Html.fromHtml("Localização"));
                    trocaFragment(new AlertarMapsActivity());

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
        mensagem = "Atenção!!! Risco de alagamento no bairro da ACLIMAÇÃO!";
        String token ="1126277588668829696-GFGeGza2Gfj2RcLBl1wzhNZfJq3Ddn";
        String secret = "ZImtS05huKKnhCaONpIkIj1eLzFHvOOTOw3TQRpCwToP0";
        AccessToken a = new AccessToken(token,secret);
        Twitter twitter = new TwitterFactory().getInstance();
        twitter.setOAuthConsumer("sN31cBmu0lQbInLiz154UKmAz", "naP0nMEG51TTyJGdFyVd3tSNaCfJncatJo1s6I6JLIOG4t8oHT");
        twitter.setOAuthAccessToken(a);
        try {
            twitter.updateStatus(mensagem);
        } catch (TwitterException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    
}
