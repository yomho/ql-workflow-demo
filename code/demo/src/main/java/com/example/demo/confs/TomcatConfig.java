package com.example.demo.confs;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TomcatConfig {
	@Bean
    public TomcatServletWebServerFactory webServerFactory() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.addConnectorCustomizers((Connector connector) -> {
			/*https://www.cnblogs.com/yushixin1024/p/16358216.html
			 * connector.setProperty("relaxedPathChars", "\"<>[\\]^`{|}");
			 * connector.setProperty("relaxedQueryChars", "\"<>[\\]^`{|}");
			 */
        	connector.setProperty("relaxedPathChars", "[]");
            connector.setProperty("relaxedQueryChars", "[]");
        });
        return factory;
    }
}
