package com.example.parkingapp.conversions;

import com.example.parkingapp.data.ParkingRepository;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ConversionTypeTest {

    @Mock
    private ParkingRepository parkingRepository;

    private ConversionType conversionType;

    @Before
    public void setUp() throws  Exception {
        conversionType = new ConversionType();
        conversionType.getParkingFromDomainToRepository(parkingRepository);

    }



}