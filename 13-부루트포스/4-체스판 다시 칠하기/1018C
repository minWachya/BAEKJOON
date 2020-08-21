#include <stdio.h>
#define compare(a, b) a > b ? b : a
/*

행+열 0  1  2  3  4  5
   +ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
  0ㅣ 0  1  2  3  4  5
  1ㅣ 1  2  3  4  5  6
  2ㅣ 2  3  4  5  6  7
  3ㅣ 3  4  5  6  7  8
  4ㅣ 4  5  6  7  8  9
  5ㅣ 5  6  7  8  9  10
  
  BWBW... - B의 행+열=짝수, W의 행+열=홀수
  WBWB... - B의 행+열=홀수, W의 행+열=짝수
*/

int main(void) {
    char chessBoard[50][50];
    int min = 64;      //8*8=64    //오류1, min=0으로 해서 최솟값이 계속 0이 되게함...
    int N, M;          //N*M 체스판
    scanf("%d %d", &N, &M);
    
    for (int i = 0; i < N; i++)
        scanf("%s", &chessBoard[i]);
    
    //입력한 N*M 체스판을 8*8로 잘라서
    //다시 칠해야하는 B, W가 몇 개 있는지 모두 계산해보기
    for (int i = 0; i < N-7; i++) {
        for (int j = 0; j < M-7; j++) {
            //짝홀 규칙에 맞게 제대로 칠해진 경우와 다르게 칠해진 경우를 세는 변수
            //BWBW...와 WBWB...경우에 따라 다르게 세기
            //BWBW...일 경우 case1이 바르게 칠해지고 case2가 다르게 칠해진 수
            //WBWB...일 경루 case1이 다르게 칠해지고 case2가 바르게 칠해진 수
            int case1 = 0;
            int case2 = 0;
            int caseMin = 0;    //경우에 따른 최솟값을 저장하여 min과 비교하는 변수
            
            //8*8 체스판의 행+열의 짝홀수에 따라 다시 칠해야하는 칸 세보기
            //★BWBW... - B의 행+열=짝수, W의 행+열=홀수를 디폴트로 하여 예시를 들면★
            for (int a = i; a < i+8; a++) {
                for (int b = j; b < j+8; b++) {
                    //만약 행+열이 짝수고(BWBW...에서는 짝수=B)
                    if ((a+b)%2 == 0) {
                        //바르게 칠해진 경우++
                        if (chessBoard[a][b] == 'B') case1++;
                        //다르게 칠해진 경우++
                        else case2++;
                    }
                    //만약 행+열이 홀수고(BWBW...에서는 홀수=W)
                    else{
                        //다르게 칠해진 경우++
                        if (chessBoard[a][b] == 'B') case2++;
                        //바르게 칠해진 경우++
                        else case1++;
                    }
                }
            }
            caseMin = compare(case1, case2);
            min = compare(min, caseMin);
        }
    }
    printf("%d", min);
    
    return 0;
}
