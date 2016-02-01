package com.homeTask.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class SetPropertysListener implements ServletContextListener{
	
	public void contextInitialized(ServletContextEvent sce) {
        String rootPath = sce.getServletContext().getRealPath("/");
        System.setProperty("webroot", rootPath);

    }


	public void contextDestroyed(ServletContextEvent sce) {
		System.clearProperty("webroot");
	}

}
