package de.telekom.sea.mystuff.frontend.android.api;

import androidx.lifecycle.LiveData;

import java.util.List;

import de.telekom.sea.mystuff.frontend.android.model.Item;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ItemApi {

    @GET ("/api/v1/items")
    public LiveData<ApiResponse<List<Item>>> getAllItems();

    @GET ("/api/v1/items/{id}")
    public LiveData<ApiResponse<Item>> getById(@Path("id") Long id);

    @POST ("/api/v1/items")
    public LiveData<ApiResponse<Item>> newItem(Item item);

    @PUT ("/api/v1/items/{id}")
    public LiveData<ApiResponse<Item>> changeItem(Item item, @Path("id") Long id);

    @DELETE("/api/v1/items/{id}")
    public LiveData<ApiResponse<Item>> deleteItem(@Path("id") Long id);
}
