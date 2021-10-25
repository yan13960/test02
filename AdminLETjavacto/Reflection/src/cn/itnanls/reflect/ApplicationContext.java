package cn.itnanls.reflect;

import cn.itnanls.Annotation.AutoWird;
import cn.itnanls.Annotation.Bean;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 *
 */
public class ApplicationContext<T> {


    private  HashMap<Class,Object> beanFactory =new HashMap<>();

    private    String filePath;

   public  T getBean(Class clazz){
       return  (T) beanFactory.get(clazz);
   }
   //初始化容器
   public  void  initContext(){
       /*beanFactory.put(IUserDao.class,new UserDaoImpl());
       beanFactory.put(IBookDao.class,new IBookDaoImpl());
       beanFactory.put(IUserService.class,new IUserServiceImpl());
       beanFactory.put(IBookDao.class,new IBookServiceImpl());*/

        InputStream resource = ApplicationContext.class.getClassLoader()
                .getResourceAsStream("config/bean.config");
        Properties properties=new Properties();
        try {
            properties.load(resource);
            Set<Object> keys = properties.keySet();
            for (Object key : keys) {
                beanFactory.put(Class.forName(key.toString()),
                        Class.forName(properties.getProperty(key.toString())).newInstance() );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //加载全部的类的实例
    public   void  initContextByAnnotation(){
         filePath = ApplicationContext.class.getClassLoader().getResource("").getFile();
       // System.out.println(filePath);

        loadOne(new File(filePath));

        assembleObject();
    }

   //是不是给所有的字符赋值
    private void assembleObject() {
       for (Map.Entry<Class ,Object> entry :beanFactory.entrySet()){
           //就是放在容器的对象
           Object obj = entry.getValue();
           Class<?> aClass = obj.getClass();
           System.out.println(aClass);
           Field[] declaredFields = aClass.getDeclaredFields();
           for (Field field : declaredFields) {
               AutoWird annotation = field.getAnnotation(AutoWird.class);
               if (annotation!=null){
                   field.setAccessible(true);
                   try {
                       System.out.println("正在给【"+obj.getClass().getName()+"属性【"+field.getName()+"】注入值【"+beanFactory.get(field.getType()).getClass().getName()+"】");

                       field.set(obj,beanFactory.get(field.getType()));
                   } catch (IllegalAccessException e) {
                       e.printStackTrace();
                   }
               }
           }
       }
    }

    /**
     * 加载一个文件的类
     * @param fileParent
     */
    private   void loadOne(File fileParent){
       if (fileParent.isDirectory()){
           File[] childrenFiles = fileParent.listFiles();
           if (childrenFiles==null||childrenFiles.length==0){
               return;
           }
           for (File child : childrenFiles) {
               if (child.isDirectory()){
                   //如果是个文件夹就继续调用该方法 ,使用了递归
                   loadOne(child);
               }else {
                   //通过文件路径完成全类名，第一步把绝对路径部分去掉
                   String pathWithClass = child.getAbsolutePath().substring(filePath.length() - 1);
                  //选中class文件
                   if (pathWithClass.contains(".class")){
                       //去掉.class后缀，并且把 \ 替换成 .
                       String fullName = pathWithClass.replaceAll("\\\\", ".").replace(".class", "");
                       try{
                           Class<?> aClass = Class.forName(fullName);

                           //把非接口的类实例化放在map中
                           if (!aClass.isInterface()){
                               Bean annotation = aClass.getAnnotation(Bean.class);
                               //判断一下有没有接口
                               if (annotation!=null){
                                   Object instance = aClass.newInstance();
                                   if (aClass.getInterfaces().length>0){
                                       //如果有接口把接口的class当成key，实例对象当成value
                                       System.out.println("正在加载【"+aClass.getName()+"】,实例对象是"+instance.getClass().getName());
                                       beanFactory.put(aClass.getInterfaces()[0],instance);
                                   }else {
                                       //如果没有接口把自己的class当成key，实例对象当成value
                                       System.out.println("正在加载【"+aClass.getName()+"】,实例对象是"+instance.getClass().getName());
                                       beanFactory.put(aClass,instance);
                                   }

                               }

                           }
                       }catch (Exception e){
                           e.printStackTrace();
                       }
                   }
               }
           }
       }
    }
}
