package escalonamento;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author gabriel
 */
public class AlgoritmosEscalonamento implements Comparator<Processo> {

    public ArrayList<Processo> fifo(ArrayList<Processo> p) {
        ArrayList<Processo> listaFifo = new ArrayList<>();

        int tempoEspera = 0;
        for (Processo p1 : p) {
            p1.setTempoEspera(tempoEspera);//5
            tempoEspera = tempoEspera + p1.getTempoNecessario();//12
            p1.setTempoTurnaround(tempoEspera);//17
            listaFifo.add(p1);
        }
        return listaFifo;
    }

    public ArrayList<Processo> sjf(ArrayList<Processo> p) {//5,12,6,9,1
        ArrayList<Processo> listaSjf = new ArrayList<>();
        Collections.sort(p, new AlgoritmosEscalonamento());//1,5,6,
        int tempoEspera = 0;
        for (Processo p1 : p) {
            p1.setTempoEspera(tempoEspera);
            tempoEspera = tempoEspera + p1.getTempoNecessario();
            p1.setTempoTurnaround(tempoEspera);
            listaSjf.add(p1);
        }
        Collections.sort(listaSjf, new AlgoritmosEscalonamento());
        return listaSjf;
    }

    @Override
    public int compare(Processo p1, Processo p2) {
        if (p1.getTempoNecessario() < p2.getTempoNecessario()) {
            return -1;
        }
        if (p1.getTempoNecessario() > p2.getTempoNecessario()) {
            return 1;
        }
        return 0;
    }
}
