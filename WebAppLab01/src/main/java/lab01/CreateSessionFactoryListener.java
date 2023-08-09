package lab01;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import utils.HibernateUtils;


@WebListener
public class CreateSessionFactoryListener implements ServletContextListener {


    public void contextDestroyed(ServletContextEvent sce)  { 
        
    	System.out.println("CreateSessionFactoryListener#contextDestroyed() 正在執行...");
    	HibernateUtils.getSessionFactory().close();;
    }


    public void contextInitialized(ServletContextEvent sce)  {
    	System.out.println("CreateSessionFactoryListener#contextInitialized() 正在執行...");
         HibernateUtils.getSessionFactory();
    }
	
}
