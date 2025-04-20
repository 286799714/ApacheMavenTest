package com.maydaymemory.apachecommontest;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class Main {
    public static void main(String[] args) {
        DescriptiveStatistics stats = new DescriptiveStatistics();

        // 添加一些数据
        double[] values = {1, 2, 2, 3, 4, 5, 6, 10};
        for (double v : values) {
            stats.addValue(v);
        }

        // 打印基本统计量
        System.out.println("平均值: " + stats.getMean() + " 预期: 4.125");
        System.out.println("标准差: " + stats.getStandardDeviation() + " 预期: 2.9001231500945415");
        System.out.println("中位数: " + stats.getPercentile(50) + " 预期: 3.5");


        DescriptiveStatistics statsWithWindow = new DescriptiveStatistics(1);
        for (double v : values) {
            statsWithWindow.addValue(v);
        }
        System.out.println("平均值: " + statsWithWindow.getMean() + " 预期: 10.0");
        System.out.println("标准差: " + statsWithWindow.getStandardDeviation() + " 预期: 10.0");
        System.out.println("中位数: " + statsWithWindow.getPercentile(50) + " 预期: 10.0");
    }
}
