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