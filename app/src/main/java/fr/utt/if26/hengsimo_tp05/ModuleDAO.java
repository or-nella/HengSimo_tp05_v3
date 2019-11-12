package fr.utt.if26.hengsimo_tp05;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ModuleDAO {
    // allowing the insert of the same word multiple times by passing a
    // conflict resolution strategy
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(ModuleEntity module);

    @Query("DELETE FROM module_table")
    void deleteAll();

    @Query("SELECT * from module_table ORDER BY sigle ASC")
    LiveData<List<ModuleEntity>> getAlphabetizedModules();
}
