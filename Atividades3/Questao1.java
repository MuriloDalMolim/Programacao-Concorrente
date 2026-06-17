/*
Faça um programa em Java usando threads que cria duas threads, cada uma exibindo seu
próprio nome. Faça duas versões do código, uma usando herança da classe Thread e outra
implementado a interface Runnable.
 */

class ThreadName extends Thread {

    public void run() {
        System.out.println(this.getName());
    }
}

class RunName implements Runnable {

    String name;

    public RunName(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println(name);
    }
}

public class Questao1 {

    public static void main(String[] args) {
        ThreadName t1 = new ThreadName();
        t1.setName("Thread 1");

        RunName r1 = new RunName("Thread 2");
        Thread t2 = new Thread(r1);

        Thread t3 = new Thread(new RunName("Thread 3"));

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (Exception e) {
            System.out.println("Erro no join");
        }
    }
}
