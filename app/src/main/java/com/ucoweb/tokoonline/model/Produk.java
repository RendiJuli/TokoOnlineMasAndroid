package com.ucoweb.tokoonline.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "keranjang")
public class Produk implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idTb")

    public int idTb;

    public int id;
    public String name;
    public String harga;
    public int kategori_id;
    public String deskripsi;
    public String image;
    public String created_at;
    public String updated_at;

}
