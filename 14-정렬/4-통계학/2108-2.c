#include <stdio.h>

#define MAX 8001

double average(int count[], int N);    //산술 평균
int mid(int count[], int N);          //중앙값
int mostNum(int count[], int N);      //최빈값
int range(int count[], int N);        //범위

int main(void) {
    int N, num;
    scanf("%d", &N);
    int count[MAX] = {0, };    //count[입력한 숫자 + 4000] = 입력한 숫자의 중복된 갯수
                                //ex)count[4004] = 2 : count[4 + 4000] = 2 : 4가 2번 입력됨.
    //입력
    for (int i = 0; i < N; i++) {
        scanf("%d", &num);
        count[num + 4000]++;
    }
    
    //출력
    printf("%.0f\n", average(count, N));        //산술 평균
    printf("%d\n", mid(count, N));              //중앙값
    printf("%d\n", mostNum(count, N));          //최빈값
    printf("%d\n", range(count, N));            //범위
    
    return 0;
}

//산술 평균
//count[i]가 0이 아닌 것들만 더하고, N개 더하면 빠져나가기
double average(int count[], int N) {
    int sum = 0;
    for (int i = 0; i < MAX; i++) {
        if (count[i] != 0)
            sum += count[i] * (i - 4000);
    }
    
    return (double)sum / N;
}
    
//중앙값
//입력된 값 = count배열의 인덱스 - 4000, count배열에 오름차순대로 저장됨
int mid(int count[], int N) {
    int i, cnt = 0;
    for (i = 0; i < MAX; i++) {
        //count 배열 안에는 입력한 숫자 - 4000가 얼마나 있는지가 들어있음
        //오름차순대로 숫자를 몇 개 입력했는지 누적하여 더하기
        cnt += count[i];
        
        //누적하여 더한 숫자가 중앙값 인덱스(N/2)를 넘으면 빠져나오기
        if (cnt > N / 2) break;
    }
    
    return i - 4000;
}

//최빈값
int mostNum(int count[], int N) {
    int most = 0, result = 0;    //최빈값
    
    //최빈값 구하기
    int i, j;
    for (i = 0; i < MAX; i++) {
        if (count[i] > most) most = count[i];
    }
    
    //첫 번째 최빈값 구하기
    for (i = 0; i < MAX; i++) {
        if (most == count[i]) {
            result = i - 4000;
            break;
        }
    }
    
    //두 번째 최빈값 구하기 (첫 번째 최빈값의 인덱스 뒤부터 ~ 끝까지)
    for (j = i + 1; j < MAX; j++) {
        if (most == count[j]) {
            result = j - 4000;
            break;
        }
    }
    
    return result;
}

//범위
int range(int count[], int N) {
    int min, max;
    
    //최솟값 찾기
    for (int i = 0; i < MAX; i++) {
        if (count[i] != 0) {
            min = i - 4000;
            break;
        }
    }
    
    //최댓값 찾기
    for (int i = MAX - 1; i >= 0; i--) {
        if (count[i] != 0) {
            max = i - 4000;
            break;
        }
    }
    
    return max - min;
}
