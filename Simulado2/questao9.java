/*
Escreva um programa em Java usando threads que leia um valor da entrada padrão correspondente ao x e calcule o valor da função y=sin(3x)+√cos(x).
Crie uma classe que possua três variáveis do tipo double f1, f2 e result.
O programa deverá calcular em paralelo f1 e f2 (crie duas classes thread diferentes). f1 = sin(3x) e f2 =  sqrt(cos(x)).
Após o cálculo, cada thread deve fazer a soma do valor calculado com a variável result.
Por fim, a thread principal deve apresentar o resultado imprimindo na saída padrão o valor da variável result.

Observações: O código para a leitura já está apresentado na resposta da classe main.
Utilize os métodos da classe Math para realizar o cálculo do seno, cosseno e raiz quadrada.
Não é necessário mudar o valor de x para radianos. A única classe public deve ser a main.
 */

import java.util.Scanner;

class Trigo{
    double f1;
    double f2;
    double result;

    public Trigo(int x){
        this.f1=x;
        this.f2=x;
        this.result=0;
    }

}

class Sinn extends Thread{
    Trigo x;
    public Sinn(Trigo x){
        this.x= x;
    }

    public void run(){
        x.f1 = Math.sin(3 * x.f1);
        x.result += x.f1;
    }
}

class Coss extends Thread{
    Trigo x;
    public Coss(Trigo x){
        this.x= x;
    }

    public void run(){
        x.f2 = Math.sqrt(Math.cos(x.f2));
        x.result += x.f2;
    }
}

public class questao9 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int x = ler.nextInt();

        Trigo y = new Trigo(x);
        Coss p1 = new Coss(y);
        Sinn p2 = new Sinn(y);

        p1.start();
        p2.start();

        try {
            p1.join();
            p2.join();
        } catch (Exception e){
            System.out.println("Erro no join");
        }

        System.out.println("y = "+y.result);
    }
}
