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

public class AdaptateurSigle extends ArrayAdapter<String> {

    List<String> l;
    Context c;
    int r;

    public AdaptateurSigle(Context context, int ressource, List<String> objects) {
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

        String elt = l.get(position);
        TextView tv = (TextView) v.findViewById(R.id.sigle_tv);
        tv.setText(elt);

        return v;
    }
}
