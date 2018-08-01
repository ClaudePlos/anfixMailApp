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

    public LeadDTO(String ilosc, String ownerName, String auditUc, String territoryCode) {
        this.ilosc = ilosc;
        this.ownerName = ownerName;
        this.auditUc = auditUc;
        this.territoryCode = territoryCode;
    }

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
    
    
    
}
