package museum.androidmonk.com.yusum.API;


import museum.androidmonk.com.yusum.model.DataMuseum;
import museum.androidmonk.com.yusum.model.DataWilayah;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface MuseumAPI {
    String ENDPOINT = "http://jendela.data.kemdikbud.go.id/api/index.php/";

    //    data museum
    @GET(MuseumClientAPI.URI_GET_PROFIL_MUSEUM)
    Observable<DataMuseum> getMuseumProfile(@Query("museum_id") String museumId);

    @GET(MuseumClientAPI.URI_GET_SEARCH_MUSEUM)
    Observable<DataMuseum> getMuseumByProvinsi(@Query("kode_prop") String provCode);

    @GET(MuseumClientAPI.URI_GET_SEARCH_MUSEUM)
    Observable<DataMuseum> getMuseumByKabKota(@Query("kode_kota") String kabCode);

    @GET(MuseumClientAPI.URI_GET_SEARCH_MUSEUM)
    Observable<DataMuseum> getMuseumByKec(@Query("kode_kec") String kecCode);

    @GET(MuseumClientAPI.URI_GET_SEARCH_MUSEUM)
    Observable<DataMuseum> getMuseumByName(@Query("nama") String museumName);

    @GET(MuseumClientAPI.URI_GET_SEARCH_MUSEUM)
    Observable<DataMuseum> getMuseumByCoordinate(@Query("lintang") double latitude, @Query("bujur") double longitude);

    //    data wilayah
    @GET(MuseumClientAPI.URI_GET_WILAYAH)
    Observable<DataWilayah> getProvinces();

    @GET(MuseumClientAPI.URI_GET_WILAYAH)
    Observable<DataWilayah> getCitiesByProvince(@Query("mst_kode_wilayah") String provCode);

    @GET(MuseumClientAPI.URI_GET_WILAYAH)
    Observable<DataWilayah> getKecsByCity(@Query("mst_kode_wilayah") String cityCode);
}
