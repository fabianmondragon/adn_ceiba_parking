package com.example.parkingapp.data.repository;

import com.example.parkingapp.TransactionResponse;

public interface RequestListener {
    void respond(TransactionResponse repondTransaction);
}
