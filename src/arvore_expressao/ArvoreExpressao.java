package arvore_expressao;

public class ArvoreExpressao {
    private No raiz;

    public ArvoreExpressao() {
        this.raiz = null;
    }

    public boolean arvoreVazia() {
        return this.raiz == null;
    }

    public No getRaiz() {
        return this.raiz;
    }
}