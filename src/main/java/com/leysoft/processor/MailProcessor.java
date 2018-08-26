
package com.leysoft.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.leysoft.service.inter.MailService;

@Component
public class MailProcessor implements Processor {

    @Value(
            value = "${mail.to}")
    private String[] to;

    @Autowired
    private MailService mailService;

    @Override
    public void process(Exchange exchange) throws Exception {
        Exception exception = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Exception.class);
        String message = "Error: " + exception;
        String subject = "Error camel";
        mailService.send(message, subject, to);
    }
}
