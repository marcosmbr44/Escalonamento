package escalonamento;

import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public class TesteAlgoritmo {

    public static void main(String[] args) {

        AlgoritmosEscalonamento alg = new AlgoritmosEscalonamento();
        AlgoritmosEscalonamento alg2 = new AlgoritmosEscalonamento();
        AlgoritmosEscalonamento alg3 = new AlgoritmosEscalonamento();
        LeitorArquivo la = new LeitorArquivo();
        LeitorArquivo la2 = new LeitorArquivo();
        LeitorArquivo la3 = new LeitorArquivo();
        
        ArrayList<Processo> lp = la.leitorDeArquivo();
        ArrayList<Processo> lp2 = la2.leitorDeArquivo();
        ArrayList<Processo> lp3 = la3.leitorDeArquivo();
        
        ArrayList<Processo> listaSjf = alg.sjf(lp);
        for(Processo p : listaSjf){
            System.out.println(p.getNome() + " - Tempo necessário: " + p.getTempoNecessario() +
                    " Tempo Turnaround: " + p.getTempoTurnaround() + 
                    " Tempo de espera: " + p.getTempoEspera());
        }
        System.out.println("----------------------------------------------------------------------");
        ArrayList<Processo> listaFifo = alg.fifo(lp);
        for(Processo p : listaFifo){
            System.out.println(p.getNome() + " - Tempo necessário: " + p.getTempoNecessario() +
                    " Tempo Turnaround: " + p.getTempoTurnaround() + 
                    " Tempo de espera: " + p.getTempoEspera());
        }
        
        //TESTE PARA O MÉTODO ROUNDROBIN
        
        ArrayList<Processo> novaLista = alg.roundRobin(lp, 2);
        System.out.println(novaLista.size());
        for(Processo p : novaLista){
            System.out.println(p.getId() + ") " + p.getNome() + 
                    " Tempo necessário: " + p.getTempoNecessario() +
                    " Tempo Turnaround: " + p.getTempoTurnaround() + 
                    " Tempo de espera: " + p.getTempoEspera());
        }
        
        //TESTEPARA O MÉTODO TEMPOESPERA(RoundRobin)
       
        System.out.println("----------------------------------------------------------------");
        
        ArrayList<Processo> listaSubdividida = alg3.roundRobin(lp3, 2);
        ArrayList<Processo> listaCompleta = alg2.tempoEsperaRoundRobin(listaSubdividida, lp2);
        
        for(Processo p : listaCompleta){
            System.out.println(p.getId() + ") " + p.getNome() + 
                    " Tempo necessário: " + p.getTempoNecessario() +
                    " Tempo Turnaround: " + p.getTempoTurnaround() + 
                    " Tempo de espera: " + p.getTempoEspera());
        }
    }
}
