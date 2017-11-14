package com.bablo.goni.gonibablo.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bablo.goni.gonibablo.R;
import com.bablo.goni.gonibablo.model.Person;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Serhii_Bondarenko3 on 13-Nov-17.
 */

public class PersonRecyclerAdapter extends RecyclerView.Adapter {
    private List<Person> people;

    public PersonRecyclerAdapter(List<Person> people) {
        this.people = people;
    }

    @Override
    public PersonVh onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_person, parent, false);
        return new PersonVh(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((PersonVh)holder).name.setText(people.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return people.size();
    }


    class PersonVh extends RecyclerView.ViewHolder {
        @BindView(R.id.person_name) TextView name;

        PersonVh(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
