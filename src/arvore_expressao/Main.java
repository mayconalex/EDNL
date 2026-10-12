package arvore_expressao;

public class Main {
    public static void main(String[] args) {
        ArvoreExpressao arvore = new ArvoreExpressao();

        No no1 = new No("*");
        No no2 = new No("+");
        No no3 = new No("3");
        No no4 = new No("5");
        No no5 = new No("2");

        arvore.setRaiz(no1);

        no1.setFilhoDireito(no5);
        no1.setFilhoEsquerdo(no2);
        no2.setFilhoEsquerdo(no3);
        no2.setFilhoDireito(no4);

        System.out.println(no2.getPai().getValor());
        System.out.println(no3.getPai().getValor());
        System.out.println(arvore.estaVazia());
    }
}
