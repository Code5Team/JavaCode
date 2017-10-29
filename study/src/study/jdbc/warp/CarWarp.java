package study.jdbc.warp;

public class CarWarp implements Car {

	private Car car;
	public CarWarp(Car car){
		this.car=car;
	}
	public void run() {
		// TODO Auto-generated method stub
		//this.car.run();
		System.out.println("改装车");
	}

	public void stop() {
		// TODO Auto-generated method stub
		this.car.stop();
	}

}
