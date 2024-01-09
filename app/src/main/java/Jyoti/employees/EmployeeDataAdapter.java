package Jyoti.employees;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import Jyoti.employees.databinding.EmployeedataLayBinding;

public class EmployeeDataAdapter extends RecyclerView.Adapter<EmployeeDataAdapter.ViewHolder> {

    Context context;
    List<EmployeeDataModel> employeeDataModelList=new ArrayList<>();

    public EmployeeDataAdapter(Context context, List<EmployeeDataModel> employeeDataModelList) {
        this.context = context;
        this.employeeDataModelList = employeeDataModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        EmployeedataLayBinding binding=EmployeedataLayBinding.inflate(layoutInflater,parent,false);
        ViewHolder viewHolder=new ViewHolder(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        EmployeeDataModel model=employeeDataModelList.get(position);
        holder.binding.employeeId.setText("id : "+model.getId());
        holder.binding.employeeName.setText("Name : "+model.getName());
        holder.binding.employeeSalary.setText("Salary : "+model.getSalary());
        holder.binding.employeeAge.setText("Age : "+model.getAge());

    }

    @Override
    public int getItemCount() {
        return employeeDataModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        EmployeedataLayBinding binding;
        public ViewHolder(@NonNull EmployeedataLayBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
