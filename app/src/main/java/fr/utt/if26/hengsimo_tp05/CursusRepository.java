package fr.utt.if26.hengsimo_tp05;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class CursusRepository {

    private ModuleDAO moduleDAO;
    private LiveData<List<ModuleEntity>> mAllModules;

    CursusRepository(Application application) {
        CursusDatabase db = CursusDatabase.getDatabase(application);
        moduleDAO = db.moduleDAO();
        mAllModules = moduleDAO.getAlphabetizedModules();
    }

    LiveData<List<ModuleEntity>> getAllModules() {
        return mAllModules;
    }


    public void insert (ModuleEntity module) {
        new insertAsyncTask(moduleDAO).execute(module);
    }

    private static class insertAsyncTask extends AsyncTask<ModuleEntity, Void, Void> {

        private ModuleDAO mAsyncTaskDao;

        insertAsyncTask(ModuleDAO dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final ModuleEntity... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
