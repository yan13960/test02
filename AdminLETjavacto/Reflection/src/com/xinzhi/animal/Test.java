package com.xinzhi.animal;

import java.util.Properties;

/**
 *
 */
public class Test {
    public static void main(String[] args) throws Exception {

        Girl cuizhen=new Girl();
        Properties properties  = new Properties();
        properties.load(Test.class.getClassLoader().getResourceAsStream("conf/pat.properties"));
        Animal pat = (Animal) Class.forName(properties.getProperty("animal")).newInstance();

        GirlLike annotation = pat.getClass().getAnnotation(GirlLike.class);
        if (annotation!=null){
            cuizhen.feedPat(pat);
        }else {
            System.out.println("她拒绝了这个宠物");
        }
    }
}
