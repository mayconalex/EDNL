package arvore_expressao;

import java.util.List;
import java.util.ArrayList;

public class AnalisadorExpressao {
    public List<String> tokenizar(String expressao) {
        List<String> tokens = new ArrayList<>();

        int i = 0;
        while(i < expressao.length()) {
            char atual = expressao.charAt(i);

            // É espaço
            if (Character.isWhitespace(atual)) {
                i++; continue;
            }

            // É número
            if (Character.isDigit(atual)) {
                String numero = "";
    
                while (
                    i < expressao.length() && 
                    Character.isDigit(expressao.charAt(i))) 
                {
                    numero += expressao.charAt(i);
                    i++;
                }
    
                tokens.add(numero);
                continue;
            }

            // É operador ou parêntese
            if (
                atual == '+' || 
                atual == '-' || 
                atual == '*' || 
                atual == '/' ||
                atual == '(' ||
                atual == ')'
            ) {
                tokens.add(String.valueOf(atual));
                i++; continue;
            }

            throw new RuntimeException("Caractere inválido: " + atual);
        }

        return tokens;
    }
}
