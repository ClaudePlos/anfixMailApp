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
        String ret = mail.sendMail("Topic","Massage");
        label.setText(ret);
    }
    
    @FXML
    private void getData(ActionEvent event) {
        String txt = "";
        List<UserVO> listUsers = crmSelect.getListUsersWithReportsSales(); 
        
        for ( UserVO u : listUsers ){
            txt += u.getEmail() + "\n";
            
            List<LeadDTO> leads = crmSelect.getListHotLeadForUser(u.getId().toString());
            for ( LeadDTO l : leads){
               txt += "il: " + l.getIlosc() 
                       + " OwnerName: " + l.getOwnerName()
                       + " DateCreate: " + l.getAuditUc()
                       + " TerritoryCode: " + l.getTerritoryCode()
                       + "\n";
            }
            
        }
        
        txtArea01.setText(txt);
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
