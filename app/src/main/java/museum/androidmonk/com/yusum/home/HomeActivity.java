package museum.androidmonk.com.yusum.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import museum.androidmonk.com.yusum.API.MuseumApiService;
import museum.androidmonk.com.yusum.R;
import museum.androidmonk.com.yusum.model.DataMuseum;
import museum.androidmonk.com.yusum.model.DataWilayah;
import museum.androidmonk.com.yusum.view.MainActivityView;
import rx.subscriptions.CompositeSubscription;

public class HomeActivity extends AppCompatActivity implements MainActivityView {
    private HomePresenter homePresenter;

    private MuseumApiService museumApiService;
    private CompositeSubscription compositeSubscription;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        museumApiService = new MuseumApiService();
        compositeSubscription = new CompositeSubscription();
        homePresenter = new HomePresenter(this, museumApiService, compositeSubscription);

        //TODO: GALLANT x AFIF should be placed on presenter
        getDataWilayah();
        getDataMuseum();
    }

    private void getDataWilayah() {
        homePresenter.getProvinces();
    }

    private void getDataMuseum() {
        String museumId = "4A33CF6F-A284-4E42-830B-E7DC755614CD";
        homePresenter.getMuseumProfile(museumId);
    }

    @Override
    protected void onDestroy() {
        compositeSubscription.unsubscribe();
        super.onDestroy();
    }

    @Override
    public void getProvincesSuccess(DataWilayah dataWilayah) {
        Toast.makeText(getBaseContext(), "GET data wilayah\n" + dataWilayah.wilayahModels.get(0).nama, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getProvincesFail(String errorMessage) {
        Toast.makeText(getBaseContext(), "error get data wilayah, " + errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getMuseumProfileSuccess(DataMuseum dataMuseum) {
        Toast.makeText(getBaseContext(), "GET museum profile\n" + dataMuseum.profilMuseum.get(0).nama, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getMuseumProfileFail(String errorMessage) {
        Toast.makeText(getBaseContext(), "error get museum profile, " + errorMessage, Toast.LENGTH_SHORT).show();
    }
}
