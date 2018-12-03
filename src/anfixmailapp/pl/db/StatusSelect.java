/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anfixmailapp.pl.db;

import anfixmailapp.pl.models.CompanyDataVO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author k.skowronski
 */
public class StatusSelect {
    
    
    private static final EntityManagerFactory emfInstance =
		        Persistence.createEntityManagerFactory("anfixMailAppPU");
    private EntityManager em;
    
    public StatusSelect() {
        em = emfInstance.createEntityManager();
    }
    
    private static volatile StatusSelect instance = null;
    
    public static StatusSelect getInstance() {
        if (instance == null) {
          instance = new StatusSelect();
        }
        return instance;
    }
    
    
    
       public List<CompanyDataVO> getCompaniesOpportunityDeadLine30() {
        List<CompanyDataVO> comapnysL = new ArrayList<CompanyDataVO>();
        
        List<Object []> comapnys = em.createNativeQuery("select cd.* from processes_data pd, companys_data cd\n" +
                " where cd.id = pd.company_id\n" +
                "   and cd.status2 = pd.process_type\n" +
                "   and process_type = 'OPORTUNITY'\n" +
                "   and result is null\n" +
                "   and date_deadline < now() - INTERVAL '30 DAYS'\n" +
                "   and date_ended is null").getResultList();
        
        for ( Object[] c : comapnys){
            CompanyDataVO com = new CompanyDataVO();
            com.setId((Integer) c[0]);
            com.setAbbr((String) c[1]);
            comapnysL.add(com);
        }
        
        return comapnysL;
    }
    
    
    
}
