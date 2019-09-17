package br.com.fiap.closerain;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);

        mTextMessage = findViewById(R.id.message);
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
                    trocaFragment(new MapsActivity());

                    return true;
                case R.id.alertar:

                    getSupportActionBar().setTitle(Html.fromHtml("Alertar"));
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
        Uri uri = Uri.parse("tel:"+192);
        Intent intent = new Intent(Intent.ACTION_DIAL,uri);
        startActivity(intent);
    }

    public void LigarPolicia(View view) {
        Uri uri = Uri.parse("tel:"+190);
        Intent intent = new Intent(Intent.ACTION_DIAL,uri);
        startActivity(intent);
    }
}
