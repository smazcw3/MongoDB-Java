package com.mongodb;

import java.io.IOException;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class HelloWorldFreemarkerStyle {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.setClassForTemplateLoading(
				HelloWorldFreemarkerStyle.class, "/");		
		try {
			Template helloTemplate = configuration.getTemplate("hello.ftl");
			StringWriter writer  = new StringWriter();
			Map <String, Object> helloMap = new HashMap <String, Object>();
			helloMap.put("name", "FreeMarker");
			try {
				helloTemplate.process(helloMap, writer);
			} catch (TemplateException e) {
				e.printStackTrace();
			}
			
			System.out.println(writer);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}
