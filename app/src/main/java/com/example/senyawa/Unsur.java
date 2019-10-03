package com.example.senyawa;

import java.util.List;

public class Unsur {
    private String unsur;
    private String kode;
    private List<Senyawa> senyawa;

    public String getUnsur() {
        return unsur;
    }

    public void setUnsur(String unsur) {
        this.unsur = unsur;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public List<Senyawa> getSenyawa() {
        return senyawa;
    }

    public void setSenyawa(List<Senyawa> senyawa) {
        this.senyawa = senyawa;
    }
}
