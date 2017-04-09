package me.guligo.hystrix.services;

import me.guligo.hystrix.Constants;

import java.util.concurrent.ThreadLocalRandom;

public final class MagicService {

    private final static long SERVER_FAILURE_THRESHOLD = Math.round(Long.valueOf(Integer.MAX_VALUE) - (Long.valueOf(Integer.MAX_VALUE) - Long.valueOf(Integer.MIN_VALUE)) * Constants.SERVER_FAILURE_PERCENTAGE);

    public Integer getMagicNumber() throws Exception {
        final int magicNumber = ThreadLocalRandom.current().nextInt();
        if (magicNumber >= SERVER_FAILURE_THRESHOLD) {
            throw new Exception("Boom!");
        }
        return magicNumber;
    }

}
