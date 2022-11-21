package at.htl.control;

import io.quarkus.runtime.StartupEvent;
import org.jboss.logging.Logger;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

public class InitBean {

    @Inject
    Logger log;

    void onStart(@Observes StartupEvent ev) {
        log.info("The application is starting...");
    }
}
