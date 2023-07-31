package com.in28minutes.learnspringaop.aopexample.data;

import org.springframework.stereotype.Repository;

@Repository
public class DataService2 {
	
	public int[] retrieveData() {
		return new int[] {11, 2, 33, 44, 55};
	}

}