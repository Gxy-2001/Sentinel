package com.alibaba.csp.sentinel.slots.adaptive.algorithm;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ElonTusk
 * @name GradientLimit
 * @date 2023/8/17 15:28
 */
public class GradientLimit extends AbstractLimit {
    private static class GradientLimitContainer {
        private static GradientLimit instance = new GradientLimit();
    }

    public static AbstractLimit getInstance() {
        return GradientLimit.GradientLimitContainer.instance;
    }
    private int minLimit = 20;
    private int maxLimit = 200;
    private int window = 600;
    private int warmupWindow = 10;
    private double tolerance = 1.5;

    @Override
    public int update(Queue<Integer> oldLimits, double minRt, double rt, double passQps) {
        double estimatedLimit = 20;
        for (Integer oldLimit : oldLimits) {
            estimatedLimit = oldLimit;
        }
        final double queueSize = Math.sqrt(estimatedLimit);

        double shortRtt = rt;
        double longRtt = calLongRtt(estimatedLimit);


        if (longRtt / shortRtt > 2) {
            longRtt = longRtt * 0.95;
        }

        final double gradient = Math.max(0.5, Math.min(1.0, tolerance * longRtt / shortRtt));
        double newLimit = estimatedLimit * gradient + queueSize;
        newLimit = estimatedLimit * (1 - RuleConstant.ADAPTIVE_LIMIT_SMOOTHING) + newLimit * RuleConstant.ADAPTIVE_LIMIT_SMOOTHING;
        newLimit = Math.max(minLimit, Math.min(maxLimit, newLimit));

        estimatedLimit = newLimit;

        return (int) estimatedLimit;
    }

    private AtomicInteger count = new AtomicInteger(0);

    private double sum = 0.0;
    private double value = 0.0;

    private double calLongRtt(double estimatedLimit) {
        if (count.get() < warmupWindow) {
            count.incrementAndGet();
            sum += estimatedLimit;
            value = sum / count.get();
        } else {
            double factor = factor(window);
            value = value * (1 - factor) + estimatedLimit * factor;
        }
        return value;
    }

    private double factor(int n) {
        return 2.0 / (n + 1);
    }
}
