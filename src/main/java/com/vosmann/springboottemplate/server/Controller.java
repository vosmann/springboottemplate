package com.vosmann.springboottemplate.server;

import com.codahale.metrics.Metric;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class Controller {

    private static final Logger LOG = LoggerFactory.getLogger(Controller.class);

    @Autowired
    private NopService nopService;
    @Autowired
    private MetricRegistry registry;

    @RequestMapping("/")
    @ResponseBody
    String root() {
        LOG.debug("Received request at /.");

        final Timer timer = registry.timer(MetricRegistry.name(Controller.class, "root"));
        final Timer.Context context = timer.time();
        try {
            return nopService.get();
        } finally {
            context.stop();
        }
    }


    @RequestMapping("/metrics")
    @ResponseBody
    Map<String, Metric> metrics() {
        return registry.getMetrics();
    }

}
