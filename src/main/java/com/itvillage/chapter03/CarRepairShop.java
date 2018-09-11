package com.itvillage.chapter03;

import java.util.concurrent.CompletableFuture;

public class CarRepairShop {
    public int getCarRepairCostSync(int brokens) {
        return calculateCarRepair(brokens);
    }

    public CompletableFuture<Integer> getCarRepairCostAsync(int brokens) {
        return CompletableFuture.supplyAsync(() -> calculateCarRepair(brokens));
    }

    private int calculateCarRepair(int brokens){
        delay();
        return brokens * 20000;
    }

    private void delay(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
