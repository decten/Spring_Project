package servlet;

import java.io.File;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebApplicationServerLauncher {
    private static final Logger log = LoggerFactory.getLogger(WebApplicationServerLauncher.class);

    public static void main(String[] args) throws LifecycleException {
        //내장 톰캣
        String webDirLocation = "web/";

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        tomcat.addWebapp("", new File(webDirLocation).getAbsolutePath());
        log.info("Configuring web with basedir: {}", new File("./" + webDirLocation).getAbsolutePath());

        tomcat.start();
        tomcat.getServer().await();
    }
}
