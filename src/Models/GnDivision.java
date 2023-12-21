/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author NCCS
 */
public class GnDivision {
    
    private String English;
    private String Sinhala;
    private String Tamil;
    private String GnCode;

    public String getEnglish() {
        return English;
    }

    public void setEnglish(String English) {
        this.English = English;
    }

    public String getSinhala() {
        return Sinhala;
    }

    public void setSinhala(String Sinhala) {
        this.Sinhala = Sinhala;
    }

    public String getTamil() {
        return Tamil;
    }

    public String getGnCode() { return GnCode; }

    public void setGnCode(String gnCode) { GnCode = gnCode; }

    public void setTamil(String Tamil) {
        this.Tamil = Tamil;
    }

    public GnDivision(String English, String Sinhala, String Tamil) {
        this.English = English;
        this.Sinhala = Sinhala;
        this.Tamil = Tamil;
    }

    public GnDivision(String english, String sinhala, String tamil, String gnCode) {
        English = english;
        Sinhala = sinhala;
        Tamil = tamil;
        GnCode = gnCode;
    }
}
