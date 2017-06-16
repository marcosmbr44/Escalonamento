package escalonamento;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author gabriel
 */

public class LeitorArquivo {
    
    private ArrayList<Processo> processos  = new ArrayList<>();
    private String[] letraProcesso = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    //private File arquivo = new File("C:\\Users\\pmrn\\Documents\\NetBeansProjects\\AlgoritmosEscalonamento\\src\\java\\escalonamento\\processos.txt");
    private File arquivo = new File("C:\\Users\\Gabriel\\Documents\\NetBeansProjects\\Escalonadores\\src\\escalonamento\\processos.txt");

    public ArrayList leitorDeArquivo(){
        try{        
            FileReader leitor = new FileReader(arquivo);
            BufferedReader buffer = new BufferedReader(leitor);
            
            String linha = null;
            int contador = 0;
            
            while((linha = buffer.readLine()) != null){
                Processo p = new Processo();
                p.setNome(letraProcesso[contador]);
                p.setTempoNecessario(Integer.parseInt(linha));
                contador++;                
                processos.add(p);
            }
            buffer.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
        return processos;
    }
}
