package escalonamento;

/**
 *
 * @author gabriel
 */
public class Processo implements Comparable<Processo> {
    private int id;
    private String nome;//representa o nome do processo
    private int tempoNecessario;// representaa duração do processo
    private int tempoTurnaround;//representa o tempo restante que o processo precisa para terminar
    private int tempoEspera;//representa o tempoque o processo fica ocioso
    private String status;

    public Processo(){
        this.status = "Parado";
    }

    public Processo(int id, String nome,  int tempoNecessario) {
        this.id = id;
        this.nome = nome;
        this.tempoNecessario = tempoNecessario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the tempoTurnaround
     */
    public int getTempoTurnaround() {
        return tempoTurnaround;
    }

    /**
     * @param tempoTurnaround the tempoTurnaround to set
     */
    public void setTempoTurnaround(int tempoTurnaround) {
        this.tempoTurnaround = tempoTurnaround;
    }

    /**
     * @return the tempoNecessario
     */
    public int getTempoNecessario() {
        return tempoNecessario;
    }

    /**
     * @param tempoNecessario the tempoNecessario to set
     */
    public void setTempoNecessario(int tempoNecessario) {
        this.tempoNecessario = tempoNecessario;
    }

    /**
     * @return the tempoEspera
     */
    public int getTempoEspera() {
        return tempoEspera;
    }

    /**
     * @param tempoEspera the tempoEspera to set
     */
    public void setTempoEspera(int tempoEspera) {
        this.tempoEspera = tempoEspera;
    }

    @Override
    public int compareTo(Processo p) {
        if(this.getId() < p.getId()){
            return -1;
        }
        if(this.getId() > p.getId()){
            return 1;
        }
        return 0;
    }
    
    
}
