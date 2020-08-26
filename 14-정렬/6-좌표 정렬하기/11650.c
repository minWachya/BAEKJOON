#include <stdio.h>
#include <stdlib.h>

//x, y좌표의 구조체
typedef struct {
    int x;
    int y;
} point;

//qsort 오름차순 정렬을 위한 함수
int compare(const point *a, const point *b) {
    point p1 = *a;
    point p2 = *b;
    
    //p1, p2의 x값이 같을 때 p1.y이 크면 1 리턴, p2.y가 크면 -1, y값도 같으면 0 리턴
    if (p1.x == p2.x) return p1.y > p2.y ? 1 : (p1.y < p2.y ? -1: 0);
    //p1의 x값이 크면 1 리턴, p2의 x값이 크면 -1 리턴
    else return p1.x > p2.x ? 1 : -1;
}

int main(void) {
    int N;
    scanf("%d", &N);
    
    //N개의 point 배열 만들기
    point *p = calloc(N, sizeof(point));
    
    //입력
    for (int i = 0; i < N; i++)
        scanf("%d %d", &p[i].x, &p[i].y);
    
    //x좌표 증가순으로 정렬(오름차순)
    qsort(p, N, sizeof(point), compare);
    
    //출력
    for (int i = 0; i < N; i++)
        printf("%d %d\n", p[i].x, p[i].y);
    
    //배열 해제
    free(p);
    
    return 0;
}
