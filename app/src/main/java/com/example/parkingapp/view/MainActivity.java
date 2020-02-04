package com.example.parkingapp.view;

import androidx.appcompat.app.AppCompatActivity;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.parkingapp.R;
import com.example.parkingapp.databinding.ActivityMainBinding;
import com.example.parkingapp.viewmodel.ParkingViewModel;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity {

    @Inject
    ParkingViewModel parkingViewModel;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;

    private EditText editTextSearch ;
    ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setParkingViewModel(parkingViewModel);
        binding.setLifecycleOwner  (this);
        validateLoadUser();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public void validateLoadUser (){

        //userViewModel.getUserInDB(this);

    }


    public void callWebService (){
        progress.show();
        Toast.makeText(this, "WEB SERVICE", Toast.LENGTH_LONG).show();

       /* userViewModel.getUsers(this).observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                listUser.addAll(users);
                mAdapter.notifyDataSetChanged();
                progress.dismiss();

            }
        });*/
    }
    // public void reloadFromDatabase(List<User> userList) {
    //   Toast.makeText(this, "BASE DE DATOS", Toast.LENGTH_LONG).show();
//        ((UserAdapter)mAdapter).setmDataset(userList);
    //       mAdapter.notifyDataSetChanged();

    //}
    public void setCreateDialog (){
        progress = new ProgressDialog(this);
        progress.setTitle("Loading");
        progress.setMessage("Wait while loading...");
        progress.setCancelable(false);



    }
}
