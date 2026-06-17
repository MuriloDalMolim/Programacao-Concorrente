/*
Escreva um programa Java que crie três threads e faça com que elas compartilhem uma
variável comum. A primeira thread deve incrementar a variável dez vezes, a segunda deve
decrementá-la dez vezes e a terceira deve exibir o valor final da variável. A variável
compartilhada e o código das operações de incrementar, decrementar e imprimir devem
estar no método run de uma única classe.
 */

class Operacao extends Thread {

    static volatile int shared = 0;
    private int flag;

    public Operacao(int flag) {
        this.flag = flag;
    }

    public void run() {
        switch (flag) {
            case 1:
                for (int i = 0; i < 10; i++) {
                    synchronized (Operacao.class) {
                        shared += 1;
                    }
                }
                break;
            case 2:
                for (int i = 0; i < 10; i++) {
                    synchronized (Operacao.class) {
                        shared -= 1;
                    }
                }
                break;
            default:
                System.out.println("Valor final da variavel: " + shared);
        }
    }
}

public class Questao3 {

    public static void main(String[] args) {
        Operacao t1 = new Operacao(1);
        Operacao t2 = new Operacao(2);
        Operacao t3 = new Operacao(3);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            System.out.println("Erro no join");
        }

        t3.start();
        try {
            t3.join();
        } catch (Exception e) {
            System.out.println("Erro no join");
        }
    }
}
