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