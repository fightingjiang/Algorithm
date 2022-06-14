package flywight;


import java.util.HashMap;

public class WebSiteFactory {
    private HashMap<String,ConcreteWebSite> pool = new HashMap<>();

    //根据网站的类型返回一个网站   没有就创建放到池中并返回
    public WebSite getWebSiteCategory(String type){
        if(!pool.containsKey(type)){
            pool.put(type,new ConcreteWebSite(type)) ;
        }
        return (WebSite) pool.get(type);
    }

    public int getPoolSize(){
        return pool.size();
    }
}
