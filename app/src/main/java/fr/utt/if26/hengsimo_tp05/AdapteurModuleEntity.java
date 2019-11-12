package fr.utt.if26.hengsimo_tp05;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapteurModuleEntity extends RecyclerView.Adapter<AdapteurModuleEntity.ModuleViewHolder> {

    class ModuleViewHolder extends RecyclerView.ViewHolder {
        private final TextView sigle;
        private final TextView parcours;
        private final TextView categorie;
        private final TextView credit;

        private ModuleViewHolder(View itemView) {
            super(itemView);
            sigle = itemView.findViewById(R.id.module_sigle_tv);
            parcours = itemView.findViewById(R.id.module_parcours_tv);
            categorie = itemView.findViewById(R.id.module_categorie_tv);
            credit = itemView.findViewById(R.id.module_credit_tv);
        }
    }

    private List<ModuleEntity> listModules;
    private final LayoutInflater inflater;

    AdapteurModuleEntity(Context context) { inflater = LayoutInflater.from(context); }

    @NonNull
    @Override
    public ModuleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.module, parent, false);
        return new ModuleViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ModuleViewHolder holder, int position) {
        if (listModules != null) {
            ModuleEntity current = listModules.get(position);
            holder.sigle.setText(current.getSigle());
            holder.parcours.setText(current.getParcours());
            holder.categorie.setText(current.getCategorie());
            holder.credit.setText(Integer.toString(current.getCredit()));
        } else {
            holder.sigle.setText("No Sigle");
            holder.parcours.setText("No Parcours");
            holder.categorie.setText("No Categorie");
            holder.credit.setText("No Credit");
        }
    }

    List<ModuleEntity> getModules(){
        return listModules;
    }

    void setModules(List<ModuleEntity> modules){
        this.listModules = modules;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(listModules != null) {
            return listModules.size();
        } else {
            return 0;
        }
    }
}