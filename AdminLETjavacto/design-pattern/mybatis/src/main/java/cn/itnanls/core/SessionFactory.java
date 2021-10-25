package cn.itnanls.core;

import org.dom4j.Document;

import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.*;

/**
 *
 */
public class SessionFactory {

    private DataSource dataSource;
    //xml环境  命名空间namespace，saveuser  ,saveuser的内容
    private  Map<String,Map<String,DaoWrapper>> env =new HashMap<>(8);
    //拿到配置路径
    public SessionFactory(String configPath) {
        parseConfigXml(configPath);
    }

    /**
     * 解析配置文件
     * @param configPath
     */
    private void parseConfigXml(String configPath)  {
        try {
            //解析数据源
            InputStream resource = SessionFactory.class.getClassLoader().getResourceAsStream(configPath);
            SAXReader reader=new SAXReader();
            Document read = reader.read(resource);
            Element ConfigRoot = read.getRootElement();
            Element dataSourceElement = ConfigRoot.element("dataSource");
            dataSource= DataSourceFactory.createDataSource(dataSourceElement.getTextTrim());
            //获取所有的mapper文件
            List mapperElements = ConfigRoot.elements("mapper");
            List<String> mapperPaths =new ArrayList<>();
            for (Object mapperElement : mapperElements) {
                Element element = (Element) mapperElement;
                mapperPaths.add(element.getTextTrim());
            }
            for (String mapperPath : mapperPaths) {
                //saveuser  ,saveuser的内容
                Map<String, DaoWrapper> wrapper = new HashMap<>(2);
                Document document =
                        reader.read(Session.class.getClassLoader().getResourceAsStream(mapperPath));
                Element root = document.getRootElement();
                String namespace = root.attribute("namespace").getValue();
                Iterator iterator = root.elementIterator();
                while (iterator.hasNext()) {
                    Element el = (Element) iterator.next();
                    String type = el.getName();
                    //attribute 属性
                    String id = el.attribute("id").getValue();
                    String resultType =
                            el.attribute("resultType").getValue();
                    String paramType = el.attribute("paramType").getValue();
                    String sqlStr = el.getTextTrim();
                    wrapper.put(id, new DaoWrapper(type, resultType,
                            paramType, sqlStr));
                }
                env.put(namespace, wrapper);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public  Session openSession() {
        try {
            Session session = new Session(dataSource.getConnection(),env);
            return session;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
