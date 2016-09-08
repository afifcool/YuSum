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

    public Subscription getMuseumProfile(String museumId, final OnGetListMuseumListener listener) {
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

    public Subscription getListMuseumByProvince(String provCode, final OnGetListMuseumListener listener) {
        return museumAPI.getMuseumByProvinsi(provCode)
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

    public Subscription getListMuseumByCity(String kabCode, final OnGetListMuseumListener listener) {
        return museumAPI.getMuseumByKabKota(kabCode)
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

    public Subscription getListMuseumByKec(String kecCode, final OnGetListMuseumListener listener) {
        return museumAPI.getMuseumByKec(kecCode)
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

    public Subscription getListMuseumByName(String name, final OnGetListMuseumListener listener) {
        return museumAPI.getMuseumByName(name)
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

    public Subscription getListMuseumByName(double lat, double lon, final OnGetListMuseumListener listener) {
        return museumAPI.getMuseumByCoordinate(lat, lon)
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

    public Subscription getProvinces(final OnGetListAreaListener listener) {
        return museumAPI.getProvinces()
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

    public Subscription getCitiesByProvice(String provCode, final OnGetListAreaListener listener) {
        return museumAPI.getCitiesByProvince(provCode)
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

    public Subscription getKecsByCity(String cityCode, final OnGetListAreaListener listener) {
        return museumAPI.getKecsByCity(cityCode)
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

    public interface OnGetListMuseumListener {
        void onSuccess(DataMuseum dataMuseum);

        void onError(String errorMessage);
    }

    public interface OnGetListAreaListener {
        void onSuccess(DataWilayah dataWilayah);

        void onError(String errorMessage);
    }
}
