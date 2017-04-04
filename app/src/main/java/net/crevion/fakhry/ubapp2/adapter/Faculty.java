package net.crevion.fakhry.ubapp2.adapter;

/**
 * Created by Fakhry on 04/04/2017.
 */

public class Faculty {
    private String nama, weburl;

    public Faculty(){

    }

    public Faculty(String nama, String weburl){
        this.nama = nama;
        this.weburl = weburl;
    }

    public String getNama(){
        return nama;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public String getWeburl(){
        return weburl;
    }

    public void setWeburl(String weburl){
        this.weburl = weburl;
    }
}
