import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;


public class GradeGeneratorFileBufferedReader {
	private static final String[] GRADES = {"A", "B", "C", "D", "F"};
	private static final String[] GRADE_MODIFIERS = {"+", "-", ""};
	
	private Random rand = new Random();
	
	public void generateGrades(String infilename, String outfilename){
		try{
			BufferedReader in = new BufferedReader(new FileReader(infilename));
			PrintWriter out = new PrintWriter(new FileOutputStream(outfilename));

			out.println("Name\t\tGrade");
			out.println("----------------------------");

			String name = in.readLine();
			
			while( name != null ){
				out.println(name + "\t" + generateGrade());
				
				name = in.readLine();
			}
			
			out.close();
		}catch(IOException e) {
			System.err.println(e.getMessage());
		}
	}
	
	private String generateGrade(){
		return GRADES[rand.nextInt(GRADES.length)] + 
			   GRADE_MODIFIERS[rand.nextInt(GRADE_MODIFIERS.length)];
	}
	
	public static void main(String[] args){
		String nameFile = "/Users/drk04747/classes/cs62/examples/GradesGenerator/names.txt";
		String gradesFile =  "/Users/drk04747/classes/cs62/examples/GradesGenerator/grades.txt";
		
		GradeGeneratorFileBufferedReader generator = new GradeGeneratorFileBufferedReader();
		generator.generateGrades(nameFile, gradesFile);
	}
}
