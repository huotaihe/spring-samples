package com.github.huotaihe.spring.boot.learn.profile;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * ProfileService
 *
 * @author: huotaihe
 * @Date: 18:14 2019-11-20
 **/
@Service
@Slf4j
public class ProfileService implements ApplicationContextAware {



    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        String[] profiles = applicationContext.getEnvironment().getActiveProfiles();

        log.info("Profiles: {}", Arrays.toString(profiles));

    }
}
