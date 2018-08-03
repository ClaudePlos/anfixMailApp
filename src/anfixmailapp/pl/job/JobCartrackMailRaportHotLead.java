/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anfixmailapp.pl.job;

import anfixmailapp.FXMLDocumentController;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class JobCartrackMailRaportHotLead implements Job{ 
    
    FXMLDocumentController con = new FXMLDocumentController();
	
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("Job1 --->>> Hello geeks! Time is " + new Date());
                con.test();
		} 
}
