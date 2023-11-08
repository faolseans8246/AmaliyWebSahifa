package com.example.repeatproject.dasboard.mainMenuBars.mediaFiles.updateImageFiles;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Setter
@Getter
@Data
@Table(name = "images")
public class TableImage implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id_im;

    @Column
    private byte[] param_imag;


    public TableImage() {
    }

    public TableImage(long id_im, byte[] param_imag) {
        this.id_im = id_im;
        this.param_imag = param_imag;
    }

    public long getId_im() {
        return id_im;
    }

    public void setId_im(long id_im) {
        this.id_im = id_im;
    }

    public byte[] getParam_imag() {
        return param_imag;
    }

    public void setParam_imag(byte[] param_imag) {
        this.param_imag = param_imag;
    }
}
