# from collections import deque

def solution(bridge_length, weight, truck_weights):
    answer = 0
    # 스택을 다리길이만큼.
    stack = [0] * bridge_length
    # q = deque([0] * bridge_length)
    sum_stack = 0
    # print(q)
    while stack:  # 스택이 비면 모든 트럭 다 지나가서 종료
        # 언제 트럭이 다리에 올라갈 수 있을까?
        # 다리에 트럭이 없을 때,
        # 다리의 트럭과 이번 트럭의 무게 합이 weight 이하일 때

        # 언제 트럭이 다리에서 내려갈까?
        # 올라온지 bridge_length 초만큼 지났을 때
        # or 다리의 끝에 있을 때
        # 어차피 0으로 채워놔서 그냥 무조건 앞에껄 빼줘야 시간 흐름 체크 가능할듯 ?

        # if stack[0] != 0:
        # 다리 맨 끝에 트럭이 있으면
        # stack.pop(0)  # 트럭 나간다
        # q.popleft()
        # sum_q -= q.popleft()
        sum_stack -= stack.pop(0)
        if truck_weights: # 마지막 트럭은 stack에 남아있어도 줄선트럭은 없을수도 있어서
            # if sum(q) + truck_weights[0] <= weight:
            if sum_stack + truck_weights[0] <= weight:
                # 다리 트럭 + 이번트럭 무게 합이 최대중량 이하일때
                sum_stack += truck_weights[0]
                stack.append(truck_weights.pop(0))  # 맨 앞 트럭 들어간다
            else:
                stack.append(0)

        answer += 1

    return answer


A, B = 2, 10
C = [7, 4, 5, 6]

print(solution(A, B, C))  # 8

A, B = 100, 100
C = [10]
print(solution(A, B, C))  # 101

A, B = 100, 100
C = [10, 10, 10, 10, 10, 10, 10, 10, 10, 10]
print(solution(A, B, C))  # 110
