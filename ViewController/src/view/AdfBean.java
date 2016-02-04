package view;

import javax.faces.context.FacesContext;

import javax.servlet.ServletContext;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class AdfBean {
    private ApplicationContext ctx;
    public AdfBean() {
    }
    
    public String getValue()
    {
          Hello hello = (Hello) getBean("helloBean");
        return hello.getMessage(" World");
        }
    
    protected Object getBean(String name){
            if (ctx == null) {
                try {
                    return WebApplicationContextUtils.getWebApplicationContext((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getBean(name);
                } catch (BeansException e) {
                    System.out.println("Beans Exception" + e);
                }
            }
            try {
                return ctx.getBean(name);
            } catch (BeansException e) {
                System.out.println("Beans Exception" + e);
            }
            return null;
        }
}
