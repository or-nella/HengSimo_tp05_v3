package fr.utt.if26.hengsimo_tp05;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ModuleListeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_list);

        Cursus cursus = new Cursus();

        ArrayList list = new ArrayList();
        list = cursus.getModules();

        AdaptateurModule am = new AdaptateurModule(this, R.layout.module, list);

        ListView lv = findViewById(R.id.module_liste_lv);
        lv.setAdapter(am);
    }
}
