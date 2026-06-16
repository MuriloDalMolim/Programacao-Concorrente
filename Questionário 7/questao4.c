#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

int v[10];

void *multiplicar(void * arg){
    int n = (long)arg;
    for(int i =0; i< 10; i++){
        v[i] *= n;
    };
    pthread_exit(NULL);
};

int main(){

    for(int i =0; i< 10; i++){
        scanf("%d", &v[i]);
    };

    int x;
    int y;
    scanf("%d", &x);
    scanf("%d", &y);

    pthread_t thread[2];
    pthread_create(&thread[0], NULL, multiplicar, (void*)(long)x);
    pthread_create(&thread[1], NULL, multiplicar, (void*)(long)y);

    pthread_join(thread[0], NULL);
    pthread_join(thread[1], NULL);

    for(int i =0; i< 10; i++){
        printf("%d ", v[i]);
    };
    return 0;
}