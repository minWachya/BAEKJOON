/*
<카운팅 정렬>
요소의 대소 관계를 판단하지 않고 빠르게 정렬할 수 있는 알고리즘
ex)  인덱스 - 0 1 2 3 4 5 6 7
   배열 num - 5 3 1 3 1 3 4 2
   
1단계) countSum[i] 만들기 (i = num[i], countSum[i] = num 배열에 i가 몇 개 있는지)
ex)인덱스(num[i]) - 0 1 2 3 4 5
    배열 countSum - 0 2 1 3 1 1
    //countSum[4]=1 : num 배열에 4가 1개 있다.
    
2단계) countSum[i]를 누적합으로 수정 (countSum[i]=a : num 배열에 0~i 사이 숫자는 a개, i는 a번째 값)
ex)배열 countSum - 0 2 3 6 7 8
   //countSum[2]=3 : num 배열에 0~2 사이 숫자가 3개 있다. 즉 num 배열에서 2는 3번째 값임.
   
3단계) 결과 저장할 임시 배열(temp) 만들기 (num[i]는 countSum[num[i]]번째 값이니까
--countSum[num[i]]번째 위치인 temp[--countSum[num[i]]]에 num[i] 저장)
ex)num[7]=2 > countSum[2]=3 > 2는 3번째 값 > temp[3-1]=2
   num[6]=4 > countSum[4]=7 > 4은 7번째 값 > temp[7-1]=4

4단계) 결과 배열(temp)을 num으로 다시 복사
*/

#include <stdio.h>
#include <stdlib.h>

//카운팅 정렬 함수
void countSort(int num[], int N, int MAX) {
    //1단계) countSum[i] 만들기
    int *countSum = calloc(MAX + 1, sizeof(int));
    for (int i = 0; i <= MAX; i++) countSum[i] = 0;    //0으로 초기화
    for (int i = 0; i < N; i++) countSum[num[i]]++;    //num 배열에 num[i]가 몇 개 있는지?
    
    
    //2단계) countSum[i]를 누적합으로 수정
    for (int i = 1; i <= MAX; i++) countSum[i] += countSum[i-1];
    
    //3단계) 결과 저장할 임시 배열(temp) 만들기
    int *temp = calloc(N, sizeof(int)); 
    //num[i]는 countSum[num[i]]번째 값이니까 --countSum[num[i]]번째 위치에 num[i] 저장
    for (int i = N - 1; i >= 0; i--) temp[--countSum[num[i]]] = num[i];
    
    //4단계) 결과 배열(temp)을 num으로 다시 복사
    for (int i = 0; i < N; i++) num[i] = temp[i];
    
    free(countSum);
    free(temp);
}

int main(void) {
    const int MAX = 10000;    //배열의 요솟값 <= 10000
    int N;
    scanf("%d", &N);
    int *num = calloc(N, sizeof(int));
    
    //숫자 입력
    for (int i = 0; i < N; i++) scanf("%d", &num[i]);
    
    //오름차순 정렬(카운팅 정렬)
    countSort(num, N, MAX);
    
    //출력
    for (int i = 0; i < N; i++) printf("%d\n", num[i]);
    
    //배열 해제
    free(num);
    
    return 0;
}
