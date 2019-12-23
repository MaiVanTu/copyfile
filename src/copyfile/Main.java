package copyfile;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Main {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 StringBuilder sb = new StringBuilder();
		 String root = "/home/ubuntu/Documents/Work";
		 String dir = "/home/ubuntu/Documents/copy/" + System.currentTimeMillis();

	        try (BufferedReader br = Files.newBufferedReader(Paths.get("test.txt"))) {

	            // read line by line
	            String line;
	            while ((line = br.readLine()) != null) {
	                Path sourceDirectory = Paths.get(root + line);
	                System.out.println(sourceDirectory.getParent().toString());
	                
	                Path targetDirectory = Paths.get(dir+ line);
	                System.out.println(targetDirectory.getParent().toString());
	                File targetFile = new File(targetDirectory.getParent().toString());
	                if (!targetFile.exists()) {
	                	targetFile.mkdirs();
	                }

	                //copy source to target using Files Class
	                Files.copy(sourceDirectory, targetDirectory, StandardCopyOption.REPLACE_EXISTING);
	            }

	        } catch (IOException e) {
	            System.err.format("IOException: %s%n", e);
	        }

	}

}
