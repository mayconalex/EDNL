package arvore_expressao;

public class ArvoreExpressao {
    private No raiz;

    public ArvoreExpressao() {
        this.raiz = null;
    }

    public boolean estaVazia() {
        return this.raiz == null;
    }

    public No getRaiz() {
        return this.raiz;
    }

    public void setRaiz(No no) {
        if (!estaVazia()) {
            throw new RuntimeException("A Árvore já possui raiz!");
        }
        
        this.raiz = no;
    }
}