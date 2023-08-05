package com.alibaba.csp.sentinel.slots.adaptive.algorithm;

import java.util.List;

/**
 * @author ElonTusk
 * @name Vegas
 * @date 2023/8/2 14:47
 */
public class VegasLimit extends AbstractLimit {

    @Override
    public int update(List<Integer> oldLimits, double minRt, double rt, int passQps) {

        return 0;
    }
}
