#include <stdio.h>

#define MAX 10001

int num[MAX] = {0, }; 

int main(void) {
    int N, temp;
    scanf("%d", &N);
    
    //숫자 입력(숫자 입력할 때마다 num[입력한 숫자]++)
    for (int i = 0; i < N; i++) {
        scanf("%d", &temp);
        num[temp]++;
    }
    
    //출력
    for (int i = 0; i < MAX; i++) {
        if (num[i] == 0) continue;
        
        for (int j = 0; j < num[i]; j++)
            printf("%d\n", i); 
    }
    
    return 0;
}
