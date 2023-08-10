package lab01;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import utils.HibernateUtils;


@WebListener
public class CreateSessionFactoryListener implements ServletContextListener {


    public void contextDestroyed(ServletContextEvent sce)  { 
        
    	System.out.println("1.CreateSessionFactoryListener#contextDestroyed()-222 正在執行...");
    	HibernateUtils.getSessionFactory().close();;
    }


    public void contextInitialized(ServletContextEvent sce)  {
    	System.out.println("2.CreateSessionFactoryListener#contextInitialized()-111 正在執行...");
    	System.out.println("---------------------------------");
         HibernateUtils.getSessionFactory();
         System.out.println("---------------------------------");
    }
	
}
