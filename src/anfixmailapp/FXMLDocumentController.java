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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    
    private SimpleDateFormat dtYYYYMMDD = new SimpleDateFormat("yyyy-MM-dd"); 
    
    @FXML
    private Label label;
    
    @FXML
    private TextArea txtArea01;
      
    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception {
        System.out.println("You clicked me!");
        String ret = test();
        label.setText(ret);
    }
    
    @FXML
    private void runCrmCartrackReportHotLeadButton(ActionEvent event) throws Exception {
        runCrmCartrackReportHotLead();
        txtArea01.setText("OK");
    }
    
    public String test() throws Exception {
        List<CcDTO> ccList = new ArrayList<>();
        CcDTO cc = new CcDTO();
        cc.setMail("klaudsys@gmail.com");
        ccList.add(cc);
        CcDTO cc2 = new CcDTO();
        cc2.setMail("skowronski.klaudiusz@gmail.com");
        ccList.add(cc2);
        String ret = mail.sendMail("Topic","Massage","claude-plos@o2.pl", ccList);
        return ret;
    }
    
    
    public String runCrmCartrackReportHotLead() throws Exception{
        String txt = "";
        List<UserVO> listUsers = crmSelect.getListUsersWithReportsSales(); 
        
        List<CcDTO> ccList = new ArrayList<>();
        CcDTO ccStachira = new CcDTO();
        ccStachira.setMail("lstachira@cartrack.pl");
        ccList.add(ccStachira);
        CcDTO ccMiklasz = new CcDTO();
        ccMiklasz.setMail("tmiklaszewski@cartrack.pl");
        ccList.add(ccMiklasz);
        CcDTO ccClaude = new CcDTO();
        ccClaude.setMail("claude-plos@o2.pl");
        ccList.add(ccClaude);
        
        for ( UserVO u : listUsers ){
            txt = "Witaj,"+ "\n\n ";
//            if ( u.getEmail().equals("lstachira@cartrack.pl") || u.getEmail().equals("tmiklaszewski@cartrack.pl") 
//                    || u.getEmail().equals("mnitka@cartrack.pl") || u.getEmail().equals("prakoczy@cartrack.pl")  ){
                
//                if (u.getEmail().equals("lstachira@cartrack.pl") || u.getEmail().equals("tmiklaszewski@cartrack.pl") || u.getEmail().equals("mnitka@cartrack.pl")){
//                    u.setId(2);
//                }
            
                txt += u.getUserName() /*+ " id: " + u.getId()(*/ + "<br>";
                txt +=  "<br>";
                
                List<LeadDTO> leads = crmSelect.getListHotLeadForUser(u.getId().toString());
                
                int sum = 0;
                for ( LeadDTO l : leads){
                    sum += Integer.parseInt(l.getIlosc());
                }
                
                txt += "Ilości hot leadów z " + dtYYYYMMDD.format(new Date()) + " : " + sum;
                txt += "<table style=\"width:100%;border: 1px solid black;\">";
                txt += "<tr><th style='text-align:left;'>Ilosc</th><th style='text-align:left;'>PH</th><th style='text-align:left;'>TM</th><th style='text-align:left;'>Region</th></tr>"; 
                
                
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
                txt += "<table style=\"width:100%;border: 1px solid black;\">";
                txt += "<tr>"
                    + "<th style='text-align:left;'>NIP</th>"
                    + "<th style='text-align:left;'>Nazwa firmy</th>"
                    + "<th style='text-align:left;'>Flota</th>"
                    + "<th style='text-align:left;'>Konkurencja</th>"
                    + "<th style='text-align:left;'>Osoba kontaktowa</th>"
                    + "<th style='text-align:left;'>Numer Tel</th>"
                    + "<th style='text-align:left;'>Zainteresowanie spotkaniem</th>"
                    + "</tr>"; 
                List<LeadDTO> leadsAbbr = crmSelect.getListHotLeadForUserAbbr(u.getId().toString());
                for ( LeadDTO l : leadsAbbr){
                   txt += "<tr>"; 
                   txt += "<td>" + l.getNip() + "</td>"
                        + "<td>" + l.getAbbr() + "</td>"
                        + "<td>" + l.getFleetSize() + "</td>"
                        + "<td>" + l.getCompetitor().toString() + "</td>"
                        + "<td>" + l.getContactName() + "</td>"
                        + "<td>" + l.getPhoneNumber() + " / " + l.getPhoneNumber2() + " / " + l.getPhoneMobile() + "</td>"
                        + "<td> TAK </td>"
                        + "</tr>"; 
                }
                txt +=  "</table>";
           
                
                String ret = mail.sendMail("Raport Hot Lead", txt, u.getEmail(), ccList);
                txt += ret + "\n";  
            //} 

        }
        return txt;
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
