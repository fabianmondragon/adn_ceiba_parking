package com.example.parkingapp.presentation.view;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.parkingapp.R;
import com.example.parkingapp.databinding.ActivityMainBinding;
import com.example.parkingapp.presentation.ParkingViewModel;

public class MainActivity extends AppCompatActivity {

    private ParkingViewModel parkingViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        parkingViewModel = ViewModelProviders.of(this).get(ParkingViewModel.class);
        binding.setParkingViewModel(parkingViewModel);
        binding.setLifecycleOwner  (this);
        setObservers ();
        filldatabase();
    }

    private void setObservers (){
        final Observer<String> msgObserver = new Observer<String>() {
            @Override
            public void onChanged(@Nullable final String msg) {
                Toast.makeText(getApplication(), msg, Toast.LENGTH_LONG).show();
            }
        };
        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        parkingViewModel.getMsg().observe(this, msgObserver);


        /*
        parkingViewModel.getParkingAll().observe(this, new Observer<List<Parking>>() {
            @Override
            public void onChanged(List<Parking> parkings) {
                if (parkings.size()>0){
                    Toast.makeText(MainActivity.this, Constant.MESSAGUE_DATA_BASE_CREATED, Toast.LENGTH_LONG).show();
                }
            }
        });
        parkingViewModel.getMotorcicleAll().observe(this, new Observer<List<Motorcycle>>() {
            @Override
            public void onChanged(List<Motorcycle> motorcycles) {
                Toast.makeText(MainActivity.this, Constant.REGISTER_SUCCESSFULL, Toast.LENGTH_LONG).show();
            }
        });*/
    }
    private void filldatabase(){
        parkingViewModel.fillDataBase();
    }
}
