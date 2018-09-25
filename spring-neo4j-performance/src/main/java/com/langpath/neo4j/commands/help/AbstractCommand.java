package com.langpath.neo4j.commands.help;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;

/**
 * Created by root on 14.10.16.
 */
public abstract class AbstractCommand {

    @Autowired
    @Lazy
    @Qualifier("neo4jTimeLogger")
    public TimeLogger timeLogger;

}
