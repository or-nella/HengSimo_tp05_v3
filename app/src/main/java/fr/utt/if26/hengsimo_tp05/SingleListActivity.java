package fr.utt.if26.hengsimo_tp05;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

public class SingleListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sigle_liste);

        List<String> liste = Arrays.asList("NF16","LO02","LO07","NF19","IF26","IF10","EG23","LO12","IF02","MCS1");

        AdaptateurSigle as = new AdaptateurSigle(this,R.layout.sigle,liste);
        ListView lv = findViewById(R.id.sigle_liste_lv);
        lv.setAdapter(as);
    }
}
