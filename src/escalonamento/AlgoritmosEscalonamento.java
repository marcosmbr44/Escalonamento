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
    
    public ArrayList<Processo> tempoEsperaRoundRobin(ArrayList<Processo> listaSubdividida, ArrayList<Processo> listaOriginal) {
        ArrayList<Processo> listaCompleta = new ArrayList<>();
        
        for(Processo p : listaOriginal){//B
            int tempoProcesso = p.getTempoNecessario();//B = 10
            String nome = p.getNome();//B
            int contadorTempo = 0;
            int somaTempo = 0;
            for(Processo p3 : listaSubdividida){//A
                if(!nome.equals(p3.getNome())){//B -- A
                    somaTempo = somaTempo + p3.getTempoNecessario();//2
                }else{
                    contadorTempo = contadorTempo + p3.getTempoNecessario();//2
                }
                if(contadorTempo == tempoProcesso){//2 -- 5
                    break;
                }
            }
            p.setTempoEspera(somaTempo);
            p.setTempoTurnaround(somaTempo + tempoProcesso);
            listaCompleta.add(p);
        } 
        return listaCompleta;
    }
     
    public ArrayList<Processo> roundRobin(ArrayList<Processo> p, int quantum) {
        ArrayList<Processo> listaFatiada = new ArrayList<>();
        for (Processo p1 : p) {
            int id = 1;
            if (p1.getTempoNecessario() >= quantum) {//10 - q=2
                while (p1.getTempoNecessario() > quantum) {
                    int sobra = subdividirProcesso(p1, quantum);//8
                    int retirado = quantum;//2
                    if (sobra <= retirado && sobra != 0) {//8 -- 2
                        p1.setTempoNecessario(sobra);
                        String nome = p1.getNome();

                        listaFatiada.add(new Processo(id, nome, retirado));
                        id++;
                        listaFatiada.add(new Processo(id, nome, sobra));
                    } else {
                        p1.setId(id);
                        p1.setTempoNecessario(sobra);
                        String nome = p1.getNome();
                        int tempo = p1.getTempoNecessario();
                        listaFatiada.add(new Processo(id, nome, quantum));
                    }
                    id++;
                }
            } else {
                p1.setId(id);
                listaFatiada.add(p1);
                id++;
            }
        }
        Collections.sort(listaFatiada);
        return listaFatiada;
    }

    private int subdividirProcesso(Processo p, int quantum) {
        int valor = p.getTempoNecessario() - quantum;
        return valor;
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
