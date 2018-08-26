
package com.leysoft.service.inter;

import org.springframework.mail.MailException;

public interface MailService {

    public void send(String message, String subject, String... to) throws MailException;
}
