//도움 : https://youtu.be/QAyl79dCO_k

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

static int mergeStart(int num[], int N);                 //병합 정렬 시작
static void mergeSort(int num[], int start, int end);    //병합 정렬하기
static void merge(int num[], int start, int end);        //앞부분과 뒷부분 병합하는 함수

static int *temp;        //작업용 배열

int main(void){
    int N;
    scanf("%d", &N);
    int *num;        //배열의 첫 번째 요소에 대한 포인터
    num = calloc(N, sizeof(int));        //요소가 N개인 int 형 배열
    
    //숫자 입력
    for (int i = 0; i < N; i++)
        scanf("%d", &num[i]);
    
    //오름차순 정렬(병합 정렬)
    mergeStart(num, N);
    
    //출력
    for (int i = 0; i < N; i++)
        printf("%d\n", num[i]);
    
    //배열 해제
    free(num);
    
    return 0;
}

static int mergeStart(int num[], int N) {
    temp = calloc(N, sizeof(int));    //요소가 N개인 int형 배열 생성
    
    mergeSort(num, 0, N-1);           //배열 전체를 병합 정렬
    free(temp);                       //배열 해제
    
    return 0;
}

//병합 정렬
static void mergeSort(int num[], int start, int end) {
    //배열 요소가 2개 이상인 경우
    if (start < end) {
        int mid = (start + end) / 2;
        mergeSort(num, start, mid);    //앞부분 병합 정렬
        mergeSort(num, mid + 1, end);   //뒷부분 병합 정렬
        merge(num, start, end);        //앞부분과 뒷부분 병합
    }
}

static void merge(int num[], int start, int end) {
    int mid = (start + end) / 2;
    
    //temp에 num 배열 저장
    for (int i = start; i <= end; i++)
        temp[i] = num[i];
    
    int part1 = start;    //앞부분 배열의 시작 인덱스
    int part2 = mid + 1;  //뒷부분 배열의 시작 인덱스
    int index = start;    //최종 결과를 배열에 저장할 인덱스
    
    //오름차순으로 정렬하기(병합 정렬)
    while (part1 <= mid && part2 <= end) {
        //앞부분 요소가 뒷부분 요소보다 작으면 결과 배열에 앞부분 요소 저장
        if (temp[part1] <= temp[part2])
            num[index++] = temp[part1++];
        //뒷부분 요소가 더 작으면 결과 배열에 뒷부분 요소 저장
        else
            num[index++] = temp[part2++];
    }
    
    //앞부분 배열의 요소가 남았을 경우
    for (int i = 0; i <= mid - part1; i++)
        num[index + i] = temp[part1 + i];
}
