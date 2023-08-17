package com.alibaba.csp.sentinel.slots.adaptive;

import com.alibaba.csp.sentinel.node.ClusterNode;
import com.alibaba.csp.sentinel.slots.clusterbuilder.ClusterBuilderSlot;
import com.alibaba.csp.sentinel.slots.statistic.StatisticSlot;

import java.util.Queue;

/**
 * @author ElonTusk
 * @name AdaptiveLimiter
 * @date 2023/8/7 14:14
 */
public class AdaptiveLimiter {
    public static void adaptiveLimit(AdaptiveRule rule) {
        ClusterNode node = ClusterBuilderSlot.getClusterNode(rule.getResource());
        if (node == null) return;

        double minRt = node.minRt();
        double rt = node.avgRt();
        double passQps = node.passQps();
        Queue<Integer> oldCounts = rule.getOldCounts();
        int newLimit = rule.getLimiter().update(oldCounts, minRt, rt, passQps);
        rule.setCount(newLimit);
        System.out.printf("oldCounts %s minRt %s rt %s passQps %s \n", oldCounts, minRt, rt, passQps);
        System.out.println("设置新阈值" + newLimit);
        rule.addCount(newLimit);
        rule.setTimes(0);
    }
}
