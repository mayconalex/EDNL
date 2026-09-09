import java.util.List;
import java.util.ArrayList;

public class No<Tipo> {
    Tipo dado;
    List<No<Tipo>> filhos;

    // Construtor
    public No(Tipo dado) {
        this.dado = dado;
        this.filhos = new ArrayList<>();
    }

    public void inserirFilho(No<Tipo> filho) {
        this.filhos.add(filho);
    }

    // Verifica se é um nó folha
    public boolean isExternal() {
        return this.filhos.isEmpty(); // método de List
    }
}