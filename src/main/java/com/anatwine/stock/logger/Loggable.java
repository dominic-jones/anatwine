package com.anatwine.stock.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * Would typically move this to a util package.
 * Not the only way to set up a logger though, of course.
 */
public interface Loggable {

    default Logger logger() {
        return LoggerFactory.getLogger(this.getClass());
    }
}
