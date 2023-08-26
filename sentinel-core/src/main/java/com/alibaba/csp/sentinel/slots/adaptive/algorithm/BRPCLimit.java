package com.alibaba.csp.sentinel.slots.adaptive.algorithm;

import java.util.Queue;

/**
 * @author ElonTusk
 * @name BRPC
 * @date 2023/8/17 16:27
 */
public class BRPCLimit extends AbstractLimit {

    private static class BRPCLimitContainer {
        private static BRPCLimit instance = new BRPCLimit();
    }

    public static AbstractLimit getInstance() {
        return BRPCLimit.BRPCLimitContainer.instance;
    }

    double alpha = 0.3;
    double maxQps = 0;

    @Override
    public int update(Queue<Integer> oldLimits, double minRt, double rt, double passQps) {

        double emaFactor = alpha / 10;
        if (passQps >= maxQps) {
            maxQps = passQps;
        } else {
            maxQps = passQps * emaFactor + maxQps * (1 - emaFactor);
        }

        double maxConcurrency = maxQps * ((2 + alpha) * minRt - rt);
        // TODO
        return (int) maxConcurrency;
    }
}
