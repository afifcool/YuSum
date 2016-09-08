package museum.androidmonk.com.yusum;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import museum.androidmonk.com.yusum.API.MuseumApiService;
import museum.androidmonk.com.yusum.model.DataMuseum;
import museum.androidmonk.com.yusum.model.DataWilayah;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public class MainActivity extends AppCompatActivity {

    private MuseumApiService museumApiService;
    private CompositeSubscription compositeSubscription;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        museumApiService = new MuseumApiService();
        compositeSubscription = new CompositeSubscription();

        //TODO: GALLANT x AFIF should be placed on presenter
        getDataWilayah();
        getDataMuseum();
    }

    private void getDataWilayah() {
        Subscription subscription = museumApiService.getProvinces(new MuseumApiService.OnGetListAreaListener() {
            @Override
            public void onSuccess(DataWilayah dataWilayah) {
                Toast.makeText(getBaseContext(), "GET data wilayah\n" + dataWilayah.wilayahModels.get(0).nama, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(String errorMessage) {
                Toast.makeText(getBaseContext(), "error get data wilayah, " + errorMessage, Toast.LENGTH_SHORT).show();
            }
        });
        compositeSubscription.add(subscription);
    }

    private void getDataMuseum() {
        String museumId = "4A33CF6F-A284-4E42-830B-E7DC755614CD";
        Subscription subscription = museumApiService.getMuseumProfile(museumId, new MuseumApiService.OnGetListMuseumListener() {
            @Override
            public void onSuccess(DataMuseum dataMuseum) {
                Toast.makeText(getBaseContext(), "GET museum profile\n" + dataMuseum.profilMuseum.get(0).nama, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(String errorMessage) {
                Toast.makeText(getBaseContext(), "error get museum profile, " + errorMessage, Toast.LENGTH_SHORT).show();
            }
        });
        compositeSubscription.add(subscription);
    }

    @Override
    protected void onDestroy() {
        compositeSubscription.unsubscribe();
        super.onDestroy();
    }
}
