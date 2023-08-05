package com.alibaba.csp.sentinel.slots.adaptive;


import com.alibaba.csp.sentinel.slots.adaptive.algorithm.AbstractLimit;

/**
 * @author ElonTusk
 * @name AdaptiveRule
 * @date 2023/8/2 13:35
 */
public class AdaptiveRule {
    private int strategy;
    private String refResource;

    public int getStrategy() {
        return strategy;
    }

    public AdaptiveRule setStrategy(int strategy) {
        this.strategy = strategy;
        return this;
    }

    public String getResource() {
        return refResource;
    }

    public AdaptiveRule setResource(String refResource) {
        this.refResource = refResource;
        return this;
    }


    private AbstractLimit limiter;

    public AbstractLimit getLimiter() {
        return limiter;
    }

    public AdaptiveRule setLimiter(AbstractLimit limiter) {
        this.limiter = limiter;
        return this;
    }
}
