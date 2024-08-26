package com.example.uesr.utils;

import java.time.Instant;
import java.util.concurrent.atomic.AtomicInteger;

public class second {
    private static final AtomicInteger counter = new AtomicInteger(0);
    private static long lastTimestamp = -1;

    public synchronized int nextId() {
        long currentTimestamp = Instant.now().getEpochSecond();
        if (currentTimestamp != lastTimestamp) {
            lastTimestamp = currentTimestamp;
            counter.set(0);
        }
        return (int) (currentTimestamp * 1000 + counter.getAndIncrement());
    }
}
