package ejercicio_thread_ddr_4;

import java.util.Observable;
import java.util.logging.Logger;

public class Puertas extends Observable implements Runnable {

    private String nombre;
    private int vendidos;
    int capacidad;
    private int index;
    int numAleatorio;
    int num;
   

    public Puertas(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void run() {

        int porcentaje = 0, porcentaje2 = 0, porcentaje3 = 0;

        try {
            while (porcentaje < 1000) {
                numAleatorio = generaNumeroAleatorio(20, 20);
                System.out.println("Puerta " + nombre + " ha dejado entrar a " + numAleatorio + " personas");
                porcentaje += numAleatorio;
                System.out.println("porcentaje "+porcentaje);
                this.setChanged();
                this.notifyObservers(porcentaje);
                this.clearChanged();

                Thread.sleep(100);

            }
        } catch (InterruptedException ex) {
            System.out.println("Hilo interrumpido");
        }

    }

    public int generaNumeroAleatorio(int minimo, int maximo) {
        num = (int) Math.floor(Math.random() * (maximo - minimo + 1) + (minimo));
        return num;
    }

}
