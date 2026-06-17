/*
Faça um programa que leia um valor de dupla precisão (double) x e calcule o valor da função y=sin(3x)+√cos(x) . 
O programa deverá conter duas funções: uma para calcular f1 = sin(3x) e a outra para calcular f2 = √cos(x) . C
ada função deverá receber o valor de x como parâmetro e será executada por uma thread diferente. 
Use variáveis globais (somente leitura) para salvar os valores de f1 e f2. 
Após fazer a união das duas threads, a thread principal (main) deverá calcular o valor final y = f1 + f2 e imprimir o resultado na tela.

Entrada:

A entrada consiste em um valor de dupla precisão x que corresponde ao valor x nas fórmulas.

Saída:

A saída consiste no valor de y resultante da fórmula
*/

#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <math.h>

double f1; 
double f2;

void *calculaF1(void * arg){
    double x = *(double*)arg;
    f1 = sin(3*x);
    pthread_exit(NULL);
};

void *calculaF2(void * arg){
    double x = *(double*)arg;
    f2 = sqrt(cos(x));
    pthread_exit(NULL);
};

int main(){

    double x;
    double y;

    scanf("%lf", &x);

    pthread_t thread[2];

    pthread_create(&thread[0], NULL, calculaF1, (void*)&x);
    pthread_create(&thread[1], NULL, calculaF2, (void*)&x);

    pthread_join(thread[0], NULL);
    pthread_join(thread[1], NULL);

    y = f1 + f2;
    printf("y = %.2lf", y);

    return 0;
}