package com.bablo.goni.gonibablo.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bablo.goni.gonibablo.R;
import com.bablo.goni.gonibablo.model.Item;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Serhii_Bondarenko3 on 14-Nov-17.
 */

public class ItemRecyclerAdapter extends RecyclerView.Adapter {
    private List<Item> items;
    private IItemCallback callback;

    public ItemRecyclerAdapter(List<Item> items, IItemCallback callback) {
        this.items = items;
        this.callback = callback;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_item, parent, false);
        return new ItemVH(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (position < items.size()) {
            ((ItemVH) holder).name.setText(items.get(position).getName());
            ((ItemVH) holder).name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callback.selectItem(items.get(holder.getAdapterPosition()));
                }
            });
        } else {
            ((ItemVH) holder).name.setText(R.string.add);
            ((ItemVH) holder).name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callback.addItem();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return items.size() + 1;
    }

    class ItemVH extends RecyclerView.ViewHolder{
        @BindView(R.id.item_name) TextView name;
        ItemVH(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
