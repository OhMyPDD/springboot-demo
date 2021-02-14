package iflyer;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

//WebMvcConfigurationSupport会让mvc自动配置失效
//全局拦截器
@Configuration
class WholeConfigurerAdapter extends WebMvcConfigurationSupport {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// registry.addInterceptor(new
		// MyHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/");
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// 让端口号指向登录页面或首页
		registry.addViewController("/").setViewName("forward:/s/login.html");
		super.addViewControllers(registry);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// 将页面和公共静态资源映射出来
		registry.addResourceHandler("/s/**").addResourceLocations("classpath:/html/", "classpath:/static/public/");
		super.addResourceHandlers(registry);
	}
	
    /**
     * 重写 addCorsMappings方法:
    addMapping：配置可以被跨域的路径，可以任意配置，可以具体到直接请求路径。
    allowedMethods：允许所有的请求方法访问该跨域资源服务器，如：POST、GET、PUT、DELETE等。
    allowedOrigins：允许所有的请求域名访问我们的跨域资源，可以固定单条或者多条内容，如："http://www.baidu.com"，只有百度可以访问我们的跨域资源。
    allowedHeaders：允许所有的请求header访问，可以自定义设置任意请求头信息，如："X-TOKEN"
     */
    @Override
	protected void addCorsMappings(CorsRegistry registry) {
    	 super.addCorsMappings(registry);
         registry.addMapping("/**")
                 .allowedOrigins("*")
                 .allowedMethods("*")
                 .allowedHeaders("*");
	}

}
