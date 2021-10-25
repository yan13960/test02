package cn.itnanls.utils;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 *
 */
public class CacheUtil {

    private static CacheManager cacheManager=new CacheManager((CacheUtil.class.getClassLoader().getResourceAsStream("ehcache.xml")));
    //给cacheName缓存里面添加一个key和value
    public static void put(String cacheName,String key,Object value){
        Cache cache = cacheManager.getCache(cacheName);
        Element element=new Element(key,value);
        cache.put(element);

    }
    //从cacheName中拿到一个缓存
    public static Object get(String cacheName,String key){
        Cache cache = cacheManager.getCache(cacheName);
        return  cache.get(key).getObjectValue();
    }
    //从cacheName中删除一个缓存
    public static boolean delete(String cacheName,String key){
        Cache cache = cacheManager.getCache(cacheName);
        boolean remove = cache.remove(key);
        return  remove;
    }
}
