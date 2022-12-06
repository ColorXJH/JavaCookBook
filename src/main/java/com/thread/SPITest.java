package com.thread;

/**
 * @author ColorXJH
 * @version 1.0
 * @description:
 * @date 2022/12/2 15:15
 */
public class SPITest {
    public static void main(String[] args) {
        LoggerService service=LoggerService.getService();
        service.info("HELLO-SPI");
        service.debug("HELLO-SPI");
    }
}
