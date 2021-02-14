package iflyer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class IflyerApplication 
{
    public static void main( String[] args )
    {

		SpringApplication.run(IflyerApplication.class, args);
//    	SpringApplication app=new SpringApplication(IflyerApplication.class);
//        app.addListeners( new ApplicationPrepareListener(), new ApplicationReadyListener(),
//		new ApplicationEnvPrepareListener());
//        app.run(args);
    }
    
}

class ApplicationPrepareListener implements ApplicationListener<ApplicationPreparedEvent>{
	
	@Override
	public void onApplicationEvent(ApplicationPreparedEvent event) {
		// TODO Auto-generated method stub
		
	}
	
}
/*
 * bean注入完成，将所有服务注册到服务管理器ServicesManager
 */
class ApplicationReadyListener implements ApplicationListener<ApplicationReadyEvent>{

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		// TODO Auto-generated method stub
		ServicesManager.getInstance(event.getApplicationContext());
	}
}
class ApplicationEnvPrepareListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent>{

	@Override
	public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
		// TODO Auto-generated method stub
		
	}
	
}
