package dz.aggoun.prayer.houres.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
 

public class TextFileReader {
	public static void main(String args[]) {ReadTextFile("Files/Info");}
	public static  String ReadTextFile(String fileName) {
		String text="";
		 
		 List<String> list = new ArrayList<>();
		 try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {

				//br returns as stream and convert it into a List
				list = br.lines().collect(Collectors.toList());

			} catch (IOException e) {
				e.printStackTrace();
			}
		 for(String line : list){
			 text+=line+"\r\n";
			}
		 
		        
		return text;
	}
}
