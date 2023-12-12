package com.arka99.restaurant.main;

import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        String webAppLocation = "src/main/webapp/";
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(7070);
        tomcat.getConnector();
        try {
            StandardContext standardContext = (StandardContext) tomcat.addWebapp("/",
                    new File(webAppLocation).getAbsolutePath());
            File additionalWebInfClasses = new File("target/classes");
            WebResourceRoot resourceRoot = new StandardRoot(standardContext);
            resourceRoot.addPreResources(new DirResourceSet(resourceRoot, "/WEB-INF/classes",
                    additionalWebInfClasses.getAbsolutePath(), "/"));
            standardContext.setResources(resourceRoot);

            tomcat.start();
            tomcat.getServer().await();
        } catch (Exception e) {
            System.out.println("An exception occurred: " + e.getMessage());
        }
    }
}
