package com.example.repeatproject.dasboard.mainMenuBars.mediaFiles.updateDocFiles;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Entity
@Data
@Getter
@Setter
@Table(name = "update_documents")
public class TableUpdateDocFiles implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long doc_id;

    @Column
    private String doc_file_name;

//    @Lob
    @Column
    private byte[] doc_file_data;

    public TableUpdateDocFiles() {
    }

    public TableUpdateDocFiles(long doc_id, String doc_file_name, byte[] doc_file_data) {
        this.doc_id = doc_id;
        this.doc_file_name = doc_file_name;
        this.doc_file_data = doc_file_data;
    }

    public long getDoc_id() {
        return doc_id;
    }

    public void setDoc_id(long doc_id) {
        this.doc_id = doc_id;
    }

    public String getDoc_file_name() {
        return doc_file_name;
    }

    public void setDoc_file_name(String doc_file_name) {
        this.doc_file_name = doc_file_name;
    }

    public byte[] getDoc_file_data() {
        return doc_file_data;
    }

    public void setDoc_file_data(byte[] doc_file_data) {
        this.doc_file_data = doc_file_data;
    }
}
