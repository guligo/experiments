package me.guligo.hystrix.services;

import me.guligo.hystrix.Constants;

import java.util.concurrent.ThreadLocalRandom;

public final class MagicService {

    public Integer getMagicNumber() throws Exception {
        final int magicNumber = ThreadLocalRandom.current().nextInt();
        if (magicNumber <= Integer.MAX_VALUE - (Integer.MAX_VALUE - Integer.MIN_VALUE) * Constants.SERVER_FAILURE_PERCENTAGE) {
            throw new Exception("Boom!");
        }
        return magicNumber;
    }

}
