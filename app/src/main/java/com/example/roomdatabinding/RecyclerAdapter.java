package com.example.roomdatabinding;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdatabinding.databinding.StudentRowBinding;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {



    Context context;
    List<DataModel> dataModelList;


    public RecyclerAdapter(Context context, List<DataModel> dataModelList) {
        this.context = context;
        this.dataModelList = dataModelList;

    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        StudentRowBinding studentRowBinding =  StudentRowBinding.inflate(layoutInflater,parent,false);

        MyViewHolder myViewHolder = new MyViewHolder(studentRowBinding);


        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.MyViewHolder holder, int position) {

//        holder.name.setText(dataModelList.get(position).getName());
//        holder.address.setText(dataModelList.get(position).getAddress());
//        holder.cllas.setText(String.valueOf(dataModelList.get(position).getClass_name()));
//        holder.age.setText(String.valueOf(dataModelList.get(position).getAge()));

        holder.studentRowBinding.setModel(dataModelList.get(position));


    }

    @Override
    public int getItemCount() {

        return dataModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        StudentRowBinding studentRowBinding;


        public MyViewHolder(StudentRowBinding studentRowBinding) {

            super(studentRowBinding.getRoot());

            this.studentRowBinding = studentRowBinding;



        }
    }


}
