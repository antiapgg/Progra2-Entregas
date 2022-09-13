package Ejercicio3;



public class Persoa extends Thread{
	
	private int peso;
	private int id;
	Ascensor ascensor;
	
		
	public Persoa(int id, int peso, Ascensor ascensor) {
		this.id= id;
		this.peso = peso;
		this.ascensor= ascensor;
	}

	public void run(){
		
		ascensor.subePersoa(peso, id);
		
		try {
			sleep((int)(Math.random())*10000);
		
			ascensor.baixaPersoa(peso,id);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
