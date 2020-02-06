package com.example.parkingapp.view;

import androidx.appcompat.app.AppCompatActivity;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.parkingapp.R;
import com.example.parkingapp.data.database.CarCopia;
import com.example.parkingapp.data.database.Parking;
import com.example.parkingapp.databinding.ActivityMainBinding;
import com.example.parkingapp.viewmodel.ParkingViewModel;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    private ParkingViewModel parkingViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        parkingViewModel = ViewModelProviders.of(this).get(ParkingViewModel.class);
        binding.setParkingViewModel(parkingViewModel);
        binding.setLifecycleOwner  (this);
        parkingViewModel.getCarCopiaList().observe(this, new Observer<List<CarCopia>>() {
            @Override
            public void onChanged(List<CarCopia> carCopias) {
                String hola = "";
            }
        });
        parkingViewModel.getParking().observe(this, new Observer<List<Parking>>() {
            @Override
            public void onChanged(List<Parking> parkings) {
                if (parkings.size()>0){
                    Toast.makeText(MainActivity.this, "Base de dato creada", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
    }
}
