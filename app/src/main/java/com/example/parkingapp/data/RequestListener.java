package com.example.parkingapp.data;

import com.example.parkingapp.TransactionResponse;

public interface RequestListener {
    void respond(TransactionResponse repondTransaction);
}
