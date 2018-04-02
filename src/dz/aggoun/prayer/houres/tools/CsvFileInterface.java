package dz.aggoun.prayer.houres.tools;

import java.io.File;
import java.util.List;
import java.util.Map;

public interface CsvFileInterface {
	File getFile();

    List<String[] > getData();

    String[] getTitles();
    List<Map<String,String>> getMappedData();
    Map<String,String> getSearchLine(Integer i);
}
