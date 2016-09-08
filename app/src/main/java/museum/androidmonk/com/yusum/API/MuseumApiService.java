package museum.androidmonk.com.yusum.API;

import museum.androidmonk.com.yusum.model.DataMuseum;
import museum.androidmonk.com.yusum.model.DataWilayah;
import museum.androidmonk.com.yusum.network.NetworkModule;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MuseumApiService {

    private final MuseumAPI museumAPI;

    public MuseumApiService() {
        museumAPI = NetworkModule.instance().getRetrofit().create(MuseumAPI.class);
    }

    public Subscription getMuseumProfile(String museumId, final OnGetMuseumProfileListener listener) {
        return museumAPI.getMuseumProfile(museumId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends DataMuseum>>() {
                    @Override
                    public Observable<? extends DataMuseum> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<DataMuseum>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.onError(e.getMessage());
                    }

                    @Override
                    public void onNext(DataMuseum dataMuseum) {
                        listener.onSuccess(dataMuseum);
                    }
                });
    }

    public Subscription getAreaData(final OnGetAreaDataListener listener) {
        return museumAPI.getDataProp()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends DataWilayah>>() {
                    @Override
                    public Observable<? extends DataWilayah> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<DataWilayah>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.onError(e.getMessage());
                    }

                    @Override
                    public void onNext(DataWilayah dataWilayah) {
                        listener.onSuccess(dataWilayah);
                    }
                });
    }

    public interface OnGetMuseumProfileListener {
        void onSuccess(DataMuseum dataMuseum);

        void onError(String errorMessage);
    }

    public interface OnGetAreaDataListener {
        void onSuccess(DataWilayah dataWilayah);

        void onError(String errorMessage);
    }
}
