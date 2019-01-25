package com.dao;

import com.bean.Mail;
import org.springframework.stereotype.Repository;

/**
 * Created by ${邹} on 2019/1/24.
 * 描述：
 */
@Repository
public interface MailDao {
    int insert(Mail mail);
    int update(Mail mail);
}
