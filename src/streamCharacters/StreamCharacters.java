package streamCharacters;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StreamCharacters {

    public static void main(String[] args) {
        String path="src/res/hi.txt";
        //System.out.println(read3(path));
        //write1(path, "it works\nBITCHES!!!", true);
    }
    
    static String read1(String path){
        String string="";
        char end=(char)-1;
        
        try(FileReader fr=new FileReader(path)) {
            char c;
            while((c=(char)fr.read())!=end){
                string+=c;
            }
            //fr.close();
        } catch (IOException ex) {}
        
        return string;
    }
    
    static String read2(String path){
        String string="";
        
        try (FileReader fr=new FileReader(path); BufferedReader br=new BufferedReader(fr)){
            String row;
            while((row=br.readLine())!=null){
                string+=row+"\n";
            }
            //br.close();
            //fr.close();
        } catch (FileNotFoundException ex) {} catch (IOException ex) {}
        
        return string.substring(0, string.length()-1);
    }
    
    static String read3(String path){
        String string="";
        
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(path), Charset.defaultCharset())) {
            String line;
            while ((line = reader.readLine()) != null) {
                string+=line+"\n";
            }
            //reader.close();
        }catch(IOException ex){}
        
        return string.substring(0, string.length()-1);
    }
    
    static boolean write1(String path, String txt, boolean append){
        try (FileWriter fw=new FileWriter(path, append); BufferedWriter bw=new BufferedWriter(fw)){
            bw.write(txt);
            //bw.close();
            //fw.close();
        } catch (IOException ex) {
            return false;
        }
        
        return true;
    }
    
    static boolean write2(String path, String txt, boolean append){
        try (FileWriter fw=new FileWriter(path, append)){
            fw.write(txt);
            //fw.close();
        } catch (IOException ex) {
            return false;
        }
        
        return true;
    }
}