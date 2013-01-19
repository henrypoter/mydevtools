package com.javaer.tools.config;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyAppContextListener implements ServletContextListener {

    // NOTE: static references are not a great idea, shown here for simplicity
    public static File xsltFolder;
    public static File xmlIndentXsltFile;
    public static File xml2JsonXsltFile;
    ServletContext context;

    public void contextInitialized(ServletContextEvent e) {
    	xsltFolder = new File(e.getServletContext().getInitParameter("xsltFolder"));
        xmlIndentXsltFile = new File(xsltFolder, "xml-indent.xslt");
        xml2JsonXsltFile = new File(e.getServletContext().getRealPath("/"), "xslt/xml-to-json.xsl");
        
        
        
        context = e.getServletContext();
		// set variable to servlet context
		context.setAttribute("TEST", "TEST_VALUE");
		
        System.out.println("xsltFolder:"+xsltFolder);//xsltFolder:\WEB-INF\xslt
        System.out.println("TEST:"+context.getAttribute("TEST"));//TEST:TEST_VALUE
        System.out.println("e.getServletContext().getContextPath():" +e.getServletContext().getContextPath());
        System.out.println("e.getServletContext().getRealPath('/'):" +e.getServletContext().getRealPath("/"));
        /*
            xsltFolder:\xslt
			TEST:TEST_VALUE
			e.getServletContext().getContextPath():/javer
			e.getServletContext().getRealPath('/'):D:\eclipse\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\javer\

         */
    }

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		//当web服务器shut down或者crash时执行
	}
}
