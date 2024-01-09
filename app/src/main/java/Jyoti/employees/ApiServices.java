package Jyoti.employees;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServices {


    @GET("employees")
    Call<JsonObject> employee();
}
