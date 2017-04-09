package me.guligo.hystrix.controllers;

import me.guligo.hystrix.commands.MagicCommand;
import me.guligo.hystrix.services.MagicService;

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
    public void startMagicExperiment(@QueryParam("sampleCount") int sampleCount, @QueryParam("samplingPause") int samplingPause) {
        for (int sampleNumber = 0; sampleNumber < sampleCount; sampleNumber++) {
            try {
                Thread.sleep(samplingPause);
                System.out.printf("Sample %s%n", sampleNumber);

                final MagicCommand magicCommand = new MagicCommand(magicService);
                System.out.printf("Result of magic command = %s%n", magicCommand.execute());
            } catch (Exception e) {
                // not interested
            }
        }
    }

}
