import java.io.*;

class WriteAFile {
	public static void main(String[] args) {
		try {
			FileWriter writer = new FileWriter("Foo.txt");
			writer.write("Hello foo!");
			writer.close();
			System.out.println("Hey");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}