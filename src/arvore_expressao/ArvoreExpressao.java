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

    public void preOrdem() {
        // método que será usado no Main (público)
        preOrdem(this.raiz);
    }

    private void preOrdem(No no) {
        // TODO: método que conterá a lógica de pré-ordem
    }

    public void emOrdem() {
        // método que será usado no Main (público)
        emOrdem(this.raiz);
    }

    private void emOrdem(No no) {
        // TODO: método que conterá a lógica de em-ordem
    }

    public void posOrdem() {
        // método que será usado no Main (público)
        posOrdem(this.raiz);
    }

    private void posOrdem(No no) {
        // TODO: método que conterá a lógica de pós-ordem
    }
}