package guru.springframework.sfgdi.services;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class CustomizedBeanPostProcessor implements BeanPostProcessor
{

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof LifeCycleDemoBean) {
            ((LifeCycleDemoBean)bean).afterInit();
            System.out.println("## BeanPostProcessor After Initialization");
        }
        return bean;
    }



    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof LifeCycleDemoBean) {
            System.out.println("## BeanPostProcessor Before Initialization");
        }
        return bean;
    }
}
