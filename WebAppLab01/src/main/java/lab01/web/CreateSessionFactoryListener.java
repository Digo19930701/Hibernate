package lab01.web;

//import javax.servlet.ServletContextEvent;
//import javax.servlet.ServletContextListener;
//import javax.servlet.annotation.WebListener;
//
//import lab01.utils.HibernateUtils;
//
//
//@WebListener
//public class CreateSessionFactoryListener implements ServletContextListener {
//
//    public void contextDestroyed(ServletContextEvent sce)  { 
//    	System.out.println("CreateSessionFactoryListener#contextDestroyed()-222 正在執行");
//    	HibernateUtils.getSessionFactory().close();;
//    }
//
//    public void contextInitialized(ServletContextEvent sce)  { 
//    	System.out.println("CreateSessionFactoryListener#contextInitialized()-111 正在執行");
//    	HibernateUtils.getSessionFactory();
//    }
//	
//}
