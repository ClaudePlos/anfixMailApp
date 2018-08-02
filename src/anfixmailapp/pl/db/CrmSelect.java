/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anfixmailapp.pl.db;

import anfixmailapp.pl.models.LeadDTO;
import anfixmailapp.pl.models.UserVO;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author k.skowronski
 */
public class CrmSelect {
    
    private static final EntityManagerFactory emfInstance =
		        Persistence.createEntityManagerFactory("anfixMailAppPU");
    private EntityManager em;
    
    public CrmSelect() {
        em = emfInstance.createEntityManager();
    }
    
    private static volatile CrmSelect instance = null;
    
    public static CrmSelect getInstance() {
        if (instance == null) {
          instance = new CrmSelect();
        }
        return instance;
    }
    
    
    
    public List<UserVO> getListUsers() {
        //List<UserVO> usersL = new ArrayList<UserVO>();
        
        List<UserVO> users = em.createQuery("SELECT u FROM UserVO u").getResultList();
        
//        for ( Object[] u : users){
//            UserVO user = new UserVO();
//            user.setEmail( (String) u[0]);
//            usersL.add(user);
//        }
        
        return users;
    }
    

    public List<UserVO> getListUsersWithReportsSales() {
        
        List<UserVO> usersL = new ArrayList<UserVO>();
        

        
        List<Object []> users = em.createNativeQuery("SELECT row_number() over(order by users.id) as sqlid, email, users.username, users.id\n" +
"			FROM users, permission_definitions, profiles_permissions, profiles\n" +
"			WHERE permission_definitions.id =profiles_permissions.permission_id\n" +
"			 and  profiles_permissions.profile_id = profiles.id\n" +
"			 and  profiles.code = users.profile_code and is_active = 'Y'\n" +
"       and permission_definitions.id = 29").getResultList();
        
        
        for ( Object[] u : users){
            UserVO user = new UserVO();
            user.setEmail( (String) u[1] );
            user.setUserName( (String) u[2] );
            user.setId( (int) u[3] );
            usersL.add(user);
        }
        
        return usersL;
    }
    

    
    //raport (ilości hot leadów danego handlowca z podziałem na TM i województwo)
    public List<LeadDTO> getListHotLeadForUser(String userId) {
        
        List<LeadDTO> leadsL = new ArrayList<LeadDTO>();
        
        List<Object []> leads = em.createNativeQuery("SELECT count(1) hot_leads, processes_data.owner_name, processes_data.audit_uc, regions.region_name " 
                + "FROM processes_data, companys_data, regions " 
                + "WHERE companys_data.id = processes_data.company_id "
                + "and regions.id = companys_data.province_id "
                + "and processes_data.process_type = 'HOT_LEAD' "
                + "and date(processes_data.audit_dc) = date(now()) "
                + "and owner_id = '" + userId + " '"
                + "group by processes_data.owner_name, processes_data.audit_uc, regions.region_name").getResultList();
        
        
        for ( Object[] l : leads){
            LeadDTO lead = new LeadDTO();
            lead.setIlosc( Long.toString((Long) l[0]) );
            lead.setOwnerName((String) l[1]);
            lead.setAuditUc((String) l[2]);
            lead.setRegionName((String) l[3]);
            leadsL.add(lead);
        }
        
        return leadsL;
    }
    

    //raport (uproszczony)
    public List<LeadDTO> getListHotLeadForUserAbbr(String userId) {
        
        List<LeadDTO> leadsL = new ArrayList<LeadDTO>();
        
        List<Object []> leads = em.createNativeQuery("SELECT companys_data.abbr, companys_data.nip, processes_data.audit_dc,\n" +
                    "    CASE\n" +
                    "        WHEN processes_data.counter_phone_contacts >= 1 THEN 'TAK'\n" +
                    "        ELSE 'NIE'\n" +
                    "    END contact_try,\n" +
                    "    CASE\n" +
                    "        WHEN processes_data.counter_meetings >= 1 THEN 'TAK'\n" +
                    "        ELSE 'NIE'\n" +
                    "    END meeting_try\n" +
                    "FROM companys_data, processes_data\n" +
                    "WHERE companys_data.id = processes_data.company_id and processes_data.process_type = 'HOT_LEAD' "
                + "and processes_data.owner_id = '" + userId + "'").getResultList();
        
        
        for ( Object[] l : leads){
            LeadDTO lead = new LeadDTO();
            lead.setAbbr((String) l[0]);
            lead.setNip((String) l[1]);
            Timestamp timestamp = (Timestamp) l[2];
            lead.setAuditDc( timestamp.toString() );
            lead.setMeetingTry((String) l[3]);
            leadsL.add(lead);
        }
        
        return leadsL;
    }

    
    
}
