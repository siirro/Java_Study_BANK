package com.iu.start.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class Car {
	
	//Car는 Engine이 없으면 X
	//Car는 Engine에 의존적이다
	
	//1. private Engine engine = new Engine();
	
	//2.
	//Car car = new Car();
	//car.engine = new Engine;
	private Engine engine;
	private LeftWheel leftWheel;
	private RightWheel rightWheel;
	
	
	//3.
//	public Car() {
//		this.engine= new Engine();
//	}
	
	
	public Car(LeftWheel leftWheel, RightWheel rightWheel) {
		this.engine= engine;
		this.leftWheel=leftWheel;
		this.rightWheel=rightWheel;
		
	}
	
	//4.
	
	//{
	//	this.engine=new Engine();
	//}

	
	//5.
	
	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	//6.
	//Car car = new Car();
	//Engine engine = new Engine();
	//car.setEngine(engine);
	
	
}
