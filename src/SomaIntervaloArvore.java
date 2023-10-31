class No {
    int valor;
    No esquerda;
    No direita;

    No(int x) {
        valor = x;
    }
}

public class SomaIntervaloArvore {

    public int somaIntervaloArvore(No raiz, int inicial, int finalValue) {
        return calcularSomaIntervalo(raiz, inicial, finalValue);
    }

    private int calcularSomaIntervalo(No no, int inicial, int finalValue) {
        if (no == null) {
            return 0;
        }

        int soma = 0;

        if (no.valor >= inicial && no.valor <= finalValue) {
            soma += no.valor;
        }

        if (no.valor > inicial) {
            soma += calcularSomaIntervalo(no.esquerda, inicial, finalValue);
        }

        if (no.valor < finalValue) {
            soma += calcularSomaIntervalo(no.direita, inicial, finalValue);
        }

        return soma;
    }

    public static void main(String[] args) {
        // Exemplo de uso:
        // Criando uma nova árvore
        // raiz = [8,4,12,2,6,10,14,null,null,null,null,null,null,null]
        No raiz = new No(8);
        raiz.esquerda = new No(4);
        raiz.direita = new No(12);
        raiz.esquerda.esquerda = new No(2);
        raiz.esquerda.direita = new No(6);
        raiz.direita.esquerda = new No(10);
        raiz.direita.direita = new No(14);

        SomaIntervaloArvore solution = new SomaIntervaloArvore();

        // Calculando a soma do intervalo [6, 12]
        System.out.println(solution.somaIntervaloArvore(raiz, 6, 12));  // Saída: 36
    }
}
