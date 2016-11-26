import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.Socket;

class Student implements Serializable{
	private String name;
	private int age;
	private int grade;
	public Student(String name, int age, int grade) {
		super();
		this.name = name;
		this.age = age;
		this.grade = grade;
	}
	public String toString(){
		return name+" "+age+" "+grade;
	}
	
}
public class Main {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("192.168.233.128", 12345);
			PrintWriter out = new PrintWriter(
					new BufferedWriter(
							new OutputStreamWriter(
								socket.getOutputStream())));
			BufferedReader in = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("src/Main.java")));
			String l;
			while((l=in.readLine())!=null)
				out.println(l);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
