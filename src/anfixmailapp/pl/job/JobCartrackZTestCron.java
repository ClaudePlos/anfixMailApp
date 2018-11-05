/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anfixmailapp.pl.job;

import java.util.Date;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *
 * @author k.skowronski
 */
public class JobCartrackZTestCron implements Job{
    
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("JobCartrackZTestCron ------>>> Geeks! Time is " + new Date());
    }
    
}
