package com.avengers.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.plugins.ActionPlugin;
import org.elasticsearch.plugins.Plugin;
import org.elasticsearch.rest.RestHandler;

import java.util.Collections;
import java.util.List;

public class LogPlug extends Plugin {

    private final static Logger LOGGER = LogManager.getLogger(LogPlug.class);

    public LogPlug(){
        super();
        LOGGER.info("first LogPlug----------------");
    }
}
