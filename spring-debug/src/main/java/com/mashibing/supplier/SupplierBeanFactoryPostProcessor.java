package com.mashibing.supplier;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

public class SupplierBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition user = beanFactory.getBeanDefinition("user");
        // setInstanceSupplier() 在 AbstractBeanDefinition 抽象类中,
        // beanDefinition 最早是 GenericBeanDefinition, 且 GenericBeanDefinition 继承了 AbstractBeanDefinition
        GenericBeanDefinition genericBeanDefinition = (GenericBeanDefinition) user;
        genericBeanDefinition.setInstanceSupplier(CreateSupplier::createUser);
        genericBeanDefinition.setBeanClass(User.class);
    }
}
