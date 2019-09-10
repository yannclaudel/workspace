package persistence;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

import quizz.ErrorApp;


public class ObjectPersistence {

	public static final String DIR = "";
	public static final String EXT = ".ser";
	public static final String SERVICEID = "ObjectPersistence";

	public static void saveObject(Serializable obj,String id) throws ErrorApp{
      ObjectOutput output = null;
      String fileOut = DIR + id + EXT;
      BufferedOutputStream buffer = null;
      OutputStream file = null;
      
      try {
         file = new FileOutputStream(fileOut);
         buffer = new BufferedOutputStream(file);
         output = new ObjectOutputStream(buffer);
         output.writeObject(obj);
      }catch (IOException e) {
         e.printStackTrace();
         throw new ErrorApp(SERVICEID, "IO", e.getMessage(), "TECH", e.getCause());
      } 
      catch (Exception e) {
         e.printStackTrace();
         throw new ErrorApp(SERVICEID, "GENERAL", e.getMessage(), "TECH", e.getCause());
      }
      finally{
         
         try {
            if (output!=null) output.close();
         } catch (Exception e2) {
            e2.printStackTrace();
         }
      }
      
   }
   
   public static Object loadObject(String id) throws ErrorApp{
      Object obj = null;
      ObjectInput input = null;
      String fileIn = DIR + id + EXT;
      BufferedInputStream buffer = null;
      InputStream file = null;
      try {
         file = new FileInputStream(fileIn);
         buffer = new BufferedInputStream(file);
         input = new ObjectInputStream(buffer);
         obj = input.readObject();
      }catch (FileNotFoundException e) {
         obj=null;
      }  catch (IOException e) {
         throw new ErrorApp(SERVICEID, "IO", e.getMessage(), "TECH", e.getCause());
      } 
      catch (Exception e) {
         throw new ErrorApp(SERVICEID, "GENERAL", e.getMessage(), "TECH", e.getCause());
      }
      finally{
         
         try {
            if (input!=null) input.close();
         } catch (Exception e2) {
            e2.printStackTrace();
         }
      }
      return obj;
   }

	
}
