package com.yehlock.pokemonchart;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.RecyclerView;

import static android.media.CamcorderProfile.get;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> implements Filterable {

    /**上方的arrayList為RecyclerView所綁定的ArrayList*/
    ArrayList<String> arrayList;
    ArrayList<String>[][] arrayListAllData;
    ArrayList<String> arrayListNames;
    /**儲存最原先ArrayList的狀態(也就是充當回複RecyclerView最原先狀態的陣列)*/
    ArrayList<String> arrayListFilter;

    public RecyclerViewAdapter(ArrayList<String> arrayList) {
        this.arrayListNames = arrayList;
        arrayListFilter = new ArrayList();
        /**這裡把初始陣列複製進去了*/
        arrayListFilter.addAll(arrayList);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView item;
        private String[][] arrayListAllData;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            item = itemView.findViewById(android.R.id.text1);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            this.arrayListAllData = Pokedex.pokemonsAll();
            //Toast.makeText(itemView.getContext(),arrayListNames.get(getAdapterPosition()),Toast.LENGTH_LONG).show();
            //Log.v("msg","position = "+arrayListNames.get(getAdapterPosition()));
            Intent intent = new Intent(view.getContext(),informationActivity.class);
            intent.putExtra("pokemon",arrayListNames.get(getAdapterPosition()));
            view.getContext().startActivity(intent);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        holder.item.setText(arrayListNames.get(position));
    }

    @Override
    public int getItemCount() {
        return arrayListNames.size();
    }

    @Override
    public Filter getFilter() {
        return mFilter;
    }
    Filter mFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            ArrayList<String> filteredList = new ArrayList<>();
            if(charSequence==null || charSequence.length()==0){
                filteredList.addAll(arrayListFilter);
            }else{
                //搜尋演算法寫在這邊
                for(String pokemons:arrayListFilter){
                    if(pokemons.toLowerCase().contains(charSequence.toString().toLowerCase())){
                        filteredList.add(pokemons);
                    }
                }
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            arrayListNames.clear();
            arrayListNames.addAll((Collection<? extends String>) filterResults.values);
            notifyDataSetChanged();;
        }
    };

}
