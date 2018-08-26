
package com.leysoft.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.leysoft.model.Person;

@Component
public class DatabaseProcessor implements Processor {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseProcessor.class);

    private static final String INSERT_FORMAT =
            "insert into persons(id, name, username) values(:id, ':name', ':username')";

    @Override
    public void process(Exchange exchange) throws Exception {
        Person person = (Person) exchange.getIn().getBody();
        String insertPerson = INSERT_FORMAT.replace(":id", person.getId().toString())
                .replace(":name", person.getName()).replace(":username", person.getUsername());
        LOGGER.info("body -> {}", insertPerson);
        exchange.getIn().setBody(insertPerson);
    }
}
