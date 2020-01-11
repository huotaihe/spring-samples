package com.github.huotaihe.springboot.learn.groovy;

import java.io.File;
import java.io.FileFilter;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.scripting.support.ScriptFactoryPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @ClassName GroovyFactory
 * @Author huotaihe
 * @Date 2018/9/14 10:39
 * @Version 1.0
 **/

@Component
public class GroovyFactory implements ApplicationContextAware {

  private String directory = "/Users/huotaihe/Documents/github/spring-boot-learn/spring-boot-groovy-refreshable/src/main/resources/groovy";

  public String getDirectory() {
    return directory;
  }

  public void setDirectory(String directory) {
    this.directory = directory;
  }

  @Bean
  public ScriptFactoryPostProcessor getScriptFactoryPostProcessor(){
    return new ScriptFactoryPostProcessor();
  }

  @Override
  public void setApplicationContext(ApplicationContext context)
      throws BeansException {
    // 只有这个对象才能注册bean到spring容器
    DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) context.getAutowireCapableBeanFactory();

    // 因为spring会自动将xml解析成BeanDefinition对象然后进行实例化，这里我们没有用xml，所以自己定义BeanDefinition
    // 这些信息跟spring配置文件的方式差不多，只不过有些东西lang:groovy标签帮我们完成了
    final String refreshCheckDelay = "org.springframework.scripting.support.ScriptFactoryPostProcessor.refreshCheckDelay";
    final String language = "org.springframework.scripting.support.ScriptFactoryPostProcessor.language";

//    String realDirectory = Thread.currentThread().getContextClassLoader().getResource(directory).getFile();
//    File root = new File(Thread.currentThread().getContextClassLoader().getResource(".").getFile());
    String realDirectory = "/Users/huotaihe/Documents/github/spring-boot-learn/spring-boot-groovy-refreshable/src/main/resources/groovy";
    File[] files = new File(realDirectory).listFiles(new FileFilter() {
      @Override
      public boolean accept(File pathname) {
        return pathname.getName().endsWith(".groovy") ? true : false;
      }
    });
    for (File file : files) {
      GenericBeanDefinition bd = new GenericBeanDefinition();
      bd.setBeanClassName("org.springframework.scripting.groovy.GroovyScriptFactory");
      // 刷新时间
      bd.setAttribute(refreshCheckDelay, 500);
      // 语言脚本
      bd.setAttribute(language, "groovy");
      // 文件目录
      bd.getConstructorArgumentValues().addIndexedArgumentValue(0, "file:" + file.getPath());
      // 注册到spring容器
      beanFactory.registerBeanDefinition(file.getName().replace(".groovy", ""), bd);
    }

  }

}

