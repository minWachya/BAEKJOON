/*
<힙 정렬>
가장 큰 값이 루트에 위치하는 특징을 이용하는 정렬 알고리즘
힙) 부모의 값 >= 자식의 값

ex) 요소가 6개인 배열 5 4 2 3 1 6 를 트리 모양으로 표현하면 아래 그림처럼 됨
인덱스는 위->아래, 왼->오 순서대로 0~5
a[i]의 부모는 a[(i-1)/2], 왼쪽 자식은 a[i*2+1], 오른쪽 자식은 a[i*2+2]
    5                  5                    5                    6
   / \     2          / \     2            / \                  / \
  4   2  =/을 힙으로>  4  6  =/ \을 힙으로>  4  6  =전체를 힙으로>  4  5
 / \ /   6          / \ /   3  5         / \ /                / \ /
3  1 6             3  1 2               3  1 2               3  1 2
=>정렬된 배열 6 4 5 3 1 2 을 오름차순대로 정렬
    6                     5
   / \   루트를 ()에 저장  / \   루트를 ()에 저장          
  4   5 = &다시 힙정렬 >  4  3 = &다시 힙정렬 >  ...반복... =()안에 오름차순대로 최종 정렬됨 
 / \ /    5 4 3 1 2(6) / \     4 3 1 2(5 6)
 3 1 2                1  2
*/

#include <stdio.h>
#include <stdlib.h>

#define swap(type, x, y) do {int t = x; x = y; y = t; } while(0)
    
//num[start]~num[end]를 힙으로 만드는 함수
static void downHeap(int num[], int end, int start) {
    int temp = num[end];    //끝 부모의 인덱스
    int child, parent;      //자식, 부모
    
    //a[i]의 부모는 a[(i-1)/2], 왼쪽 자식은 a[i*2+1], 오른쪽 자식은 a[i*2+2]
    //끝 부모부터; 루트까지; 부모 인덱스 값은 왼오 자식 중 큰 값의 인덱스로 수정;
    for (parent = end; parent < (start + 1) / 2; parent = child) {
        int cl = parent * 2 + 1;    //왼쪽 자식 인덱스
        int cr = parent * 2 + 2;    //오른쪽 자식 인덱스
        
        //왼쪽, 오른쪽 자식 중에 큰 값을 선택
        child = (cr <= start && num[cr] > num[cl]) ? cr : cl;
        
        //부모의 값 >= 자식의 값이면(힙이면) 빠져나가고
        if (temp >= num[child]) break; 
        num[parent] = num[child];    //1, 아니면 부모의 값을 자식의 값으로 바꿈
    }                            //(1과 2의 과정이 그림에서 '~를 힙으로' 부분과 같음)
    num[parent] = temp;            //2, 부모의 값을 루트의 값으로 바꿈
}

//힙 정렬 함수
void heapSort(int num[], int N) {
    //배열을 힙으로 만들기(끝 부모부터 루트까지)
    for (int i = (N - 1) / 2; i >= 0; i--)
        downHeap(num, i, N-1);
    
    //루트에 있는 가장 큰 값을 배열 마지막 요소와 바꾸고
    //배열의 나머지 부분을 다시 힙으로 만들기 반복
    for (int i = N - 1; i > 0; i--) {
        swap(int, num[0], num[i]);
        downHeap(num, 0, i-1);
    }
}

int main(void) {
    int N;
    scanf("%d", &N);
    int *num;    //배열의 첫 번째 요소에 대한 포인터
    num = calloc(N, sizeof(int));    //요소가 N개인 int형 배열 생성
    
    //숫자 입력
    for (int i = 0; i < N; i++)
        scanf("%d", &num[i]);
    
    //오름차순 정렬(힙 정렬)
    heapSort(num, N);
    
    //출력
    for (int i = 0; i < N; i++)
        printf("%d\n", num[i]);
    
    //배열 해제
    free(num);
    
    return 0;
}
