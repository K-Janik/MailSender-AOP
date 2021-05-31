package pl.springboot2.karoljanik.mailsender.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.springboot2.karoljanik.mailsender.service.MailServiceImpl;

@Component
@Aspect
public class NewMovie {

    private MailServiceImpl mailService;

    @Autowired
    public NewMovie(MailServiceImpl mailService) {
        this.mailService = mailService;
    }

    @After("@annotation(AddMovie)")
    private void afterAddMovie() {
        mailService.sendMail("<email address>","New Movie Added", "Test message");
    }
}
