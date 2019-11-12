package fr.utt.if26.hengsimo_tp05;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RoomModuleListeActivity extends AppCompatActivity {
    private ModuleViewModel mModuleViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roommodule_liste);

        RecyclerView rv = findViewById(R.id.recycler_v_roommodule);
        final AdapteurModuleEntity ame = new AdapteurModuleEntity(this);
        rv.setAdapter(ame);

        rv.setLayoutManager(new LinearLayoutManager(this));

        mModuleViewModel = new ViewModelProvider(this).get(ModuleViewModel.class);
        mModuleViewModel.getAllModules().observe(this, new Observer<List<ModuleEntity>>() {
            @Override
            public void onChanged(@Nullable final List<ModuleEntity> moduleEntities) {
                ame.setModules(moduleEntities);
            }
        });
    }
}
