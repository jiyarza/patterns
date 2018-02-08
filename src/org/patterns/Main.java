package org.patterns;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.patterns.command.Actor;
import org.patterns.command.Command;
import org.patterns.command.CoverCommand;
import org.patterns.command.PayCommand;
import org.patterns.prototype.Some;
import org.patterns.prototype.SomeOther;
import org.patterns.prototype.Spawner;

import com.google.gson.Gson;

public class Main {
	
	final static String path = "resources/";
	
	// Reverse ordering (most recently modified first)
	private static final Comparator<Path> LASTMODIFIEDFIRST_ORDER = new Comparator<Path>() {
		public int compare(Path o1, Path o2) { 
			return Long.compare(o2.toFile().lastModified(), o1.toFile().lastModified());			
		}		
	};
	
	public static void main(String[] args) {
		
		// This creates the pattern		
		Spawner spawnOne = new Spawner(new Some());
		Spawner spawnTwo = new Spawner(new SomeOther());
		
		// Use it
		Some o1 = (Some) spawnOne.create();
		Some o2 = (Some) spawnTwo.create();
		
		o1.setMaxh(9);
		o2.setMaxm(7);
		
		System.out.println(o1.toString());
		System.out.println(o2.toString());

		Gson g = new Gson();
		System.out.println(g.toJson(o1)); // {"name":"John"}
		System.out.println(g.toJson(o2)); // {"name":"John"}
		

		// read from json
		//Gson gson = new Gson();
		//JsonReader reader = new JsonReader(new FileReader("data.json"));
		//List<Some> data = gson.fromJson(reader, SOME_TYPE); // contains the whole reviews list
		
		// Read from json String
		String jsonString = "{'maxh':3,'maxm':60,'name':'Test','items':[{'name':'Thing','price':32},{'name':'Boots','price':32}]}";
		Some some = new Gson().fromJson(jsonString, Some.class);
		System.out.println(g.toJson(some));
		
		try {
			save(some);
			System.out.println(new Gson().toJson(fileList(path)));
			Path lastSave = getLastSave();
			System.out.println(lastSave.getFileName());
		} catch (IOException e) {
			e.printStackTrace();
		}
				
	}
	
	public static void save(Some s) throws IOException {
		Gson g = new Gson();
		try (FileWriter writer = new FileWriter(path+"save.json")) {
			g.toJson(s, s.getClass(), writer);
			writer.close();
		}
		System.out.println("Saved.");
	}
	
	public String nextFilename() throws IOException {		
		return null;
	}
	
	public static List<String> fileList(String directory) throws IOException {
        List<String> fileNames = new ArrayList<String>();
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(directory))) {
            for (Path path : directoryStream) {
                fileNames.add(path.getFileName().toString());
            }
        }
        Collections.sort(fileNames);
        return fileNames;
    }	
	
	public static Path getLastSave() throws IOException {		
		return fileListRecentFirst(path).get(0);
	}

	/**
	 * Return a list of Path ordered by modified date (last modified first)
	 * Useful to get the last save (first item in the list)
	 * @param directory
	 * @return
	 * @throws IOException
	 */
	public static List<Path> fileListRecentFirst(String directory) throws IOException {
        List<Path> paths = new ArrayList<Path>();
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(directory))) {
            for (Path path : directoryStream) {            	
                paths.add(path);
            }
        }
        Collections.sort(paths, LASTMODIFIEDFIRST_ORDER);
        return paths;
    }
	
	
	public static void testCommand() {
		// Command		
		Actor w = new Actor();
		Command c1 = new PayCommand(w);
		Command c2 = new CoverCommand(w);
		
		c1.execute();
		c2.execute();
	}
}
