public class Arvore<Tipo> {
	No<Tipo> raiz;
	
    // Árvore vazia
    public Arvore() {
        this.raiz = null;
    }

	public Arvore(Tipo dadoRaiz){
		this.raiz = new No<>(dadoRaiz);
	}
	
    public No<Tipo> getRaiz() {
        return this.raiz;
    }

    public boolean isEmpty() {
        return this.raiz == null;
    }

    public void criarRaiz(No<Tipo> raiz) {
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

    private int alturaNo(No<Tipo> no) {
        int maiorAltura = 0;

        for (No<Tipo> filho: no.filhos) {
            int alturaFilho = alturaNo(filho);
            
            if (alturaFilho > maiorAltura) {
                maiorAltura = alturaFilho;
            }
        }

        return maiorAltura + 1;
    }

    public No<Tipo> buscar(Tipo dado) {
        if (this.isEmpty()) {
            throw new RuntimeException("A Árvore está vazia!");
        }

        return buscarNo(this.raiz, dado);
    }

    private No<Tipo> buscarNo(No<Tipo> noAtual, Tipo dado) {
        if (noAtual.dado == dado) {
            return noAtual;
        }

        for (No<Tipo> filho: noAtual.filhos) {
            No<Tipo> no = buscarNo(filho, dado);
            if (no != null) {
                return no;
            }
        }

        throw new RuntimeException("Nó não encontrado.");
    }

	public void inserirNo(No<Tipo> pai, Tipo dadoFilho){
		if(pai != null){
			No<Tipo> noFilho = new No<>(dadoFilho);
			pai.inserirFilho(noFilho);
		}
	}

    public void inserirNo(No<Tipo> pai, No<Tipo> filho) {
        if (pai != null) {
            pai.inserirFilho(filho);
        }
    }
	
	public void imprimir() {
		imprimirRecursivo(this.raiz, "");
		System.out.println("");
	}
	
	private void imprimirRecursivo(No<Tipo> noAtual, String recuo){
		if(noAtual == null) return;
		
		System.out.println(recuo + "+- " + noAtual.dado);
		
		for(No<Tipo> filho: noAtual.filhos){
			imprimirRecursivo(filho, recuo + " ");
		}
	
	}
}