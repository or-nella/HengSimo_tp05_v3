package fr.utt.if26.hengsimo_tp05;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AdaptateurModule extends ArrayAdapter<Module> {

    List<Module> l;
    Context c;
    int r;
    TextView sigle;
    TextView categorie;
    TextView parcours;
    TextView credit;

    public AdaptateurModule(Context context, int ressource, List<Module> objects) {
        super(context, ressource, objects);
        l = objects;
        c = context;
        r = ressource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater li = ((Activity) c).getLayoutInflater();
        View v = li.inflate(r, parent, false);

        Module m = (Module) l.get(position);

        sigle = (TextView) v.findViewById(R.id.module_sigle_tv);
        categorie = (TextView) v.findViewById(R.id.module_categorie_tv);
        parcours = (TextView) v.findViewById(R.id.module_parcours_tv);
        credit = (TextView) v.findViewById(R.id.module_credit_tv);

        sigle.setText(m.getSigle());
        categorie.setText(m.getCategorie());
        parcours.setText(m.getParcours());
        credit.setText(String.valueOf(m.getCredit()));

        return v;
    }

    void setModules(List<Module> modules) {
        this.l = modules;
        notifyDataSetChanged();
    }
}
