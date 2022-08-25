package com.jackson.code;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SequenceWriter;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.JSONPObject;

/**
* author: Shubham S Ashtaputre
*
/
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        
    	
	    File file = new File("E:/Programming/Java_Codes/SpringBoot/jackson/persondata.json");
	    FileWriter fwr = new FileWriter(file,true);
	        
	    String filePath = "E:/Programming/Java_Codes/SpringBoot/jackson/persondata.json";
	    
	    //write to json file  
        /*Map<String, Object> map = new HashMap<>();
        ArrayList<Object> obj = new ArrayList<Object>();
        obj.add(new PersonDetails("Shubham3","ssa@*1233"));
        map.put("persondetails", obj);
        mapper.writeValue(file, map);*/     
	    
	    /*ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = new HashMap<>();
        ArrayList<Object> obj = new ArrayList<Object>();
        obj.add(new PersonDetails("Shubham1","ssa@*1234"));
        map.put("persondetails", obj);*/
       
	   /*read all contents of a json file
	   ObjectMapper mapper = new ObjectMapper();
	   mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	   PersonDetails p = mapper.readValue(Paths.get(filePath).toFile(), PersonDetails.class);
	   */    
	
	    ObjectMapper mapper = new ObjectMapper();
		//read particular array property contents from an existing json file    
		//ArrayNode arrayNode = (ArrayNode) mapper.readTree(Paths.get(filePath).toFile()).get("PersonDetails");
        ArrayNode arrayNode = (ArrayNode) mapper.readTree(Paths.get(filePath).toFile());//.get("PersonDetails");
        ObjectNode objN = mapper.createObjectNode();
        if(arrayNode.isArray()) {
			//insert values inside existing json array
        	objN.put("name","Shubham3");
        	objN.put("password","Shubham3@3");
        	arrayNode.add(objN);
        	mapper.writeValue(Paths.get(filePath).toFile(), arrayNode);
		    for(JsonNode jsonNode : arrayNode) {
		      System.out.println(jsonNode);
		    }  
        }
    }
}
