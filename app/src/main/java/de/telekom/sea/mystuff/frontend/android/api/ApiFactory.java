package de.telekom.sea.mystuff.frontend.android.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.security.cert.Certificate;
import java.util.Collection;

import de.telekom.sea.mystuff.frontend.android.BuildConfig;
import lombok.Getter;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Creates API instances for performing REST calls.
 */
public class ApiFactory {

    private final Retrofit retrofit;
    @Getter
    private final String baseRestUrl;
    private final String hostName;
    private final Integer port;

    public ApiFactory(
            String hostName,
            String protocol,
            Integer port) {

        this.baseRestUrl = BuildConfig.APIFACTORY_PROTOCOL + "://" + BuildConfig.APIFACTORY_HOSTNAME + ":" + BuildConfig.APIFACTORY_PORT;
        this.hostName = BuildConfig.APIFACTORY_HOSTNAME;
        this.port = BuildConfig.APIFACTORY_PORT;

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient;
        // create OkHttp client
        okHttpClient = new OkHttpClient.Builder()
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
