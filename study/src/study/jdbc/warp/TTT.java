package study.jdbc.warp;

public class TTT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car c=new QQ();
//		c.run();
//		c.stop();
		
		CarWarp carWarp = new CarWarp(c);
		carWarp.run();
		carWarp.stop();
	}

}
