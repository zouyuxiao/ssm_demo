package com.service;

import com.bean.UpFile;

import java.util.List;

/**
 * Created by ${邹} on 2019/1/20.
 * 描述：
 */
public interface UpFileService {
    UpFile selectFileById(int id);
    int InsertUpFile(UpFile upFile);
    List<UpFile> selectAllFile();
}
