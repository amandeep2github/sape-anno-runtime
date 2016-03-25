package com.sapient.tdi.anno.service;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;
import org.springframework.stereotype.Service;

import com.sapient.tdi.anno.JsGridView;
import com.sapient.tdi.anno.JsGridViewColumn;

@Service("jsonService")
public class JsonService {
	public ObjectNode makeObjectNode(List<?> data) throws IllegalAccessException{
		ObjectMapper om = new ObjectMapper();
		ObjectNode jsonObject = om.createObjectNode();
		ArrayNode jsonArray = om.createArrayNode();
		ObjectNode keyNode = null;
		jsonObject.put("data", jsonArray);
		if(data == null || data.size() == 0)
			return jsonObject;
		
		
		int index = 0;
		for(Object domainObj : data){
			if(index++ == 0){
				Annotation[] annotations = domainObj.getClass().getAnnotations();
				for(Annotation annotation: annotations){
					if(annotation instanceof JsGridView){
						JsGridView gridViewAnno = (JsGridView)annotation;
						System.out.println("Class annotated with @JsGridView with name - "+gridViewAnno.name());
						jsonObject.put("DataGridName", gridViewAnno.name());
					}
				}
			}
			ObjectNode dataElement = om.createObjectNode();
			Field[] fields = domainObj.getClass().getDeclaredFields();
			for(Field field : fields){
				Annotation annotation = field.getAnnotation(JsGridViewColumn.class);
					if(annotation instanceof JsGridViewColumn){
						JsGridViewColumn gridViewColAnno = (JsGridViewColumn)annotation;
						
						try {
							field.setAccessible(true);
							if(keyNode == null && gridViewColAnno.key()){
								keyNode = om.createObjectNode();
								keyNode.put("column", gridViewColAnno.name());
								jsonObject.put("key", keyNode);
							}
							dataElement.put(gridViewColAnno.name(), field.get(domainObj).toString());
							
						} catch (IllegalArgumentException e) {
							e.printStackTrace();
							throw e;
						} catch (IllegalAccessException e) {
							e.printStackTrace();
							throw e;
						}
						
					}
			}
			jsonArray.add(dataElement);
		}
		return jsonObject;
	}
}
