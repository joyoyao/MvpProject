package cc.mocation.app.data.remote;

import cc.mocation.app.common.util.MyGsonTypeAdapterFactory;
import cc.mocation.app.data.model.Ribot;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import rx.Observable;

public interface RestService {

    String ENDPOINT = "https://api.ribot.io/";

    @GET("ribots") Observable<List<Ribot>> getRibots();

    /******** Helper class that sets up a new services *******/
    class Creator {

        public static RestService newRibotsService() {
            //// log用拦截器
            //HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            //
            //// 开发模式记录整个body，否则只记录基本信息如返回200，http协议版本等
            //if (IS_DEV) {
            //    logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            //} else {
            //    logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
            //}
            Gson gson = new GsonBuilder()
                    .registerTypeAdapterFactory(MyGsonTypeAdapterFactory.create())
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                    .create();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(RestService.ENDPOINT)
                      .client(new OkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            return retrofit.create(RestService.class);
        }

    }


}
