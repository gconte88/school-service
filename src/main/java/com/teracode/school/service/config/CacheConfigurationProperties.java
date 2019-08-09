package com.teracode.school.service.config;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "redis")
@Data
public class CacheConfigurationProperties {

  //using 1 hour of cache expiring time.
  private long timeoutSeconds = 3600;
  private int redisPort = 6379;
  private String redisHost = "localhost";
  private Map<String, Long> cacheExpirations = new HashMap<>();
}