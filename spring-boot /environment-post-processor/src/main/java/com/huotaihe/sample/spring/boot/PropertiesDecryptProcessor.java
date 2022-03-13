package com.huotaihe.sample.spring.boot;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.EnumerablePropertySource;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

/**
 * @author 寒溪
 * @date 2022/03/11
 */
@Slf4j
public class PropertiesDecryptProcessor implements EnvironmentPostProcessor {

    public final static String ENCRYPTION_VALUE_PREFIX = "{encryption}";

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        log.info("properties decrypt processor init.");
        MutablePropertySources propertySources = environment.getPropertySources();


        Map<String, Object> source = new ConcurrentHashMap<>();
        MapPropertySource decryptedPropertySource = new MapPropertySource("HuoDecryPropertySource", source);

        propertySources.forEach((propertySource) -> {
            log.info("propertySource: {}", propertySource);

            if (propertySource instanceof EnumerablePropertySource) {
                log.info("enumerable property source");
                String[] propertyNames = ((EnumerablePropertySource)propertySource).getPropertyNames();

                if (ArrayUtils.isEmpty(propertyNames)) {
                    log.debug("empty properties key");
                    return;
                }

                for (String propertyName : propertyNames) {
                    String propertyValue = environment.getProperty(propertyName);
                    if (StringUtils.startsWith(propertyValue, ENCRYPTION_VALUE_PREFIX)) {
                        log.debug("find encrypt key {} value {}", propertyName, propertyValue);
                        source.put(propertyName,decry(propertyValue));
                    }
                }
            }
        });

        environment.getPropertySources().addFirst(decryptedPropertySource);
    }

    public String decry(String value) {
        return StringUtils.replace(value, ENCRYPTION_VALUE_PREFIX,"");
    }
}


