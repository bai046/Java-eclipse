package test.point;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ListTest {

	public static void main(String[] args) {
		List<Integer> stringList = new ArrayList<>();
		stringList.add(3);
		stringList.add(4);
		stringList.add(5);
		stringList.add(6);
		
		List<String> result = stringList.stream().map(n->{
			return "ÀÏ" + n;
		}).filter(name->{
			if(Integer.parseInt(name.substring("ÀÏ".length()))>5) {
				return false;
			}
			return true;
		}).collect(Collectors.toList());
		
		for(String name:result) {
			System.out.println(name);
		}
	}

}
