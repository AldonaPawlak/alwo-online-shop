package com.alwo.controller;

import com.alwo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@RestController
public class EmailController {

  @PostMapping("/alwo/contact")
  public void sendEmail(@RequestBody String email) {
    System.out.println(email);
  }

  private final EmailService emailSender;
  private final TemplateEngine templateEngine;

  @Autowired
  public EmailController(EmailService emailSender,
                         TemplateEngine templateEngine){
    this.emailSender= emailSender;
    this.templateEngine = templateEngine;
  }

  @GetMapping("/alwo/contact/email")
  @ResponseStatus(HttpStatus.OK)
  public void send(String email) {
    Context context = new Context();
    context.setVariable("header", "New greate books on Alwo BOOKSTORE!!! :-)");
    context.setVariable("title", "Bestsellers!");
    context.setVariable("description", "The Best Books!!!");
    String body = templateEngine.process("template", context);
    emailSender.sendEmail("aldonapawlak2@gmail.com", "Alwo BOOKSTORE Newsletter", body);
  }
}
