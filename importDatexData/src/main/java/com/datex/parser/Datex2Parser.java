package com.datex.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import com.datex.model.Measurement;

public class Datex2Parser {
	
	public ArrayList<Measurement> parseXml(InputStream in)
    {
        //Create a empty link of users initially
        ArrayList<Measurement> list = new ArrayList<Measurement>();
        try
        {
            //Create default handler instance
            DatexParserHandler handler = new DatexParserHandler();
 
            //Create parser from factory
            XMLReader parser = XMLReaderFactory.createXMLReader();
 
            //Register handler with parser
            parser.setContentHandler(handler);
 
            //Create an input source from the XML input stream
            InputSource source = new InputSource(in);
 
            //parse the document
            parser.parse(source);
 
            //populate the parsed users list in above created empty list; You can return from here also.
            list = handler.getList();
 
        } catch (SAXException e) {
            if (in==null) System.err.println("IN IS NULL");
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
				try {
		        	if (in!=null) in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
        }
        return list;
    }

}
