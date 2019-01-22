package com.dao;

import com.bean.UpFile;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ${邹} on 2019/1/20.
 * 描述：
 */
@Repository
public interface UpFileDao {
    UpFile selectFileById(int id);
    int InsertUpFile(UpFile upFile);
    List<UpFile> selectAllFile();
}
