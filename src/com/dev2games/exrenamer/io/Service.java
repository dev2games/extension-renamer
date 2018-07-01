package com.dev2games.exrenamer.io;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>Handles our Executor Service references</p>
 *
 * @author Nelson Sanchez
 */

public class Service {

    //Our thread executor which will be used for multi-threading when finding and replacing files
    public ExecutorService service = Executors.newCachedThreadPool();


    //Gets our executor service
    public ExecutorService getService() {
        return this.service;
    }


}
