package me.guligo.hystrix.controllers;

import me.guligo.hystrix.commands.MagicCommand;
import me.guligo.hystrix.services.MagicService;
import rx.Observable;
import rx.functions.Action1;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/magic")
public final class MagicController {

    private final MagicService magicService;

    public MagicController() {
        magicService = new MagicService();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Say hello to wizard!";
    }

    @GET
    @Path("make")
    @Produces(MediaType.TEXT_PLAIN)
    public String startMagicExperiment(@QueryParam("sampleCount") final int sampleCount, @QueryParam("samplingPause") final int samplingPause) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int sampleNumber = 1; sampleNumber <= sampleCount; sampleNumber++) {
                    try {
                        Thread.sleep(samplingPause);

                        final MagicCommand magicCommand = new MagicCommand(magicService);
                        final Observable<Integer> magicObservable = magicCommand.observe();
                        final int sampleNumberAsConstant = sampleNumber;
                        magicObservable.subscribe(new Action1<Integer>() {
                            @Override
                            public void call(final Integer magicNumber) {
                                System.out.printf("Result of magic command %s is %s%n", sampleNumberAsConstant, magicNumber);
                            }
                        });
                    } catch (Exception e) {
                        // not interested
                    }
                }
            }
        }).start();
        return "Magic experiment successfully started";
    }

}
