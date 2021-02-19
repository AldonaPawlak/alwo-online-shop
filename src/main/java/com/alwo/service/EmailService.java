package com.alwo.service;

import com.alwo.model.Email;

public interface EmailService {

  Email getEmail(long id);
  void sendEmail(String to, String title, String content);

  Email addNewEmail(Email email);
}
