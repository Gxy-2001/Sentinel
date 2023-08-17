package com.alibaba.csp.sentinel.slots.adaptive.algorithm;

import java.util.Queue;

/**
 * @author ElonTusk
 * @name BRPC
 * @date 2023/8/17 16:27
 */
public class BRPC extends AbstractLimit {
    double alpha = 0.3;

    @Override
    public int update(Queue<Integer> oldLimits, double minRt, double rt, double passQps) {
        double max_concurrency = passQps * ((2 + alpha) * minRt - rt);

        // TODO
        return (int) max_concurrency;
    }
}
