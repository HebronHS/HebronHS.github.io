//Sample Solution to Snapshot Day
import java.util.*;
import java.io.*;
public class Snapshot
{
	public static void main(String [] args) throws IOException
	{
		Scanner file = new Scanner(new File("snapshot.dat"));
		Course[] school = new Course[6];
		int i = 0;
		int total_population = 0;
		int total_tardies = 0;
		int n = 6;
		while(n-->0)
		{
			school[i++] = new Course(file.nextInt(), file.nextInt(), file.nextInt(), i);
			total_population+=school[i-1].students;
			total_tardies+=school[i-1].tardies;
		}
		//overridden compareTo sorts Courses based upon attendance percentage
		Arrays.sort(school);
		System.out.println(total_population);
		System.out.println(total_tardies);
		//first element is course with best attendance
		System.out.println(school[0].num);
		for(Course c:school)
		{
			System.out.print(c.num+" ");
		}
		System.out.println();
		
	}
}
class Course implements Comparable
{
	public int students;
	public int absent;
	public int tardies;
	public int num;
	public Course(int students, int absent, int tardies, int num)
	{
		this.students = students;
		this.absent = absent;
		this.tardies = tardies;
		this.num = num;
	}
	//attendance defined as #students_present/#students_enrolled
	public double attendancePercentage()
	{
		return (double)(this.students-this.absent)/(double)(this.students);
	}
	public int compareTo(Object o)
	{
		Course c = (Course) o;
		return (int)(c.attendancePercentage()*100-this.attendancePercentage()*100);
	}
}