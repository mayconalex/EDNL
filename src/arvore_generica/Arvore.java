import java.util.ArrayList;
import java.util.List;

class No<T> {
	T dado;
	List<No<T>> filhos;
	
	// construtor
	public No(T dado){
		this.dado = dado;
		this.filhos = new ArrayList<>();
	}
	
	// insere um filho à direita na lista
	public void inserirFilho(No<T> filho){
		this.filhos.add(filho);
	}
	
	// identifica se o nó é uma folha
	public boolean noFolha() {
		return this.filhos.isEmpty();
	}
	
}


public class Arvore<T> {
	No<T> raiz;
	
    // Árvore vazia
    public Arvore() {
        this.raiz = null;
    }

	public Arvore(T dadoRaiz){
		this.raiz = new No<>(dadoRaiz);
	}
	
    public No<T> getRaiz() {
        return this.raiz;
    }

    public boolean isEmpty() {
        return this.raiz == null;
    }

    public void criarRaiz(No<T> raiz) {
        if (isEmpty()) {
            this.raiz = raiz;
        }
    }

    public int altura() {
        if (this.isEmpty()) {
            return -1;
        }

        return this.alturaNo(this.raiz);
    }

    private int alturaNo(No<T> no) {
        int maiorAltura = 0;

        for (No<T> filho: no.filhos) {
            int alturaFilho = alturaNo(filho);
            
            if (alturaFilho > maiorAltura) {
                maiorAltura = alturaFilho;
            }
        }

        return maiorAltura + 1;
    }

    public No<T> buscar(T dado) {
        if (this.isEmpty()) {
            throw new RuntimeException("A Árvore está vazia!");
        }

        return buscarNo(this.raiz, dado);
    }

    private No<T> buscarNo(No<T> noAtual, T dado) {
        if (noAtual.dado == dado) {
            return noAtual;
        }

        for (No<T> filho: noAtual.filhos) {
            No<T> no = buscarNo(filho, dado);
            if (no != null) {
                return no;
            }
        }

        throw new RuntimeException("Nó não encontrado.");
    }

	public void inserirNo(No<T> pai, T dadoFilho){
		if(pai != null){
			No<T> noFilho = new No<>(dadoFilho);
			pai.inserirFilho(noFilho);
		}
	}

    public void inserirNo(No<T> pai, No<T> filho) {
        if (pai != null) {
            pai.inserirFilho(filho);
        }
    }
	
	public void imprimir() {
		imprimirRecursivo(this.raiz, "");
		System.out.println("");
	}
	
	private void imprimirRecursivo(No<T> noAtual, String recuo){
		if(noAtual == null) return;
		
		System.out.println(recuo + "+- " + noAtual.dado);
		
		for(No<T> filho: noAtual.filhos){
			imprimirRecursivo(filho, recuo + " ");
		}
	
	}
}