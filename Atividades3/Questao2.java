/*
Escreva um programa Java que execute duas threads, uma para imprimir números
pares e outra para imprimir números ímpares em um intervalo. A implementação da
thread deve ser feita em apenas uma classe que recebe um valor inicial, um
valor final e a opção (par/ímpar) no método construtor.
 */

class Imprimir extends Thread {

    int nInicial;
    int nFinal;
    int opcao;

    public Imprimir(int nInicial, int nFinal, int opcao) {
        this.nInicial = nInicial;
        this.nFinal = nFinal;
        this.opcao = opcao;
    }

    public void run() {
        if (opcao == 1) {
            for (int i = nInicial; i <= nFinal; i++) {
                if (i % 2 == 0) {
                    System.out.println(getName() + ": " + i);
                }
            }
        } else {
            for (int i = nInicial; i <= nFinal; i++) {
                if (i % 2 != 0) {
                    System.out.println(getName() + ": " + i);
                }
            }
        }
    }
}

public class Questao2 {

    public static void main(String[] args) {
        Imprimir par = new Imprimir(2, 20, 1);
        Imprimir impar = new Imprimir(2, 20, 2);
        par.start();
        impar.start();

        try {
            par.join();
            impar.join();
        } catch (Exception e) {
            System.out.println("Erro no join");
        }
    }
}
