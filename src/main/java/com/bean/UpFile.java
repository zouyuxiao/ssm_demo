package com.bean;

import org.springframework.stereotype.Component;

/**
 * Created by ${邹} on 2019/1/20.
 * 描述：
 */
@Component
public class UpFile {
    private Long id;
    private String filename;
    private String filepath;
    public UpFile() {
        super();
    }
    public UpFile(Long id, String filename, String filepath) {
        super();
        this.id = id;
        this.filename = filename;
        this.filepath = filepath;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }
}

