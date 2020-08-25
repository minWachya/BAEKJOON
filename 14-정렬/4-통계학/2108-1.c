#include <stdio.h>
#include <stdlib.h>

int count[8001] = {0, };    //최빈값을 찾기 위한 배열(count[num[i]]++)

//qsort 오름차순 정렬을 위한 함수
int compare(const void *a, const void *b) {
    if (*(int *)a > *(int *)b) return 1;
    else if (*(int *)a < *(int *)b) return -1;
    else return 0;
}

//최빈값 구하는 함수
int mostNum(int max, int min) {
    int most = 0, index = 0;   //최빈값과 그때의 인덱스
    int flag = 0;              //최빈값이 몇 개인지
    for (int i = min; i <= max; i++) {
        if (most < count[i]) {
            most = count[i];    //최빈값 수정
            flag = 0;           //최초 최빈값
            index = i;          //최초 최빈값의 인덱스
        }
        else if (most == count[i]) {
            flag++;
            //최댓값이 여러개면 두번째로 작은 값의 인덱스 저장
            if (flag == 1) index = i;
        }
    }
    
    return index - 4000;
}

int main(void) {
    int N;
    int sum = 0;
    scanf("%d", &N);
    int *num = calloc(N, sizeof(int));    //숫자를 입력할 배열
    
    //숫자 입력
    for (int i = 0; i < N; i++) {
        scanf("%d", &num[i]);
        sum += num[i];           //숫자 합 구하기
        count[num[i] + 4000]++;  //숫자 출현 빈도 구하기, 음수도 있으니 +4000(ㅣ값ㅣ<=4000)
    }
    
    //오름차순 정렬(qsort)
    qsort(num, N, sizeof(int), compare);
    
    //최빈값 구하기
    int max = num[N-1] + 4000; //num 배열의 최댓값이 저장된 count 배열의 인덱스
    int min = num[0] + 4000;   //num 배열의 최솟값이 저장된 count 배열의 인덱스
    int index = mostNum(max, min);
    
    //출력
    printf("%.0f\n", (double)sum / N);    //산술 평균
    printf("%d\n", num[N/2]);             //중앙값
    printf("%d\n", index);                //최빈값(count 배열의 인덱스 - 4000)
    printf("%d\n", num[N-1] - num[0]);    //범위(최대-최소)
    
    //배열 해제
    free(num);
    
    return 0;
}

