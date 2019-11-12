package fr.utt.if26.hengsimo_tp05;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RoomModuleSupprimeActivity extends AppCompatActivity implements View.OnClickListener{

    private Button button_supprime;
    private ModuleViewModel mModuleViewModel;
    private RecyclerView rv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roommodule_supprime);

      /*  button_supprime = findViewById(R.id.button_supprime);
        mModuleViewModel = new ViewModelProvider(this).get(ModuleViewModel.class);
        rv = findViewById(R.id.recycler_v_roommodule_supprime);

        final AdapteurModuleEntity ame = new AdapteurModuleEntity(this);
        rv.setAdapter(ame);
        rv.setLayoutManager(new LinearLayoutManager(this));*/
    }

    @Override
    public void onClick(View view) {

    }
}
