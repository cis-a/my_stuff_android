package de.telekom.sea.mystuff.frontend.android;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import de.telekom.sea.mystuff.frontend.android.api.ApiResponse;
import de.telekom.sea.mystuff.frontend.android.model.Item;
import de.telekom.sea.mystuff.frontend.android.ui.ItemListRecyclerViewAdapter;
import de.telekom.sea.mystuff.frontend.android.ui.ItemListViewModel;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    private RecyclerView listOfItems;
    private ItemListViewModel myStuffViewModel;
    private ItemListRecyclerViewAdapter itemListRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  Erzeuge den RecyclerViewAdapter und setze ihn auf dem RecyclerView
        itemListRecyclerViewAdapter = new ItemListRecyclerViewAdapter(new ArrayList<>());
        listOfItems = findViewById(R.id.rv_items);
        listOfItems.setAdapter(itemListRecyclerViewAdapter);
        listOfItems.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        //  Erzeuge das ViewModel, übergebe ihm den MyStuffContext
        myStuffViewModel = new ViewModelProvider(this).get(ItemListViewModel.class);
        myStuffViewModel.initWithApplication(getApplication());
        ((MyStuffApplication) getApplication()).getMyStuffContext().sendInfoMessage("ViewModel initialized!");

        //  Führe die LoadMethode auf dem ViewModel aus und setzte die Liste im ItemListRecyclerViewAdapter
        LiveData<ApiResponse<List<Item>>> itemList = myStuffViewModel.getItemList();
        itemList.observe(this, new Observer<ApiResponse<List<Item>>>() {
            @Override
            public void onChanged(ApiResponse<List<Item>> listApiResponse) {
                Timber.d("listApiResponse: "+ itemList.getValue().body.toString());
                itemListRecyclerViewAdapter.updateItems(itemList.getValue().body);
                ((MyStuffApplication) getApplication()).getMyStuffContext().sendInfoMessage("List loaded: " + itemList.getValue().body.toString());
            }
        });
    }

}
