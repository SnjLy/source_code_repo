package com.springmvc.fileUtil;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




public class FileUtils{
	private static final  Logger logger=LoggerFactory.getLogger(FileUtils.class);
	
	public enum ExodusTemplate{
		DAILYGOODSHOP("dailyGoodshop","template"+File.separator+"exodusTemplate.xlsx"),
		;
		
		private String value;
		private String path;
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		public String getPath() {
			return path;
		}
		public void setPath(String path) {
			this.path = path;
		}
		private ExodusTemplate(String value, String path) {
			this.value = value;
			this.path = path;
		}
		
		public static ExodusTemplate get(String value){
			for(ExodusTemplate template:ExodusTemplate.values()){
				if(template.value.equals(value)){
					return template;
				}
			}
			throw new IllegalArgumentException("argument error"+value);
		}
		
	}
	
	
}