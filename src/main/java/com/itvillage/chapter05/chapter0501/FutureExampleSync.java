package com.itvillage.chapter05.chapter0501;

import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;

public class FutureExampleSync {
    public static void main(String[] args){
        long startTime = System.currentTimeMillis();

        CarRepairShop shop = new CarRepairShop();

        // 차량 수리비
        int carRepairCost = shop.getCarRepairCostSync(10);
        Logger.log(LogType.PRINT, "# (1) 차량 수리비 계산이 완료되었습니다.");
        Logger.log(LogType.PRINT, "# 차량 수리비는 " + carRepairCost + "원 입니다.");

        // 회사에 병가 신청
        requestSickLeave("20170903-01");

        // 보험 접수
        requestInsurance("44나4444");

        long endTime = System.currentTimeMillis();

        double executeTime = (endTime - startTime) / 1000.0;

        System.out.println();
        System.out.println("# 처리 시간: " + executeTime + "초");
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
