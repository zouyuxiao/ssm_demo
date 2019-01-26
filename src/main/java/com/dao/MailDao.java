package com.dao;

import com.bean.Mail;
import com.bean.MailExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ${邹} on 2019/1/24.
 * 描述：
 */
@Repository
public interface MailDao {
    int insert(Mail mail);
    int update(Mail mail);
    List<Mail> selectByMailExample(MailExample mailExample);
    int updateByExample(@Param("record") Mail record, @Param("example") MailExample example);
    List<Mail> findUsername(String username);
}
