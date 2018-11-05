/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anfixmailapp;

import anfixmailapp.pl.job.JobCartrackMailRaportHotLead;
import anfixmailapp.pl.job.JobCartrackUpdateStatus;
import anfixmailapp.pl.job.JobCartrackZTestCron;
import java.util.HashSet;
import java.util.Set;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;


/**
 *
 * @author k.skowronski
 */
public class AnfixMailApp extends Application {
  
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        //stage.getIcons().add(new Image("/com/images/icon.png"));
        stage.setTitle("#anfix Klaudiusz v.08.08.2018");
        
        stage.setScene(scene);
        stage.show(); 
        
        JobDetail job1 = JobBuilder.newJob(JobCartrackMailRaportHotLead.class).withIdentity("job1", "group1").build();
        JobDetail job2 = JobBuilder.newJob(JobCartrackUpdateStatus.class).withIdentity("job2", "group2").build();
        JobDetail job3 = JobBuilder.newJob(JobCartrackZTestCron.class).withIdentity("job3", "group3").build();

        /*  
            .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?")) // 5s
            .withSchedule(CronScheduleBuilder.dailyAtHourAndMinute(13, 46)) //HH:MM
            .withSchedule(CronScheduleBuilder.weeklyOnDayAndHourAndMinute(3, 13, 46))
            .withSchedule(CronScheduleBuilder.monthlyOnDayAndHourAndMinute(28, 13, 46))
        */ 
        Trigger trigger1 = TriggerBuilder.newTrigger()
					.withIdentity("cronTrigger1", "group1")
					.withSchedule(CronScheduleBuilder.cronSchedule("0 55 22 ? * MON-FRI")) //MM HH godz:22:55
					.build();
        
        // drugie zadanie 
        Trigger trigger2 = TriggerBuilder.newTrigger()
					.withIdentity("cronTrigger2", "group2")
					.withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?")) 
					.build();
        
        //#3
        Trigger trigger3 = TriggerBuilder.newTrigger()
					.withIdentity("cronTrigger3", "group3")
					.withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * * * ?")) //10s
					.build();
        
        
			
        Scheduler scheduler1 = new StdSchedulerFactory().getScheduler();
        scheduler1.start();
        scheduler1.scheduleJob(job1, trigger1);    
        scheduler1.scheduleJob(job2, trigger2);  
        scheduler1.scheduleJob(job3, trigger3); 
    }
     
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
     
}
