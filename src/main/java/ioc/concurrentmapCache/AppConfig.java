package ioc.concurrentmapCache;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * Created by pankaj on 2/27/2017.
 */
@Configuration
@EnableCaching
@ComponentScan("com.pnakaj.spring.ioc.concurrentmapCache")
public class AppConfig {

    @Bean(name = "cacheManager")
    public SimpleCacheManager getSimpleCacheManager() {
        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
        simpleCacheManager.setCaches(Arrays.asList(new ConcurrentMapCache("customer")));
        return  simpleCacheManager;
    }
}
