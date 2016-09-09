package museum.androidmonk.com.yusum.view;

import museum.androidmonk.com.yusum.model.DataMuseum;
import museum.androidmonk.com.yusum.model.DataWilayah;

public interface MainActivityView {
    void getProvincesSuccess(DataWilayah dataWilayah);

    void getProvincesFail(String errorMessage);

    void getMuseumProfileSuccess(DataMuseum dataMuseum);

    void getMuseumProfileFail(String errorMessage);

}
