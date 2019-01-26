package com.service;

import com.bean.Mail;

import java.util.List;

/**
 * Created by ${邹} on 2019/1/24.
 * 描述：
 */
public interface MailService {
    Integer save(Mail mail) throws Exception ;
    int update(Mail mail);
    List<Mail> findUsername(String username);
}
