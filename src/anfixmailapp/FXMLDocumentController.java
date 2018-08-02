/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anfixmailapp;

import anfixmailapp.pl.confing.SendMailTLS;
import anfixmailapp.pl.db.CrmSelect;
import anfixmailapp.pl.models.LeadDTO;
import anfixmailapp.pl.models.UserVO;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;


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
        String ret = mail.sendMail("Topic","Massage","claude-plos@o2.pl");
        label.setText(ret);
    }
    
    @FXML
    private void getData(ActionEvent event) {
        String txt = "";
        List<UserVO> listUsers = crmSelect.getListUsersWithReportsSales(); 
        
        for ( UserVO u : listUsers ){
            txt = "Witaj,"+ "\n\n ";
            if ( u.getUserName().equals("lstachira@cartrack.pl") || u.getUserName().equals("tmiklaszewski@cartrack.pl") || u.getUserName().equals("mnitka@cartrack.pl")  ){
                
            
                txt += u.getUserName() + "<br>";
                txt +=  "<br>";
                
                txt += "Ilości hot leadów";
                txt += "<table style=\"width:100%\">";
                txt += "<tr><th>Ilosc</th><th>OwnerName</th><th>UserCreated</th><th>TerritoryCode</th></tr>"; 
                List<LeadDTO> leads = crmSelect.getListHotLeadForUser(u.getId().toString());
                for ( LeadDTO l : leads){
                   txt += "<tr>"; 
                   txt += "<td>" + l.getIlosc() + "</td>"
                        + "<td>" + l.getOwnerName() + "</td>"
                        + "<td> " + l.getAuditUc() + "</td>"
                        + "<td>" + l.getTerritoryCode() + "</td>"
                        + "</tr>";                  
                }
                txt +=  "</table>";
                txt +=  "<br>";
                
                txt += "Ilości hot leadów - Raport";
                txt += "<table style=\"width:100%\">";
                txt += "<tr><th>Abbr</th><th>Nip</th><th>DateCreated</th><th>MeetingTr</th></tr>"; 
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
                
                String ret = mail.sendMail("Raport Hot Lead", txt, "claude-plos@o2.pl");
                        
            } 

        }
        
        
        
        txtArea01.setText(txt);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
