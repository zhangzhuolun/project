package com.nq.sch_oa.config;

import org.apache.log4j.Logger;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.nq.sch_oa.config.CachingConfig;

/** 
 *Description: <启用缓存>. <br>
 *<p>
	<使用说明>
 </p>
 * Makedate:2015年5月7日 下午2:55:14
 * @author Administrator  
 * @version V1.0                             
 */
@Configuration
@EnableCaching//<!-- 启用缓存注解 --> <cache:annotation-driven cache-manager="cacheManager" />
public class CachingConfig {
	private static final Logger logger = Logger.getLogger(CachingConfig.class);
//	@Bean
//	public CacheManager cacheManager() {
//		logger.info("SimpleCacheManager");
//		SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
//
//		ConcurrentMapCache mapCache_default = new ConcurrentMapCache("default");
//
//		ConcurrentMapCache mapCache_commonCache = new ConcurrentMapCache(
//				"commonCache");
//
//		Set<Cache> caches = new HashSet<Cache>();
//		caches.add(mapCache_default);
//		caches.add(mapCache_commonCache);
//
//		simpleCacheManager.setCaches(caches);
//
//		return simpleCacheManager;
//	}

	@Bean
	public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {
		EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
		ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource(
				"config/ehcache.xml"));
		return ehCacheManagerFactoryBean;
	}

	@Bean
	public CacheManager cacheManager() {
		logger.info("EhCacheCacheManager");
		EhCacheCacheManager cacheManager = new EhCacheCacheManager();
		cacheManager.setCacheManager(ehCacheManagerFactoryBean().getObject());
		return cacheManager;
	}
}
