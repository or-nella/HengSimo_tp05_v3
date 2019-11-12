package fr.utt.if26.hengsimo_tp05;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {ModuleEntity.class}, version = 1)
public abstract class CursusDatabase extends RoomDatabase {

    public abstract ModuleDAO moduleDAO();

    private static volatile CursusDatabase INSTANCE;

    static CursusDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (CursusDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            CursusDatabase.class, "cursus_database")
                            .addCallback(sRoomDatabaseCallback).build();
                }
            }
        }
        return INSTANCE;
    }

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final ModuleDAO mDao;

        PopulateDbAsync(CursusDatabase db) {
            mDao = db.moduleDAO();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            mDao.deleteAll();
            ModuleEntity module = new ModuleEntity("IF26","FIL","TM", 6);
            mDao.insert(module);
            module = new ModuleEntity("IF10","FIL","TM", 6);
            mDao.insert(module);
            return null;
        }
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };
}
