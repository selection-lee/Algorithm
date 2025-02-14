package barkingdog.recur.boj17478;

import java.util.Scanner;

/*
https://blog.encrypted.gg/943
재귀
- 함수 명확하게 정의해야 함
  - 함수 정의란? 함수의 인자로 어떤 것을 받을 것인지, 어디까지 계산한 후 자기 자신에게 넘겨줄지
  -> 즉, 인자와 종료조건!!
- 모든 재귀 함수는 반복문만을 구현 가능
  - 함수 호출이 꽤 비용 큰 연산이라 메모리, 시간 면에서는 손해
  - 재귀 없이 구현하면 코드가 너무 복잡해지는 일부 문제에서만 재귀 ㄱㄱ
- 자기 자신 여러번 호출하는 과정에서 이미 계산한 걸 또 계산하는 일이 빈번함
  -> 시간복잡도 말도 안되게 커짐
  -> 이건 dp로 해결 가능
- 메모리 제한 있는 swea 같은 경우엔 재귀 깊게 들어가면 런타임 에러 발생
  - 스택 메모리에 함수 정보 계쏙 쌓이다가 1mb넘기면 그렇다고..
  -> 이런 경우 어쩔 수 없이 재귀 대신 반복문
  -> 스택 메모리에는 지역 변수도 들어감,,,

 */
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
//        System.out.println(recur(N, 0));
        recur(N,0);
    }
    public static String recur(int n, int depth) {
        // 1. 종료 조건
        if (depth==n) {
            System.out.println("____".repeat(depth) + "\"재귀함수가 뭔가요?\"");
            System.out.println("____".repeat(depth) + "\"재귀함수는 자기 자신을 호출하는 함수라네\"");
            System.out.println("____".repeat(depth) + "라고 답변하였지.");
            return "";
        }
        // 2. 작업 수행
        System.out.println("____".repeat(depth) + "\"재귀함수가 뭔가요?\"");
        System.out.println("____".repeat(depth) + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
        System.out.println("____".repeat(depth) + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
        System.out.println("____".repeat(depth) + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
        // 3. 재귀 호출
        recur(n,depth+1);
        System.out.println("____".repeat(depth) + "라고 답변하였지.");
        return "";
    }
}
