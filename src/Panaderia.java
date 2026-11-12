import java.util.ArrayList;
import java.util.List;

public class Panaderia implements Observable {

    private boolean hayPan = false;

    private List<Vecino> vecinos = new ArrayList<>();

    @Override
    public void suscribir(Vecino v) {
        vecinos.add(v);
    }

    @Override
    public void desuscribir(Vecino v) {
        vecinos.remove(v);
    }

    @Override
    public void notificar(String mensaje) {
        for (Vecino v : vecinos) {
            v.actualizar(mensaje);
        }
    }

    public void sacarPan() {
        hayPan = true;
        System.out.println("Salio el pan caliente");

        notificar("Ya salio el pan caliente");
    }

    public boolean hayPan() {
        return hayPan;
    }
}