package museum.androidmonk.com.yusum.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class DataWilayah {
    @SerializedName("data")
    @Expose
    public List<WilayahModel> wilayahModels = new ArrayList<WilayahModel>();
}
