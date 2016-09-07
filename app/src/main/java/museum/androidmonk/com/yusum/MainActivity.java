package museum.androidmonk.com.yusum;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import museum.androidmonk.com.yusum.API.MuseumAPI;
import museum.androidmonk.com.yusum.model.DataMuseum;
import museum.androidmonk.com.yusum.model.DataWilayah;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    Gson gson;
    Retrofit retrofit;
    MuseumAPI museumAPI;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRetrofit();
        getDataWilayah();
        getDataMuseum();
    }

    private void initRetrofit() {
        gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(MuseumAPI.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        museumAPI = retrofit.create(MuseumAPI.class);
    }

    private void getDataWilayah() {
        Call<DataWilayah> call = museumAPI.getDataProp();

        call.enqueue(new Callback<DataWilayah>() {
            @Override
            public void onResponse(Call<DataWilayah> call, Response<DataWilayah> response) {
                DataWilayah dataWilayah = response.body();
                Toast.makeText(getBaseContext(), dataWilayah.wilayahModels.get(0).nama, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<DataWilayah> call, Throwable t) {
                Toast.makeText(getBaseContext(), "error get data wilayah", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getDataMuseum(){
        Call<DataMuseum> call = museumAPI.getProfilMuseum("4A33CF6F-A284-4E42-830B-E7DC755614CD");

        call.enqueue(new Callback<DataMuseum>() {
            @Override
            public void onResponse(Call<DataMuseum> call, Response<DataMuseum> response) {
                DataMuseum dataMuseum = response.body();
                Toast.makeText(getBaseContext(), dataMuseum.profilMuseum.get(0).nama, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<DataMuseum> call, Throwable t) {
                Toast.makeText(getBaseContext(), "error get data museum", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
