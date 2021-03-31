package com.ucoweb.tokoonline.model;

import java.io.Serializable;

public class Produk implements Serializable {

    public int id;
    public String name;
    public String harga;
    public int kategori_id;
    public String deskripsi;
    public String image;
    public String created_at;
    public String updated_at;

}
