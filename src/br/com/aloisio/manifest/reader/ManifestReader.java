package br.com.aloisio.manifest.reader;

import java.io.File;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

public class ManifestReader {
	private static String path = "/path/to/jars/";

	public static void main(String[] args) {
		File[] files = new File(path).listFiles();

		try {
			readJars(files);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void readJars(File[] files) throws Exception {
		for (File file : files) {
	        if (file.isDirectory()) {
	            System.out.println("Directory: " + file.getName());
	            readJars(file.listFiles()); // Calls same method again.
	        } else {
	        	if (file.getName().endsWith(".jar")) {
	        		System.out.println("File: " + file.getName());

	        		JarFile jar = new JarFile(file.getAbsolutePath());
	        		Manifest manifest = jar.getManifest();
	        		Attributes attributes = manifest.getMainAttributes();

	        		System.out.println(attributes.getValue("Implementation-Version"));
	        	}
	        }
	    }
	}
}