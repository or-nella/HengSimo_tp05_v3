package fr.utt.if26.hengsimo_tp05;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "module_table")
public class ModuleEntity {

    @PrimaryKey
    @NonNull
    private String sigle;
    @ColumnInfo(name = "categorie")
    private String categorie;
    @ColumnInfo(name = "credit")
    private int credit;
    @ColumnInfo(name = "parcours")
    private String parcours;

    public ModuleEntity(String sigle, String parcours, String categorie, int credit) {
        this.sigle = sigle;
        this.parcours = parcours;
        this.categorie = categorie;
        this.credit = credit;
    }

    @NonNull
    public String getCategorie() {
        return categorie;
    }

    public int getCredit() {
        return credit;
    }

    public String getParcours() {
        return parcours;
    }

    public String getSigle(){
        return sigle;
    }

    public void setSigle(@NonNull String sigle) {
        this.sigle = sigle;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public void setParcours(String parcours) {
        this.parcours = parcours;
    }
}
