/*
Faça um programa em C usando Pthread que cria três threads. 
Cada thread deve imprimir na saída padrão a mensagem "Hello from thread". 
Após a execução das 3 threads, o programa deve imprimir na saída padrão a mensagem "Hello from the main thread".
*/

#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
 
void * printThread(){
    printf("Hello from thread\n");

    return NULL;  
}

int main() {

    pthread_t thread[3];

    for(long i = 0;i<3; i++){
        pthread_create(&thread[i], NULL, printThread, (void*)i);
    };

    for (long  i = 0; i < 3; i++) {
        pthread_join(thread[i], NULL);
    }
        
    printf("Hello from the main thread");
    return 0;
}