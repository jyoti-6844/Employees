package Jyoti.employees;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import Jyoti.employees.databinding.ActivityMainBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());
        getEmployeeData();


    }
    private void getEmployeeData(){
        RetrofitClient.getClient().employee().enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                try {
                    if (response.isSuccessful())
                    {
                        Log.d("onResponse","successful"+response.body());
                        JsonObject jsonObject=response.body();
                        JsonArray data=jsonObject.getAsJsonArray("data");
                        List<EmployeeDataModel> employeeDataModelList=new ArrayList<>();
                        for (int i=0;i<data.size();i++)
                        {
                            JsonObject jsonObject1=data.get(i).getAsJsonObject();
                            String id=jsonObject1.get("id").getAsString();
                            String employee_name=jsonObject1.get("employee_name").getAsString();
                            String employee_salary=jsonObject1.get("employee_salary").getAsString();
                            String employee_age=jsonObject1.get("employee_age").getAsString();
                            employeeDataModelList.add(new EmployeeDataModel(id,employee_name,employee_salary,employee_age));
                        }
                        EmployeeDataAdapter adapter=new EmployeeDataAdapter(getApplicationContext(),employeeDataModelList);
                        mainBinding.employeedataRecycler.setAdapter(adapter);
                    }else {

                    }
                }catch (Exception e)
                {
                    Log.d("onResponse","Exception"+e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }
}