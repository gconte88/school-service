package com.teracode.school.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author Gonzalo Conte
 */
@Configuration
public class AppConfig {

  @Bean
  public RestTemplate restTemplate() {

    SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new SimpleClientHttpRequestFactory();

    simpleClientHttpRequestFactory.setConnectTimeout(3000);
    simpleClientHttpRequestFactory.setReadTimeout(3000);

    return new RestTemplate(simpleClientHttpRequestFactory);
  }
}
