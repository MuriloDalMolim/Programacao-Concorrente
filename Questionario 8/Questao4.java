/*
 Faça um programa usando Java Threads que cria três threads.
 Cada thread deve imprimir na saída padrão a mensagem "Hello from thread".
 Após a execução das 3 threads, o programa deve imprimir na saída padrão a mensagem "Hello from main thread".
Atenção! A classe que contém o método main deve ser public e a classe thread não deve ser public.
 */
class PrintThread extends  Thread{
    public void run(){
        System.out.println("Hello from thread");
    }
}

class RunName implements Runnable{
    public void run() {
        System.out.println("Hello from thread");
    }
}
public class Questao4 {
    public static void main(String[] args) {

        PrintThread t1 = new PrintThread();

        RunName r2 = new RunName();
        Thread t2 = new Thread(r2);

        PrintThread t3 = new PrintThread();

        t1.start();
        t2.start();
        t3.start();

        try{
            t1.join();
            t2.join();
            t3.join();
        } catch (Exception e){
            System.out.println("Erro no join");
        }

        System.out.println("Hello from main thread");
    }
}
