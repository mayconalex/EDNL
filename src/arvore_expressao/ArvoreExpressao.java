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
        // Caso base
        if (no == null) return;

        // Raiz > Esquerda > Direita
        System.out.print(no.getValor() + " ");
        preOrdem(no.getFilhoEsquerdo());
        preOrdem(no.getFilhoDireito());
    }

    public void emOrdem() {
        // método que será usado no Main (público)
        emOrdem(this.raiz);
    }

    private void emOrdem(No no) {
        // Caso base
        if (no == null) return;

        // Esquerda > Raiz > Direita
        emOrdem(no.getFilhoEsquerdo());
        System.out.print(no.getValor() + " ");
        emOrdem(no.getFilhoDireito());
    }

    public void posOrdem() {
        // método que será usado no Main (público)
        posOrdem(this.raiz);
    }

    private void posOrdem(No no) {
        // Caso base
        if (no == null) return;

        // Esquerda > Direita > Raiz
        posOrdem(no.getFilhoEsquerdo());
        posOrdem(no.getFilhoDireito());
        System.out.print(no.getValor() + " ");
    }

    public void imprimir() {
        imprimir(this.raiz, "");
    }

    private void imprimir(No no, String recuo) {
        // Caso base
        if (no == null) return;

        System.out.println(recuo + "+- " + no.getValor());

        imprimir(no.getFilhoEsquerdo(), recuo + "   ");
        imprimir(no.getFilhoDireito(), recuo + "   ");
    }

    public int avaliar() {
        if (estaVazia()) {
            throw new RuntimeException("A Árvore está vazia!");
        }

        return avaliar(this.raiz);
    }

    private int avaliar(No no) {
        if (no.noFolha()) {
            return Integer.parseInt(no.getValor());
        }

        int elem_esq = avaliar(no.getFilhoEsquerdo());
        int elem_dir = avaliar(no.getFilhoDireito());

        switch (no.getValor()) {
            case "+":
                return elem_esq + elem_dir;
            case "-":
                return elem_esq - elem_dir;
            case "*":
                return elem_esq * elem_dir;
            case "/":
                return elem_esq / elem_dir;
            default:
                throw new RuntimeException("Operador desconhecido!");
        }
    }
}