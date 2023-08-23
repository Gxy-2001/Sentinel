package com.alibaba.csp.sentinel.slots.adaptive.algorithm;

import java.util.Queue;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;

/**
 * @author ElonTusk
 * @name Vegas
 * @date 2023/8/2 14:47
 */
public class VegasLimit extends AbstractLimit {

    @Override
    public int update(Queue<Integer> oldLimits, double minRt, double rt, double passQps) {
        double estimatedLimit = 20;
        for (Integer oldLimit : oldLimits) {
            estimatedLimit = oldLimit;
        }
        final int queueSize = (int) Math.ceil(estimatedLimit * (1 - minRt / rt));

        double newLimit;
        // Treat any drop (i.e timeout) as needing to reduce the limit

        double alpha = 3 * Math.log10(estimatedLimit);
        double beta = 6 * Math.log10(estimatedLimit);
        double threshold = Math.log10(estimatedLimit);

        // Aggressive increase when no queuing
        if (queueSize <= threshold) {
            newLimit = estimatedLimit + beta;
            // Increase the limit if queue is still manageable
        } else if (queueSize < alpha) {
            newLimit = estimatedLimit + Math.log10(estimatedLimit);
            // Detecting latency so decrease
        } else if (queueSize > beta) {
            newLimit = estimatedLimit - Math.log10(estimatedLimit);
            // We're within he sweet spot so nothing to do
        } else {
            return (int) estimatedLimit;
        }
        //newLimit = Math.max(1, Math.min(maxLimit, newLimit));
        newLimit = (1 - RuleConstant.ADAPTIVE_LIMIT_SMOOTHING) * estimatedLimit + RuleConstant.ADAPTIVE_LIMIT_SMOOTHING * newLimit;
        return (int) newLimit;
    }
}
