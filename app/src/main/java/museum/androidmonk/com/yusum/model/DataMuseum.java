package museum.androidmonk.com.yusum.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class DataMuseum {
    @SerializedName("data")
    @Expose
    public List<MuseumModel> profilMuseum = new ArrayList<MuseumModel>();
}
