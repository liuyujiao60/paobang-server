package com.study.designpattern.factory;

public class Test {
	public static void main(String[] args) {
		Animal cat=new AnimalFactory().getAnimal("cat");
		cat.call();
		Animal dog=new AnimalFactory().getAnimal("dog");
		dog.call();
	}
}
