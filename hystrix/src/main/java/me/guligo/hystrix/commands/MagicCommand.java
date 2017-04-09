package me.guligo.hystrix.commands;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import me.guligo.hystrix.services.MagicService;

public final class MagicCommand extends HystrixCommand<Integer> {

    private final MagicService magicService;

    public MagicCommand(MagicService magicService) {
        super(HystrixCommandGroupKey.Factory.asKey("MagicExperiment"));
        this.magicService = magicService;
    }

    @Override
    protected Integer run() throws Exception {
        return magicService.getMagicNumber();
    }

    @Override
    protected Integer getFallback() {
        return 0;
    }

}
