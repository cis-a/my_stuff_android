package de.telekom.sea.mystuff.frontend.android.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import de.telekom.sea.mystuff.frontend.android.BuildConfig;
import lombok.Getter;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;


/**
 * Creates API instances for performing REST calls.
 */
public class ApiFactory {


    @Getter
    private final String baseRestUrl;
    @Getter
    private final String hostName;
    private final Retrofit retrofit;
    private final OkHttpClient okHttpClient;

    public ApiFactory() {

        //TODO check why symbols from class BuildConfig cannot be found in Build Process
//        this.baseRestUrl = BuildConfig.APIFACTORY_PROTOCOL + "://" + BuildConfig.APIFACTORY_HOSTNAME + ":" + BuildConfig.APIFACTORY_PORT;
//        this.hostName = BuildConfig.APIFACTORY_HOSTNAME;
        this.baseRestUrl = "http" + "://" +"10.0.2.2" + ":" +"8080";
        this.hostName = "10.0.2.2";

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        this.okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();

        Gson gson = new GsonBuilder()
                .setLenient()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(this.baseRestUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(new LiveDataCallAdapterFactory())
                .client(okHttpClient)
                .build();
    }

    public <S> S createApi(Class<S> retrofitApiInterface) {
        return retrofit.create(retrofitApiInterface);
    }

    public String getBackendBaseUrl() {
        return this.baseRestUrl;
    }


}
