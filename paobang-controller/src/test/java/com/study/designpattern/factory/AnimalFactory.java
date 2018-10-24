package com.study.designpattern.factory;

public class AnimalFactory {
	
	public Animal getAnimal(String animalType){
		switch(animalType){
			case "cat":
				return new Cat();
			case "dog":
				return new Dog();
			default:
				return null;
		}
	}

}
