package arvore_expressao;

public class No {
    private String valor;
    private No filhoEsquerdo;
    private No filhoDireito;
    private No noPai;

    public No(String valor) {
        this.valor = valor;
        this.filhoEsquerdo = null;
        this.filhoDireito = null;
        this.noPai = null;
    }

    public boolean noFolha() {
        return this.filhoEsquerdo == null && this.filhoDireito == null;
    }

    // Getters
    public String getValor() {
        return this.valor;
    }

    public No getFilhoEsquerdo() {
        return this.filhoEsquerdo;
    }

    public No getFilhoDireito() {
        return this.filhoDireito;
    }

    public No getPai() {
        return this.noPai;
    }

    // Setters
    public void setFilhoEsquerdo(No no) {
        this.filhoEsquerdo = no;

        if (no != null) {
            no.noPai = this; // O pai do nó passado será o nó atual (this)
        }
    }

    public void setFilhoDireito(No no) {
        this.filhoDireito = no;

        if (no != null) {
            no.noPai = this;  // O pai do nó passado será o nó atual (this)
        }
    }
}