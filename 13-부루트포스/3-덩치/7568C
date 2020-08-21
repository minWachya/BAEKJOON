#include <stdio.h>
int main(void) {
    int N;    //전체 사람 수
    scanf("%d", &N);

    int size[50][2] = {0, };    //size[몸무게][키] (2 <= N <=50)
    for (int i = 0; i < N; i++)
        scanf("%d %d", &size[i][0], &size[i][1]);

    int number[50] = { 0, };    //순위 저장하는 배열
    for (int i = 0; i < N; i++) {
        int index = 1;
        for (int j = 0; j < N; j++) {
            //자기(i)보다 덩치 큰 사람(j)이 몇 명 있는지 index에 저장
            if (size[i][0] < size[j][0] && size[i][1] < size[j][1]) {
                index++;
            }
        }
        number[i] = index;
    }

    for (int i = 0; i < N; i++)
        printf("%d ", number[i]);

    return 0;
}
