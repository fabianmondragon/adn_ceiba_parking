package com.example.parkingapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.widget.Toast;
import com.example.parkingapp.R;
import com.example.parkingapp.data.database.Motorcycle;
import com.example.parkingapp.data.database.Parking;
import com.example.parkingapp.databinding.ActivityMainBinding;
import com.example.parkingapp.util.Constant;
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
        setObservers ();
    }

    private void setObservers (){
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
        });
    }
}
