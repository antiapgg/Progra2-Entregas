package Ejercicio3;

public class Ascensor {
	
	final int MAX_PERSOAS = 6;
	final int MAX_PESO = 450;
	int totalPersoas = 0;
	int totalPeso = 0;

	synchronized public void subePersoa(int peso, int id) {
		if (totalPersoas == MAX_PERSOAS || (totalPeso + peso) >= MAX_PESO) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			totalPersoas++;
			totalPeso += peso;
		System.out.println("Sube a persoa " + id +" de " + peso +"kg. Nº persoas " + totalPersoas + ", peso total: " +  totalPeso);
		}
		
		
	}

	synchronized public void baixaPersoa(int peso, int id) throws InterruptedException {
		if (totalPersoas == 0 || (totalPeso - peso) <= 0) {
			wait();
		} else {
			totalPersoas--;
			totalPeso -= peso;
			notifyAll();
				System.out.println("Baixa a persoa " + id +" de " + peso +"kg. Nº persoas " + totalPersoas + ", peso total: " +  totalPeso);
		}
	
	}
}
