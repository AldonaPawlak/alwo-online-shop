package com.alwo.service.impl;

import com.alwo.exception.ResourceNotFoundException;
import com.alwo.model.Email;
import com.alwo.repository.EmailRepository;
import com.alwo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


@Service
public class EmailServiceImpl implements EmailService {

  private EmailRepository emailRepository;

  public EmailServiceImpl(EmailRepository emailRepository) {
    this.emailRepository = emailRepository;
  }

  @Autowired
  private JavaMailSender javaMailSender;

  @Override
  public Email getEmail(long id) {
    return emailRepository.findById(id)
      .orElseThrow(() -> new ResourceNotFoundException("Email " + id + " does not exist"));
  }

  @Override

  public void sendEmail(String to, String title, String content) {
    MimeMessage mail = javaMailSender.createMimeMessage();
    try {
      MimeMessageHelper helper = new MimeMessageHelper(mail, true);
      helper.setTo(to);
      helper.setReplyTo("alwobookstore@gmail.com");
      helper.setFrom("alwobookstore@gmail.com");
      helper.setSubject(title);
      helper.setText(content, true);
    } catch (MessagingException e) {
      e.printStackTrace();
    }
    javaMailSender.send(mail);

  }

  @Override
  public Email addNewEmail(Email email) {
    return email;
  }
}
