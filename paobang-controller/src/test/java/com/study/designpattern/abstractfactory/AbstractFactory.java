package com.study.designpattern.abstractfactory;

public abstract class AbstractFactory {
	
	public abstract Human getHuman(String type);
	
	public abstract Animal getAnimal(String type);
}
