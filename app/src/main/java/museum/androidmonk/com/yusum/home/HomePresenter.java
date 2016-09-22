package museum.androidmonk.com.yusum.home;

import museum.androidmonk.com.yusum.API.MuseumApiService;
import museum.androidmonk.com.yusum.model.DataMuseum;
import museum.androidmonk.com.yusum.model.DataWilayah;
import museum.androidmonk.com.yusum.view.MainActivityView;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public class HomePresenter {
    private MainActivityView view;
    private MuseumApiService museumApiService;
    private CompositeSubscription compositeSubscription;

    public HomePresenter(MainActivityView view, MuseumApiService museumApiService, CompositeSubscription compositeSubscription) {
        this.view = view;
        this.museumApiService = museumApiService;
        this.compositeSubscription = compositeSubscription;
    }

    public void getProvinces(){
        Subscription subscription = museumApiService.getProvinces(new MuseumApiService.OnGetListAreaListener() {
            @Override
            public void onSuccess(DataWilayah dataWilayah) {
                view.getProvincesSuccess(dataWilayah);
            }

            @Override
            public void onError(String errorMessage) {
                view.getProvincesFail(errorMessage);
            }
        });
        compositeSubscription.add(subscription);
    }

    public void getMuseumProfile(String museumId){
        Subscription subscription = museumApiService.getMuseumProfile(museumId, new MuseumApiService.OnGetListMuseumListener() {
            @Override
            public void onSuccess(DataMuseum dataMuseum) {
                view.getMuseumProfileSuccess(dataMuseum);
            }

            @Override
            public void onError(String errorMessage) {
                view.getMuseumProfileFail(errorMessage);
            }
        });
        compositeSubscription.add(subscription);
    }
}
