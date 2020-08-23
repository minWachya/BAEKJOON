/*
<병합 정렬>
숫자 배열을 앞/뒷부분으로 나누어 각각 정렬 후 병합

ex) 요소가 8개인 배열               앞)5 4 =정렬> 4 5
                     앞)5 4 1 2 [ 뒤)1 2 =정렬> 1 2 ]=병합> 1 2 4 5
    5 4 1 2 6 3 7 8 [                                             ]=병합> 1 2 3 4 5 6 7 8
                     뒤)6 3 7 8 [ 앞)6 3 =정렬> 3 6 ]=병합> 3 6 7 8   
                                  뒤)7 8 =정렬> 7 8   
*/

#include <stdio.h>
#include <stdlib.h>

static int *temp;    //작업용 배열

//병합 정렬(main)
static void __mergeSort(int num[], int start, int end) {
    //배열 요소가 2개 이상인 경우
    if (start < end) {
        int mid = (start + end) / 2;
        int tmpLength = 0, t = 0;        //작업용 배열의 인덱스
        int i, n = start;                //num 배열의 인덱스
        __mergeSort(num, start, mid);    //앞부분 병합 정렬
        __mergeSort(num, mid + 1, end);  //뒷부분 병합 정렬
        
        //앞부분(num 배열의 시작~중간)을 작업용 배열의 앞에서부터(temp[0]~) 복사하기
        //이제 앞부분은 num 배열과 temp 배열에 있음
        //for문이 끝난 후 tmpLength의 값 = 복사한 요소의 개수
        for (i = start; i <= mid; i++)
            temp[tmpLength++] = num[i];
        
        //앞부분(temp 배열)과 뒷부분(병합 전 num 배열의 중간~끝)을 비교하여
        //작은 것을 앞부분(num 배열)에 병합
        while (i <= end && t < tmpLength)
            num[n++] = (temp[t] <= num[i]) ? temp[t++] : num[i++];
        
        //temp 배열에 남은 요소가 있으면 num 배열로 복사하기
        while (t < tmpLength)
            num[n++] = temp[t++];
    }
}

//병합 정렬 함수
int mergeSort(int num[], int n) {
    if ((temp = calloc(n, sizeof(int))) == NULL)
        return -1;
    
    __mergeSort(num, 0, n-1);    //배열 전체를 전체 병합
    free(temp);                  //배열 해제
    
    return 0;
}

int main(void) {
    int N;
    scanf("%d", &N);
    int *num;    //배열의 첫 번째 요소에대한 포인터
    num = calloc(N, sizeof(int));    //요소가 N개인 int형 배열 만들기
    
    //숫자 입력
    for (int i = 0; i < N; i++)
        scanf("%d", &num[i]);
    
    //오름차순 정렬(병합 정렬)
    mergeSort(num, N);
    
    //출력
    for (int i = 0; i < N; i++)
        printf("%d\n", num[i]);
    
    //배열 해제
    free(num);
    return 0;
}
