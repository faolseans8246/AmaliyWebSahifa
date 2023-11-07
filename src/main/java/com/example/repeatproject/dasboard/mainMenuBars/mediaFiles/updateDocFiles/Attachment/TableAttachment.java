package com.example.repeatproject.dasboard.mainMenuBars.mediaFiles.updateDocFiles.Attachment;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class TableAttachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long ids;

    @Column
    private String filename;

    @Column
    private String content_type;

    @Column
//    @Lob
    private byte[] data;

    public TableAttachment() {
    }

    public TableAttachment(long ids, String filename, String content_type, byte[] data) {
        this.ids = ids;
        this.filename = filename;
        this.content_type = content_type;
        this.data = data;
    }

    public long getIds() {
        return ids;
    }

    public void setIds(long ids) {
        this.ids = ids;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getContent_type() {
        return content_type;
    }

    public void setContent_type(String content_type) {
        this.content_type = content_type;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
