package XML;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;

/**
 * @ClassName DemoXml
 * @Description
 * @Author Administrator
 * @Date 2023/3/27 19:19
 * @Version V1.0
 */
public class DemoXml {
    public static void main(String[] args) throws Exception{
        //创建SAXReader对象读取xml文件
        SAXReader saxReader = new SAXReader();

        //读取shops文件，获取Document对象
        Document document = saxReader.read(new File("src/XML/shops.xml"));

        //获取根元素
        Element rootElement = document.getRootElement();

        //获取根元素下所有的子元素
        Iterator<Element> elementIterator = rootElement.elementIterator();

        while (elementIterator.hasNext()){
            //取出元素
            Element element = elementIterator.next();

            //获取ID属性
            Attribute id = element.attribute("id");
            System.out.println(id.getName() + "==:" + id.getStringValue());

            //获取item子元素
            Element name = element.element("name");
            System.out.println(name.getName() + "===:" + name.getText());
            Element price = element.element("price");
            System.out.println(price.getName() + "===:" + price.getText());
            Element place = element.element("place");
            System.out.println(place.getName() + "===:" + place.getText());
            Element num = element.element("num");
            System.out.println(num.getName() + "===:" + num.getText());

            System.out.println("------------------------------------------");
        }
    }
}
