package de.telekom.sea.mystuff.frontend.android;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import de.telekom.sea.mystuff.frontend.android.databinding.MyStuffItemBinding;
import de.telekom.sea.mystuff.frontend.android.model.Item;
import de.telekom.sea.mystuff.frontend.android.ui.ItemListRecyclerViewAdapter;
import de.telekom.sea.mystuff.frontend.android.util.MyStuffViewModel;

public class MainActivity extends AppCompatActivity {

    private RecyclerView listOfItems;
    private MyStuffViewModel myStuffViewModel;
    private ItemListRecyclerViewAdapter itemListRecyclerViewAdapter;
    private Runnable runnable = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        myStuffViewModel = new ViewModelProvider(this).get(MyStuffViewModel.class);
        myStuffViewModel.initWithApplication(getApplication());

        listOfItems = findViewById(R.id.ItemsLayout);
        listOfItems.setLayoutManager(new LinearLayoutManager(this));

//        itemListRecyclerViewAdapter = new ItemListRecyclerViewAdapter();


    }

    }
