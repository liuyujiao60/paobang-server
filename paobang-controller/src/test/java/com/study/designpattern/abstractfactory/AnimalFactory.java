package com.study.designpattern.abstractfactory;


public class AnimalFactory extends AbstractFactory {

	@Override
	public Human getHuman(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Animal getAnimal(String type) {
		// TODO Auto-generated method stub
		switch(type){
			case "cat":
				return new Cat();
			case "dog":
				return new Dog();
			default:
				return null;
		}
	}

}
