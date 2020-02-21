package com.example.parkingapp.presentation.view;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.parkingapp.BaseApplication;
import com.example.parkingapp.R;
import com.example.parkingapp.databinding.ActivityMainBinding;
import com.example.parkingapp.di.DaggerApplicationComponent;
import com.example.parkingapp.domain.services.VehicleOperations;
import com.example.parkingapp.presentation.viewmodel.ParkingViewModel;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    private ParkingViewModel parkingViewModel;
    @Inject
    VehicleOperations vehicleOperations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        DaggerApplicationComponent.create();
        parkingViewModel = ViewModelProviders.of(this).get(ParkingViewModel.class);
        binding.setParkingViewModel(parkingViewModel);
        binding.setLifecycleOwner(this);
        ((BaseApplication) getApplication()).getAppComponent().inject(this);
        setObservers();


    }

    private void setObservers() {

        final Observer<String> msgObserver = new Observer<String>() {
            @Override
            public void onChanged(@Nullable final String msg) {
                Toast.makeText(getApplication(), msg, Toast.LENGTH_LONG).show();
            }
        };
        parkingViewModel.getMsg().observe(this, msgObserver);

    }

}
