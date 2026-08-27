public class Main {
	public static void main(String[] args) {
		Arvore<String> arvore = new Arvore<>();
        No<String> no_a = new No<>("A");
        arvore.criarRaiz(no_a);
		
        No<String> no_b = new No<>("B");
        No<String> no_c = new No<>("C");
        No<String> no_d = new No<>("D");
        No<String> no_e = new No<>("E");

		arvore.inserirNo(no_a, no_b);
		arvore.inserirNo(no_a, no_c);
		arvore.inserirNo(no_b, no_d);
		arvore.inserirNo(no_b, no_e);
		
		arvore.imprimir();

        System.out.println("Altura: " + arvore.altura());
	}
}