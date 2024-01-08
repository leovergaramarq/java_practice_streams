package streamBytes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamBytes {
    
    public static void main(String args[]){
        String path="src/res/mesi.jpg", path2="src/res/messi.jpg";
        int size=14440;
        //size=size1(path);
        
        int[] bytes = read1(path, size);
        createFile(bytes, path2);
    }
    
    static int size1(String path){
        int bytes=0;
        
        try (FileInputStream fis=new FileInputStream(path)){
            int bt;
            while((bt=fis.read())!=-1){
                bytes++;
            }
            //fis.close();
        } catch (FileNotFoundException ex) {} catch (IOException ex){}
        
        return bytes;
    }
    
    static long size2(String path){
        try (FileInputStream fis=new FileInputStream(path)){
            return fis.getChannel().size();
            //fis.close();
        } catch (FileNotFoundException ex) {} catch (IOException ex){}
        
        return 0;
    }
    
    static int[] read1(String path){
        return read1(path, size1(path));
    }
    
    static int[] read1(String path, int size){
        int[] bytes=new int[size];
        
        try (FileInputStream fis=new FileInputStream(path)){
            for(int i=0; i<size; i++)
                bytes[i]=fis.read();
            
            //fis.close();
        } catch (FileNotFoundException ex) {} catch (IOException ex){}
        
        return bytes;
    }
    
    static boolean createFile(int[] bytes, String path){
        try (FileOutputStream fos=new FileOutputStream(path)){
            for (int bt: bytes)
                fos.write(bt);
            
            //fos.close();
        }catch(IOException ex){
            return false;
        }
        
        return true;
    }
}