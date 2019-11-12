package fr.utt.if26.hengsimo_tp05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = findViewById(R.id.textView);
        tv.setText("Modules du programme ISI");
        tv.setTextSize(30);
        tv.setGravity(Gravity.CENTER);
    }

    public boolean onCreateOptionsMenu (Menu menu) {
        this.menu = menu;

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        return true;
    }

    public boolean onOptionsItemSelected (MenuItem item) {
        switch (item.getItemId()) {
            case R.id.main_menu_sigle_liste :
                sigleListe();
                return true;

            case R.id.item_ajoute_sigle :
                sigleAjoute();
                return true;

            case R.id.item_supprime_sigle :
                sigleListe();
                return true;

            case R.id.item_liste_module :
                moduleListe();
                return true;

            case R.id.item_ajoute_module :
                sigleListe();
                return true;

            case R.id.item_supprime_module :
                sigleListe();
                return true;

            case R.id.item_liste_roommodule :
                roomModuleListe();
                return true;

            case R.id.item_ajoute_roommodule :
                roomModuleAjoute();
                return true;

            case R.id.item_supprime_roommodule :
                roomModuleSupprime();
                return true;
        }

        return true;
    }

    private void sigleListe() {
        Toast.makeText(this, "c bon sigle liste", Toast.LENGTH_SHORT).show();
        Intent i = new Intent().setClass(getApplicationContext(),SingleListActivity.class);
        startActivity(i);
    }

    private void sigleAjoute() {
        Toast.makeText(this, "c bon sigle ajouté", Toast.LENGTH_SHORT).show();
    }

    private void moduleListe() {
        Toast.makeText(this, "c bon sigle liste", Toast.LENGTH_SHORT).show();
        Intent i = new Intent().setClass(getApplicationContext(),ModuleListeActivity.class);
        startActivity(i);
    }
    private void roomModuleListe() {
        Toast.makeText(this, "c bon sigle liste", Toast.LENGTH_SHORT).show();
        Intent i = new Intent().setClass(getApplicationContext(),RoomModuleListeActivity.class);
        startActivity(i);
    }
    private void roomModuleAjoute() {
        Toast.makeText(this, "c bon sigle liste", Toast.LENGTH_SHORT).show();
        Intent i = new Intent().setClass(getApplicationContext(), RoomModuleAjouteActivity.class);
        startActivity(i);
    }
    private void roomModuleSupprime() {
        Toast.makeText(this, "c bon sigle liste", Toast.LENGTH_SHORT).show();
        Intent i = new Intent().setClass(getApplicationContext(), RoomModuleSupprimeActivity.class);
        startActivity(i);
    }
}
