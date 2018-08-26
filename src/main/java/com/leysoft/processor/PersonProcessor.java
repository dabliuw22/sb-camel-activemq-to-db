
package com.leysoft.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import com.leysoft.exception.PersonException;
import com.leysoft.model.Person;

@Component
public class PersonProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        Person person = (Person) exchange.getIn().getBody();
        if (person == null || person.getId() == null || person.getName() == null
                || person.getUsername() == null) {
            throw new PersonException("Validation error");
        }
    }
}
