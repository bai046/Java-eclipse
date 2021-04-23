package pojo;

import java.util.HashMap;
import java.util.Map;

public class Student extends Person {
	private Map<Course, Double> results=new HashMap<Course,Double>();//学生的成绩

	public Map<Course, Double> getResults() {
		return results;
	}

	public void setResults(Map<Course, Double> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
}

