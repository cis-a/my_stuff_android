package de.telekom.sea.mystuff.frontend.android.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import androidx.databinding.DataBindingUtil;

import de.telekom.sea.mystuff.frontend.android.R;
import de.telekom.sea.mystuff.frontend.android.databinding.MyStuffItemBinding;
import de.telekom.sea.mystuff.frontend.android.model.Item;
import lombok.Getter;

public class ItemListRecyclerViewAdapter extends
        RecyclerView.Adapter<ItemListRecyclerViewAdapter.ViewHolder> {

    @Getter
    private final List<Item> itemList;

    public ItemListRecyclerViewAdapter(List<Item> items) {
        this.itemList = items;
    }

    public void updateItems(List<Item> newItems) {
        itemList.clear();
        itemList.addAll(newItems);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MyStuffItemBinding itemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.my_stuff_item, parent, false);
        return new ViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Item item = getItemList().get(position);
        viewHolder.getBinding().setItem(item);
    }

    @Override
    public int getItemCount() {
        if (itemList != null) {
            return itemList.size();
        } else {
            return 0;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @Getter
        private MyStuffItemBinding binding;

        public ViewHolder(@NonNull MyStuffItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
