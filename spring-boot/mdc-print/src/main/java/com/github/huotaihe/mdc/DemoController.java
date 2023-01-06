package com.github.huotaihe.mdc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 寒溪
 * @date 2023/01/05
 */
@RestController
public class DemoController {

    private final static Logger log = LoggerFactory.getLogger(DemoController.class);


    @GetMapping("/hello")
    public String hello() throws InterruptedException {

        log.info("hello");

        MDC.put("traceId", "abc");
        log.info("hello2");

        Thread t = new Thread(new ChildThread());
        t.start();

        t.join();

        return "hello";
    }

}

class ChildThread implements Runnable {

    private final static Logger log = LoggerFactory.getLogger(ChildThread.class);
    /**
     * When an object implementing interface {@code Runnable} is used
     * to create a thread, starting the thread causes the object's
     * {@code run} method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method {@code run} is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        log.info("child thread hello");
    }
}
