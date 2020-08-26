#include <stdio.h>

int main(void) {
    int N;
    int num[10] = {0, };    //N의 자릿수 = num 배열의 인덱스 - 1, N <= 1,000,000,000 (최대 10자리 수)
    scanf("%d", &N);
    
    //num 배열에 i - 1의 자리 수 저장
    int temp = N, t, count = 0;
    for (int i = 0; temp > 0; i++) {
        t = temp % 10;    //i - 1의 자리 수
        num[i] = t;
        temp /= 10;
        count++;
    }
    
    //내림차순 정렬
    for (int i = 0; i < count; i++) {
        for (int j = 0; j < count; j++) {
            if (num[i] > num[j]) {
                int tmp = num[i];
                num[i] = num[j];
                num[j] = tmp;
            }
        }
    }
    
    //출력
    for (int i = 0; i < count; i++)
        printf("%d", num[i]);
    
    return 0;
}
