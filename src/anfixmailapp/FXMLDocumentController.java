/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anfixmailapp;

import anfixmailapp.pl.confing.SendMailTLS;
import anfixmailapp.pl.db.CrmSelect;
import anfixmailapp.pl.models.CcDTO;
import anfixmailapp.pl.models.LeadDTO;
import anfixmailapp.pl.models.UserVO;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javax.ejb.Schedule;


/**
 *
 * @author k.skowronski
 */
public class FXMLDocumentController implements Initializable {
    
    private SendMailTLS mail = new SendMailTLS();

    private CrmSelect crmSelect = CrmSelect.getInstance();
    
    @FXML
    private Label label;
    
    @FXML
    private TextArea txtArea01;
      
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        String ret = test();
        label.setText(ret);
    }
    
    @FXML
    private void runCrmCartrackReportHotLeadButton(ActionEvent event) {
        runCrmCartrackReportHotLead();
    }
    
    public String test(){
        List<CcDTO> ccList = new ArrayList<>();
        CcDTO cc = new CcDTO();
        cc.setMail("klaudsys@gmail.com");
        ccList.add(cc);
        String ret = mail.sendMail("Topic","Massage","claude-plos@o2.pl", ccList);
        return ret;
    }
    
    
    public void runCrmCartrackReportHotLead() {
        String txt = "";
        List<UserVO> listUsers = crmSelect.getListUsersWithReportsSales(); 
        
        List<CcDTO> ccList = new ArrayList<>();
        CcDTO cc = new CcDTO();
        cc.setMail("klaudsys@gmail.com");
        ccList.add(cc);
        
        for ( UserVO u : listUsers ){
            txt = "Witaj,"+ "\n\n ";
//            if ( u.getEmail().equals("lstachira@cartrack.pl") || u.getEmail().equals("tmiklaszewski@cartrack.pl") 
//                    || u.getEmail().equals("mnitka@cartrack.pl") || u.getEmail().equals("prakoczy@cartrack.pl")  ){
                
//                if (u.getEmail().equals("lstachira@cartrack.pl") || u.getEmail().equals("tmiklaszewski@cartrack.pl") || u.getEmail().equals("mnitka@cartrack.pl")){
//                    u.setId(2);
//                }
            
                txt += u.getUserName() /*+ " id: " + u.getId()(*/ + "<br>";
                txt +=  "<br>";
                
                txt += "Ilości hot leadów";
                txt += "<table style=\"width:100%\">";
                txt += "<tr><th style='text-align:left;'>Ilosc:</th><th style='text-align:left;'>OwnerName:</th><th style='text-align:left;'>UserCreated:</th><th style='text-align:left;'>RegionName:</th></tr>"; 
                List<LeadDTO> leads = crmSelect.getListHotLeadForUser(u.getId().toString());
                
                if ( leads.size() == 0 ) {
                    continue;
                }
                
                for ( LeadDTO l : leads){
                   txt += "<tr>"; 
                   txt += "<td>" + l.getIlosc() + "</td>"
                        + "<td>" + l.getOwnerName() + "</td>"
                        + "<td> " + l.getAuditUc() + "</td>"
                        + "<td>" + l.getRegionName()+ "</td>"
                        + "</tr>";                  
                }
                txt +=  "</table>";
                txt +=  "<br>";
                
                txt += "Ilości hot leadów - Raport";
                txt += "<table style=\"width:100%\">";
                txt += "<tr><th style='text-align:left;'>Abbr:</th><th style='text-align:left;'>Nip:</th><th style='text-align:left;'>DateCreated:</th><th style='text-align:left;'>MeetingTr:</th></tr>"; 
                List<LeadDTO> leadsAbbr = crmSelect.getListHotLeadForUserAbbr(u.getId().toString());
                for ( LeadDTO l : leadsAbbr){
                   txt += "<tr>"; 
                   txt += "<td>" + l.getAbbr() + "</td>"
                        + "<td>" + l.getNip() + "</td>"
                        + "<td>" + l.getAuditDc() + "</td>"
                        + "<td>" + l.getMeetingTry() + "</td>"
                        + "</tr>"; 
                }
                txt +=  "</table>";
           
                
                String ret = mail.sendMail("Raport Hot Lead", txt, u.getEmail(), ccList);
                        
            //} 

        }
        
        
        
        txtArea01.setText(txt);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
