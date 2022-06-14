package flywight;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        WebSiteFactory webSiteFactory = new WebSiteFactory();
        WebSite website1 = webSiteFactory.getWebSiteCategory("News");
        website1.use(new User("client1"));

        // 客户要一个以博客形式发布的网站
        WebSite webSite2 = webSiteFactory.getWebSiteCategory("博客");

        webSite2.use(new User("jack"));

        // 客户要一个以博客形式发布的网站
        WebSite webSite3 = webSiteFactory.getWebSiteCategory("博客");

        webSite3.use(new User("smith"));

        // 客户要一个以博客形式发布的网站
        WebSite webSite4 = webSiteFactory.getWebSiteCategory("博客");

        webSite4.use(new User("king"));


        System.out.println(webSiteFactory.getPoolSize());
    }
}
