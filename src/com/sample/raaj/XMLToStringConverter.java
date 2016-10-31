package com.sample.raaj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 * @author I333245
 *
 */
public class XMLToStringConverter {

	public static void main(String[] args) {
		XMLToStringConverter xmltool = new XMLToStringConverter();
//		System.out.println(xmltool.convertXMLFileToString("C:/my_workspace/bdh-2/XMLtoString/bin/com/sample/raaj/test.xml"));
		try {
			System.out.println(xmltool.xmltoString("C:/my_workspace/bdh-2/XMLtoString/bin/com/sample/raaj/test.xml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param fileName
	 * @return
	 */
	public String convertXMLFileToString(String fileName) {
		
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			InputStream inputStream = new FileInputStream(new File(fileName));
			org.w3c.dom.Document doc = documentBuilderFactory.newDocumentBuilder().parse(inputStream);
			StringWriter stw = new StringWriter();
			Transformer serializer = TransformerFactory.newInstance().newTransformer();
			serializer.transform(new DOMSource(doc), new StreamResult(stw));
			return stw.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String xmltoString(String filename) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File(filename)));
		String line;
		StringBuilder sb = new StringBuilder();

		while((line = br.readLine())!= null){
		    sb.append(line.trim());
		}
		
		br.close();
		
		return sb.toString();
	}

}
