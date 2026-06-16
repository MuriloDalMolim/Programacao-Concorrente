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