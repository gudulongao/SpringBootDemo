package demo.base.aware;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.*;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class DemoAware implements BeanNameAware, BeanFactoryAware, MessageSourceAware,
        ApplicationEventPublisherAware, ResourceLoaderAware {
    private String beanName;
    private BeanFactory beanFactory;
    private ApplicationEventPublisher eventPublisher;
    private MessageSource messageSource;
    private ResourceLoader resourceLoader;

    @Override
    public void setBeanName(String s) {

        this.beanName = s;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public void print() throws IOException {
        System.out.println("bean name: " + this.beanName);
        System.out.println("bean facotry: " + this.beanFactory.getClass());
        Resource resource = this.resourceLoader.getResource("classpath:valuedemo.properties");
        System.out.println("props: " + IOUtils.toString(resource.getInputStream()));
    }
}
