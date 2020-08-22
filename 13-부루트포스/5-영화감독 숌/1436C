#include <stdio.h>
int main(void) {
    int N;
    scanf("%d", &N);
    
    //665에서 1씩 증가하며 666있는지 확인
    //1000%ㅇㅇ666 = 666임을 이용
    int index = 0;    //666 발견하면 ++하여 몇 번째 종말의 숫자인지 세기
    int number = 665;
    while (index != N) {    //N번째 종말의 숫자를 발견할 때까지
        number++;
        int temp = number;
        
        while (temp > 665) {    //temp가 665이하면 1000으로 나눌 필요 X
            if (temp % 1000 == 666)  {
                index++;
                break;
            }
            temp /= 10;
        }
    }
    printf("%d", number);
    
    return 0;
}
