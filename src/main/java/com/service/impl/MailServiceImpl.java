package com.service.impl;

import com.bean.Mail;
import com.bean.MailExample;
import com.dao.MailDao;
import com.service.MailService;
import com.util.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by ${邹} on 2019/1/24.
 * 描述：
 */
@Service
public class MailServiceImpl implements MailService {
    @Autowired
    private MailDao mailDao;

    @Override
    public Integer save(Mail mail) throws Exception {
        //添加唯一激活码
        mail.setCode(UUID.randomUUID().toString().replaceAll("-",""));
        //设置账户默认状态 0：未激活
        mail.setState(0);
        //通过用户填写的邮箱，发送激活邮件
        MailUtil.sendMail(mail.getEmail(),mail.getCode());
        return mailDao.insert( mail );
    }

    @Override
    public int update(Mail mail) {
        MailExample mailExample = new MailExample();
        // 创建sql条件
        mailExample.createCriteria().andCodeEqualTo( mail.getCode() );
        // 通过条件查询用户信息
        List<Mail> list = mailDao.selectByMailExample( mailExample );
        Mail mail2 = null;
        for (Mail mail1 : list){
            mail1.setState( 1 );
            mail2 = mail1;
        }
      return mailDao.updateByExample( mail2,mailExample );
    }

    @Override
    public List<Mail> findUsername(String username) {
        return mailDao.findUsername( username );
    }
}
