/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anfixmailapp.pl.models;

/**
 *
 * @author k.skowronski
 */
public class LeadDTO {
    
    private String ilosc;
    private String ownerName;
    private String auditUc;
    private String territoryCode;
    
    private String abbr;
    private String nip;
    private String auditDc;
    private String meetingTry;

    public String getIlosc() {
        return ilosc;
    }

    public void setIlosc(String ilosc) {
        this.ilosc = ilosc;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getAuditUc() {
        return auditUc;
    }

    public void setAuditUc(String auditUc) {
        this.auditUc = auditUc;
    }

    public String getTerritoryCode() {
        return territoryCode;
    }

    public void setTerritoryCode(String territoryCode) {
        this.territoryCode = territoryCode;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getAuditDc() {
        return auditDc;
    }

    public void setAuditDc(String auditDc) {
        this.auditDc = auditDc;
    }

    public String getMeetingTry() {
        return meetingTry;
    }

    public void setMeetingTry(String meetingTry) {
        this.meetingTry = meetingTry;
    }
    
    
    
}
