/*
 Escreva um programa Java que crie duas threads, uma que escreva uma frase em uma
variável compartilhada e outra que imprima o valor dessa variável após a escrita. A variável
deve estar em um objeto compartilhado. Trate o acesso de escrita e leitura na variável
compartilhada e impeça a leitura antes da escrita
 */

class Dado {

    String mensagem = null;

    public synchronized void escritor() {
        System.out.println("Escritor escrevendo...");
        mensagem = "Oi, tudo bem?";
        notify();
        System.out.println("Fim da escrita");
    }

    public synchronized void leitor() {
        try {
            while (mensagem == null) {
                System.out.println("Leitor esperando...");
                wait();
            }
        } catch (Exception e) {
            System.out.println("Problema no wait");
        }
        System.out.println("Leitor lendo...");
        System.out.println(mensagem);
        System.out.println("Fim da leitura...");
    }
}

class Escritor extends Thread {

    private Dado objcomp;

    public Escritor(Dado objcomp) {
        this.objcomp = objcomp;
    }

    public void run() {
        objcomp.escritor();
    }
}

class Leitor extends Thread {

    private Dado objcomp;

    public Leitor(Dado objcomp) {
        this.objcomp = objcomp;
    }

    public void run() {
        objcomp.leitor();
    }
}

public class Questao4 {

    public static void main(String[] args) {

        Dado objcomp = new Dado();
        Escritor t1 = new Escritor(objcomp);
        Leitor t2 = new Leitor(objcomp);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            System.out.println("Erro no join");
        }
    }
}
