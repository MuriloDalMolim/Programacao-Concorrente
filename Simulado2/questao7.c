/*
Escreva um programa em C usando PThread que lê três número inteiros e apresenta a soma dos fatoriais. 
O cálculo do fatorial é paralelizável e cada thread recebe por parâmetro o valor que precisa para calcular o fatorial.
*/

#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

typedef struct {
    int n;
    int i;
} Fat;

Fat v[3];

long s[3] = {1,1,1};

void *fatorial(void *arg){
    Fat x = *(Fat*)arg;
    for(int i=1; i<x.n+1;i++){
        s[x.i] *= i;
    }

    pthread_exit(NULL);
};

int main(){


    for(int i;i<3;i++){
        scanf("%d", &v[i].n);
        v[i].i=i;
    }

    pthread_t thread[3];

    for(int i;i<3;i++){
        pthread_create(&thread[i], NULL, fatorial, (void*)&v[i]);
    }

    for (long  i = 0; i < 3; i++) {
        pthread_join(thread[i], NULL);
    }

    printf("Soma = %ld", s[0] + s[1] + s[2]);
    return 0;
}