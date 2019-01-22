package com.service.impl;

import com.bean.UpFile;
import com.dao.UpFileDao;
import com.service.UpFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ${邹} on 2019/1/20.
 * 描述：
 */
@Service("upFileService")
public class UpFileServiceImpl implements UpFileService {
    @Autowired
    private UpFileDao upFileDao;
    @Override
    public UpFile selectFileById(int id) {
        return upFileDao.selectFileById( id );
    }

    @Override
    public int InsertUpFile(UpFile upFile) {
        return upFileDao.InsertUpFile( upFile );
    }

    @Override
    public List<UpFile> selectAllFile() {
        return upFileDao.selectAllFile();
    }
}
