package com.itvillage.chapter05.chapter0501;

import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;

import java.util.concurrent.Future;

public class FutureExampleASync {
    public static void main(String[] args){
        long startTime = System.currentTimeMillis();
        Logger.log(LogType.PRINT, "# Start");
        CarRepairShop shop = new CarRepairShop();

        // 차량 수리비(시간이 더 오래 걸리는 미래에 끝날 일)
        Future<Integer> future = shop.getCarRepairCostAsync(10);

        // 회사에 병가 신청(짧은 처리 시간)
        requestSickLeave("20170903-01");

        // 보험 청구(짧은 처리 시간)
        requestInsurance("44나4444");

        try {
            int carRepairCost = future.get();
            Logger.log(LogType.PRINT, "# (1) 차량 수리비 계산이 완료되었습니다.");
            Logger.log(LogType.PRINT, "# 차량 수리비는 " + carRepairCost + "원 입니다.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();

        double executeTime = (endTime - startTime) / 1000.0;

        System.out.println();
        System.out.println("# 처리 시간: " + executeTime);
    }

    private static void requestSickLeave(String empNumber) {
        try {
            Thread.sleep(1000);
            Logger.log(LogType.PRINT, "# (2) 병가 신청이 완료되었습니다.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void requestInsurance(String carNumber) {
        try {
            Thread.sleep(1000);
            Logger.log(LogType.PRINT, "# (3) 보험 접수가 완료 되었습니다.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
