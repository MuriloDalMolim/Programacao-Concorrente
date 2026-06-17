/*
Crie a função chamada fatorial em C usando PThreads que receba um número e calcule o fatorial.  
O resultado deve ser salvo em uma variável compartilhada. Na função main o programa deve ler da entrada padrão três números inteiros. 
Crie 3 threads passando um valor para cada thread. Após as threads completarem o cálculo, apresente a soma dos fatoriais.
*/

#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
 
typedef struct {
    int n;
    int i;
} Fat;
Fat v[3];

long r[3] = {1,1,1};

void *fatorial(void *arg){
    Fat x = *(Fat*)arg;
    while(x.n>0){
        r[x.i] *= x.n;
        x.n--;
    }

    pthread_exit(NULL);
};

int main(){

    for(int i =0; i< 3; i++){
        scanf("%d", &v[i].n);
        v[i].i=i;
    };


    pthread_t thread[3];
    for(long i = 0;i<3; i++){
        pthread_create(&thread[i], NULL, fatorial, (void*)&v[i]);
    };

    for (long  i = 0; i < 3; i++) {
        pthread_join(thread[i], NULL);
    }

    printf("%ld", r[0]+r[1]+r[2]);

    return 0;
}