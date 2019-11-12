package fr.utt.if26.hengsimo_tp05;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;


public class RoomModuleAjouteActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mEditSigleView;
    private EditText mEditParcoursView;
    private EditText mEditCategorieView;
    private EditText mEditCreditView;
    private ModuleViewModel mModuleViewModel;
    private Button button_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roommodule_ajoute);
        mEditSigleView = findViewById(R.id.ajoute_sigle);
        mEditParcoursView = findViewById(R.id.ajoute_parcours);
        mEditCategorieView = findViewById(R.id.ajoute_categorie);
        mEditCreditView = findViewById(R.id.ajoute_credit);

        button_save = findViewById(R.id.button_save);
        this.button_save.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button_save){
            mModuleViewModel = new ViewModelProvider(this).get(ModuleViewModel.class);
            String sigle = mEditSigleView.getText().toString();
            String parcours = mEditParcoursView.getText().toString();
            String categorie = mEditCategorieView.getText().toString();
            Integer credit = Integer.parseInt(mEditCreditView.getText().toString());
            ModuleEntity module = new ModuleEntity(sigle, parcours, categorie, credit);
            mModuleViewModel.insert(module);
            Toast.makeText(this, "L'insertion a réussi", Toast.LENGTH_SHORT).show();
        }
    }
}
