/*
Faça um programa que leia um valor inteiro x e que contenha duas funções: 
a primeira deve verificar se o número é positivo e imprimir uma mensagem na tela 
e a outra função deve verificar se o número for par e imprimir uma mensagem na tela. 
No fluxo principal, crie uma thread para executar cada uma das funções, passando como parâmetro o valor lido x. 
A função para verificação de positivo deve imprimir a mensagem “x is positive” se o valor recebido for positivo e, caso contrário, 
finalizar a thread (utilize a função pthread_exit). 
A função para verificação de par deve imprimir a mensagem “x is even” se o valor recebido for par e, caso contrário, finalizar a thread.
*/
 
#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

void * isPositive(void * arg){
    int x = (long)arg;
    if(x > 0){
        printf("%d is positive.\n", x);
    }
    pthread_exit(NULL);
};

void * isEven(void * arg){
    int x = (long)arg;
    if(x % 2 == 0){
        printf("%d is even.\n", x);
    }
    pthread_exit(NULL);
};

int main(){

    int x;
    scanf("%d", &x);

    pthread_t thread[2];

    pthread_create(&thread[0], NULL, isPositive, (void*)(long)x);
    pthread_create(&thread[1], NULL, isEven, (void*)(long)x);

    pthread_join(thread[0], NULL);
    pthread_join(thread[1], NULL);

    return 0;
}