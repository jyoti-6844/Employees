package Jyoti.employees;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    public static ApiServices getClient(){

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://dummy.restapiexample.com/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ApiServices.class);


    }
}
