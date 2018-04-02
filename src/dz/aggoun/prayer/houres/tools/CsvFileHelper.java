package dz.aggoun.prayer.houres.tools;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class CsvFileHelper {
	 
    public static String getResourcePath(String fileName) {
        final File f = new File("");
        final String dossierPath = f.getAbsolutePath() + File.separator +"Files"+ File.separator + fileName;
        return dossierPath;
    }

    public static File getResource(String fileName) {
        final String completeFileName = getResourcePath(fileName);
        File file = new File(completeFileName);
        return file;
    }
    
    
    public static  List<String> readFile(File file) throws IOException {

        List<String> result = new ArrayList<String>();

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        for (String line = br.readLine(); line != null; line = br.readLine()) {
            result.add(line);
        }

        br.close();
        fr.close();

        return result;
    }
    
    

@Test
public void testReadFile() throws IOException {
    // Param
    final String fileName = FILE_NAME;

    // Result
    final int nombreLigne = 31;

    // Appel
    final File file = CsvFileHelper.getResource(fileName);
    List<String> lines = CsvFileHelper.readFile(file);

    // Test
    Assert.assertEquals(nombreLigne, lines.size());
}

    
private final static String FILE_NAME = "3.csv";

@Test
public void testGetResource() {
    // Param
    final String fileName = FILE_NAME;

    // Result
    // ...

    // Appel
    final File file = CsvFileHelper.getResource(fileName);

    // Test
    // On sait que le fichier existe bien puisque c'est avec lui qu'on travaille depuis le début.
    assertTrue(file.exists());
}

 }
