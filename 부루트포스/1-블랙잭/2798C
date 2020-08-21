#include <stdio.h>

int main(void) {
    int N, M;    //숫자 카드 갯수 N, 숫자 3개 합 마지노선 M
    int sum, max = 0;
    int nums[100] = {0, };    //3 <= N <= 100
    
    scanf("%d%d", &N, &M);
    
    //N개의 숫자 입력
    for(int i = 0; i < N; i++)
        scanf("%d", &nums[i]);
    
    //세 수의 합 모든 경우 구하기
    //세 수의 합 sum이 M과 가장 가까워 질 때마다 max 수정
    for(int i = 0; i < N; i++) {
        for(int j = i+1; j < N; j++) {
            for(int k = j+1; k < N; k++) {
                sum = nums[i] + nums[j] + nums[k];
                if(sum > max && sum <= M)
                    max = sum;
            }
        }
    }
    printf("%d\n", max);
    
    return 0;
}
