package com.xinzhi.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 */
public class Test2 {
    public static void main(String[] args)throws Exception {
        Clazz clazz = Test2.readXml();
        System.out.println(clazz);
    }
    public static Clazz readXml(){
        Clazz clazz=new Clazz();
        List<Student>students=new ArrayList<>();
        //获取sax解析器对象
        SAXReader reader = new SAXReader();
        try {
            //获取文件的Document对象
            Document document = reader.read(Test2.class.getClassLoader().getResourceAsStream("conf/class.xml"));
            //获取根元素
            Element root = document.getRootElement();
            //System.out.println(root.attribute("name").getValue()); //开发六部
            clazz.setName(root.attribute("name").getValue());
            List<Element> elements = root.elements();
            for (Element element : elements) {
                //System.out.println(element.getName());//student
                List<Element>stuElement = element.elements();
                Student student=new Student();
                for (Element attr : stuElement) {
                    System.out.println(attr.getName()+"---"+attr.getData());
                    Class<Student> studentClass = Student.class;
                    Field field = studentClass.getDeclaredField(attr.getName());
                    field.setAccessible(true);
                  if (field.getType()==String.class){
                      field.set(student,attr.getData());
                  }else if (field.getType()==int.class){
                      field.set(student,Integer.parseInt(attr.getData().toString()));
                  }
                }
                students.add(student);
            }
          clazz.setStudents(students);
            /* Element foo;
            Iterator i = root.elementIterator("e");
            while (i.hasNext()){
                foo = (Element)i.next();
                System.out.println("CLASS:"+foo.elementText("CLASS"));
                System.out.println("GBCODE:"+foo.elementText("GBCODE"));
                System.out.println("ID:"+foo.elementText("ID"));
                System.out.println("LAT:"+foo.elementText("LAT"));
                System.out.println("LON:"+foo.elementText("LON"));
                System.out.println("NAME:"+foo.elementText("NAME"));
                System.out.println("==============================\n");
            }*/
        } catch (DocumentException | NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return clazz;
    }
}
