/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anfixmailapp;

import anfixmailapp.pl.job.JobCartrackMailRaportHotLead;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.quartz.CronExpression;
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
        stage.setTitle("#anfix");
        
        stage.setScene(scene);
        stage.show(); 
        
        JobDetail job1 = JobBuilder.newJob(JobCartrackMailRaportHotLead.class).withIdentity("job1", "group1").build();

        /*  CronScheduleBuilder.cronSchedule("0/5 * * * * ?")
            CronScheduleBuilder.cronSchedule("0/5 * * * * ?")
            CronScheduleBuilder.dailyAtHourAndMinute(13, 46) //HH:MM
            CronScheduleBuilder.weeklyOnDayAndHourAndMinute(3, 13, 46)
            CronScheduleBuilder.monthlyOnDayAndHourAndMinute(28, 13, 46)
        */
        Trigger trigger1 = TriggerBuilder.newTrigger()
					.withIdentity("cronTrigger1", "group1")
					.withSchedule(CronScheduleBuilder.cronSchedule("0/60 * * * * ?")) //HH:MM
					.build();
			
        Scheduler scheduler1 = new StdSchedulerFactory().getScheduler();
        scheduler1.start();
        scheduler1.scheduleJob(job1, trigger1);     
    }
     
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
     
}
