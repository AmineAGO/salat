package dz.aggoun.prayer.houres.tools;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvFile  implements CsvFileInterface{
	   
	   public final static char SEPARATOR = ';';
	    private File file;
	    private List<String> lines;
	    private List<String[] > data;
	    private String[] titles;
	    private List<Map<String, String>> mappedData;
	    
	    private CsvFile() {
	    }

	    public CsvFile(File file) throws IOException {
	        this.file = file;

	        // Init
	        init();
	    }

	    private void init() throws IOException {
	        lines = CsvFileHelper.readFile(file);

	        data = new ArrayList<String[] >(lines.size());
	        String sep = new Character(SEPARATOR).toString();
	        
	        boolean first = true;
	        for (String line : lines) {
	            // Suppression des espaces de fin de ligne
	            line = line.trim();

	            // On saute les lignes vides
	            if (line.length() == 0) {
	                continue;
	            }

	            // On saute les lignes de commentaire
	            if (line.startsWith("#")) {
	                continue;
	            }

	            String[] oneData = line.split(sep);

	            if (first) {
	                titles = oneData;
	                first = false;
	            } else {
	                data.add(oneData);
	            }
	        }
	     // On mappe les lignes trouvées
	        mapData();
	    }

	    private void mapData() {
	        mappedData = new ArrayList<Map<String, String>>(data.size());

	        final int titlesLength = titles.length;

	        for (String[] oneData : data) {
	            final Map<String, String> map = new HashMap<String, String>();
	            for (int i = 0; i < titlesLength; i++) {
	                final String key = titles[i];
	                final String value = oneData[i];
	                map.put(key, value);
	            }

	            mappedData.add(map);
	        }
	    }
	    
	    @Override
	    public String[] getTitles() {
	        return titles;
	    }

		@Override
		public File getFile() {
		 
			return file;
		}

		@Override
		public List<String[]> getData() {
			 
			return data;
		}

		@Override
		public List<Map<String, String>> getMappedData() {
			return mappedData;
		}

		@Override
		public Map<String, String> getSearchLine(Integer i) {
			 
			return mappedData.get(i);
		}
}
