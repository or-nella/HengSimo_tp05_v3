package fr.utt.if26.hengsimo_tp05;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ModuleViewModel extends AndroidViewModel {

    private CursusRepository mRepository;

    private LiveData<List<ModuleEntity>> mAllModules;

    public ModuleViewModel (Application application) {
        super(application);
        mRepository = new CursusRepository(application);
        mAllModules = mRepository.getAllModules();
    }

    LiveData<List<ModuleEntity>> getAllModules() { return mAllModules; }

    public void insert(ModuleEntity module) { mRepository.insert(module); }
}
