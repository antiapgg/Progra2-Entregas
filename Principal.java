package Ejercicio3;

public class Principal {

	public static void main(String[] args) {
		Ascensor ascensor = new Ascensor(); 
		Persoa [] usuarios = new Persoa[30];
		
		for (int i = 0; i < usuarios.length; i++) {
			usuarios[i] = new Persoa(i, Math.abs((int)((Math.random()*120)+45)), ascensor); 
		}
		
		for (int i = 0; i < usuarios.length; i++) {
			usuarios[i].start();
		}
		for (int i = 0; i < usuarios.length; i++) {
			try {
				usuarios[i].join();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}
}
