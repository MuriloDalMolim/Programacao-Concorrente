/*
Faça um classe Java chamada Share que possui uma variável do tipo int chamada cont e uma variável do tipo int chamada soma.
Essa classe possui um método adicionar que faz o incremento de uma unidade na variável cont.
Essa classe também possui o método somar que adiciona o valor de cont à variável soma.
Faça uma classe Java chamada Operacao que recebe no construtor um objeto da classe Share que será compartilhado.
No método run, os métodos adicionar e somar são executados nessa ordem
 */
import java.util.ArrayList;
import java.util.List;
class Share{
    int cont;
    int soma;

    public Share() {
        this.cont = 0;
        this.soma = 0;
    }
    public void adicionar(){
        cont++;
    }

    public void somar(){
        soma+=cont;
    }
}

class Operacao extends Thread{

    Share x;
    public Operacao(Share x){
        this.x = x;
    }

    public void run(){
        x.adicionar();
        x.somar();
    }
}

public class Questao6 {
    public static void main(String[] args) {
        Share s = new Share();
        List<Operacao> a;
        a = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
            Operacao o = new Operacao(s);
            o.start();
            a.add(o);
        }
    a.forEach(o -> {
            try {
                o.join();
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        });
    System.out.println("cont: " + s.cont);
    System.out.println("soma: " + s.soma);
    }
}