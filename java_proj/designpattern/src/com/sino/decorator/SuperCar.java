package com.sino.decorator;

public class SuperCar implements ICar {

		private ICar car;
		public SuperCar(ICar car){
			this.car = car;
		}
		@Override
		public void move() {
			
		}
	}
