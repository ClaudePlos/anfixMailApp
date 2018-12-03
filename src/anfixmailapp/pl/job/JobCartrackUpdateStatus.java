/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anfixmailapp.pl.job;

import anfixmailapp.pl.db.CrmSelect;
import anfixmailapp.pl.db.StatusSelect;
import anfixmailapp.pl.models.CompanyDataVO;
import java.util.Date;
import java.util.List;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *
 * @author k.skowronski
 */
public class JobCartrackUpdateStatus implements Job{
    
    private StatusSelect statusSelect = StatusSelect.getInstance();
    
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("JobCartrackUpdateStatus --->>> Geeks! Time is " + new Date());
        checkCompaniesOpportunityDeadLine30();
    }
    
    public void checkCompaniesOpportunityDeadLine30(){
        
        List<CompanyDataVO> comapnys = statusSelect.getCompaniesOpportunityDeadLine30();
        
        for ( CompanyDataVO cd : comapnys ){
            System.err.println( cd.getAbbr() + "!" );
        }
        
    }
    
}
