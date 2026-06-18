/*
Faça duas classes Java usando Thread.
A primeira, chamada Positivo, deve receber um valor x como parâmetro no método construtor e imprimir a
mensagem "x é positivo" caso x seja um número positivo.
A segunda, chamada Par, deve receber um valor x como parâmetro no método construtor e imprimir a
mensagem "x é par" caso o valor de x seja par.

Entrada
A entrada consiste no cenário de teste apresentado abaixo como exemplo.

Saída
O programa deve mostrar a mensagem "x é par." e "x é positivo." quando for o caso.

Observação: Coloque no resultado apenas as duas classes sem o public antes do class.
 */

class Positivo extends Thread{
    int x;
    public Positivo(int x){
        this.x = x;
    }

    public void run(){
        if( x >= 0){
            System.out.println(x+" é positivo.");
        }
    }
}

class Par extends Thread{
    int x;
    public Par(int x){
        this.x = x;
    }

    public void run(){
        if( x % 2 == 0){
            System.out.println(x+" é par.");
        }
    }

}
public class Questao5 {
    public static void main(String[] args) {
        int x = 6;
        Par p1 = new Par(x);
        Positivo p2 = new Positivo(x);
        p1.start();
        p2.start();

        try {
            p1.join();
            p2.join();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
