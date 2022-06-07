package guru.springframework.sfgdi.services;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class LifeCycleDemoBean implements InitializingBean, DisposableBean, BeanNameAware
                            , BeanFactoryAware, ApplicationContextAware{

    public LifeCycleDemoBean() {
        System.out.println("## LifeCycleDemoBean Default Constructor");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("## The LifeCycleDemoBean has its  Properties Set.");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("## LifeCycleDemoBean destroy() invoked.");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("## BeanNameAware: Bean name is " + s);
    }


    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("## BeanFactoryAware: Bean Factory has been set." );
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("## ApplicationContextAware: setApplicationContext has been invoked");
    }


    @PostConstruct
    public void postConstructMethod()
    {
        System.out.println("## Post Contruct Method is invoked");
    }

    @PreDestroy
    public void preDestroyMethod()
    {
        System.out.println("PreDestroy() method is invoked");
    }


    public void afterInit() {
        System.out.println("After Init");
    }

}
