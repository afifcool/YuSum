package museum.androidmonk.com.yusum.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WilayahModel {
    @SerializedName("kode_wilayah")
    @Expose
    public String kodeWilayah;
    @SerializedName("nama")
    @Expose
    public String nama;
    @SerializedName("mst_kode_wilayah")
    @Expose
    public String mstKodeWilayah;
}
