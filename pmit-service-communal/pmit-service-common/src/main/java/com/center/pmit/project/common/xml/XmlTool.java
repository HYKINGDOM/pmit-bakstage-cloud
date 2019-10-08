package com.center.pmit.project.common.xml;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class XmlTool {
    private static Map<String, List<?>> nodesMap = new HashMap<String, List<?>>();
    public static void initExportConfigInfo() throws Exception {
        SAXReader reader = new SAXReader();
        //String path = PmitApplication.class.getClassLoader().getResource("export_template.xml").getPath();
        String fileName = "excelTemp/export_template.xml";
        InputStream inputStream = ResourceRenderer.resourceLoader(fileName);
        Document document = reader.read(inputStream);
        Element node = document.getRootElement();
        List<?> nodeList = node.elements();
        for (int i = 0; i < nodeList.size(); i++) {
            Element element = (Element) nodeList.get(i);
            Attribute id = element.attribute("id");
            if(null != id)
            {
                nodesMap.put(id.getValue(), element.elements());
            }

        }
    }

    public static List<?> getElementById(String id)
    {
        return nodesMap.get(id);
    }

}
