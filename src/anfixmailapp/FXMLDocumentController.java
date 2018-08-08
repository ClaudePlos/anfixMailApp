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
import java.io.OutputStream;
import java.net.HttpURLConnection;
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
import javax.net.ssl.HttpsURLConnection;
import java.net.URL;
import java.io.*;



/**
 *
 * @author k.skowronski 
 */
public class FXMLDocumentController implements Initializable {
    
    private SendMailTLS mail = new SendMailTLS();

    private CrmSelect crmSelect = CrmSelect.getInstance();
    
    private SimpleDateFormat dtYYYYMMDD = new SimpleDateFormat("yyyy-MM-dd"); 
    
    private String url = "http://localhost:18080/api";
    
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
    
    @FXML
    private void runTestRestButton(ActionEvent event) throws Exception {
        runTestRest();
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
    
    
    public String runCrmCartrackReportHotLead() throws Exception {
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
                
                txt += "Ilości hot leadów z " + dtYYYYMMDD.format(new Date()) + " szt.: " + sum;
                txt += "<table style=\"width:100%;border-collapse: collapse;\">";
                txt += "<tr><th style='border: 1px solid black'>Ilosc</th>"
                        + "<th style='border: 1px solid black'>PH</th>"
                        + "<th style='border: 1px solid black'>TM</th>"
                        + "<th style='border: 1px solid black'>Region</th></tr>"; 
                
                
                if ( leads.size() == 0 ) {
                    continue;
                }
                
                for ( LeadDTO l : leads){
                   txt += "<tr>"; 
                   txt += "<td style='border: 1px solid black'>" + l.getIlosc() + "</td>"
                        + "<td style='border: 1px solid black'>" + l.getOwnerName() + "</td>"
                        + "<td style='border: 1px solid black'> " + l.getAuditUc() + "</td>"
                        + "<td style='border: 1px solid black'>" + l.getRegionName()+ "</td>"
                        + "</tr>";                  
                }
                txt +=  "</table>";
                txt +=  "<br>";
                
                txt += "Ilości hot leadów - Raport";
                txt += "<table style=\"width:100%;border-collapse: collapse;\">";
                txt += "<tr>"
                    + "<th style='border: 1px solid black'>NIP</th>"
                    + "<th style='border: 1px solid black'>Nazwa firmy</th>"
                    + "<th style='border: 1px solid black'>Flota</th>"
                    + "<th style='border: 1px solid black'>Konkurencja</th>"
                    + "<th style='border: 1px solid black'>Osoba kontaktowa</th>"
                    + "<th style='border: 1px solid black'>Numer Tel</th>"
                    + "<th style='border: 1px solid black'>Zainteresowanie spotkaniem</th>"
                    + "</tr>"; 
                List<LeadDTO> leadsAbbr = crmSelect.getListHotLeadForUserAbbr(u.getId().toString());
                for ( LeadDTO l : leadsAbbr){
                
                if ( l.getCompetitor() == null )
                    l.setCompetitor(Boolean.FALSE);
                    
                txt += "<tr>"; 
                   txt += "<td style='border: 1px solid black'>" + l.getNip() + "</td>"
                        + "<td style='border: 1px solid black'>" + l.getAbbr() + "</td>"
                        + "<td style='border: 1px solid black'>" + l.getFleetSize() + "</td>"
                        + "<td style='border: 1px solid black'>" + l.getCompetitor().toString().replace("false", "NIE").replace("true", "TAK") + "</td>"
                        + "<td style='border: 1px solid black'>" + l.getContactName() + "</td>"
                        + "<td style='border: 1px solid black'>" + l.getPhoneNumber() + " / " + l.getPhoneNumber2() + " / " + l.getPhoneMobile() + "</td>"
                        + "<td style='border: 1px solid black'> TAK </td>"
                        + "</tr>"; 
                }
                txt +=  "</table>";
           
                
                String ret = mail.sendMail("Raport Hot Lead", txt.replace("null", ""), u.getEmail()
                        , ccList);
                txt += ret + "\n";  
            //} 

        }
        return txt;
    }
    
    public String runTestRest() throws Exception {
        
        URL obj = new URL(url+"/v1.0/dialer/start-update-dialer-and-notes");
        //HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        //add reuqest header
        con.setConnectTimeout(5000);
        con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        con.setDoOutput(true);
        con.setDoInput(true);
        con.setRequestMethod("POST");
        
        String json  = "{\"userName\": \"klaudiusz\"" +
                    ",\"change\": \"Qwk7h9ykIdBZYKO1PJQaKozzlgDuE3yW7VQmPOI5dapYa2i06i\"" +
                    ",\"method\": \"md5\" }";


        OutputStream os = con.getOutputStream();
        os.write(json.getBytes("UTF-8"));
        os.close();
        
        // read the response
        InputStream in = new BufferedInputStream(con.getInputStream());
        String result = org.apache.commons.io.IOUtils.toString(in, "UTF-8");
        System.out.println(result);
//        JSONArray jsonArray = new JSONArray(result);

        //in.close();
        con.disconnect();
        
        return "OK";
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
