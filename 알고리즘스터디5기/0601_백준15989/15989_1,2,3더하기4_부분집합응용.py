# 정수 N을 (순서x) 1,2,3의 합으로 나타내는 경우의 수
# try1: 부분집합 합 응용했음.
#   => 아무리해도 하나가 맞게나오면 나머지가 틀리거나 아예 딴게나오거나...
#   ==> 풀었지만 시간초과
# try2: dp...
# 아니 애초에 시리즈문제였잖아?!?!?
# https://velog.io/@jkh9615/series/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-1-2-3-%EB%8D%94%ED%95%98%EA%B8%B0-%EC%8B%9C%EB%A6%AC%EC%A6%88


# idx: 선택한 숫자(인덱스)
def subset(idx, sub_sum, selected):
    global cnt
    # 1. 종료조건
    if sub_sum > N:
        return
    if idx > N:
        return
    # 2. 할 일 하기
    # sub_sum += idx
    if sub_sum == N:  # 합이 N이 되면 cnt ++
        cnt += 1
        # 근데 이 문제에서는 이 때 종료해야 하는 거 아닌가...? 일단보류
        selected.sort()
        # print(selected)
        if selected not in selected_ans:
            selected_ans.append(selected)
        return
    # 3. 다음 탐색
    # # 현재 idx 선택한 경우
    # subset(idx + 1, sub_sum)
    # # 현재 idx 선택 x 경우
    # subset(idx + 1, sub_sum - idx)
    # 1,2,3 선택
    for i in range(1, 4):
        subset(idx + 1, sub_sum + i, selected + [i])


T = int(input())
for tc in range(1, T + 1):
    N = int(input())  # 양수, 1만 이하

    cnt = 0
    # selected = [0] * (N + 1)  # 선택한 수를 인덱스로, 선택했으면 1
    selected_ans = []
    subset(0, 0, [])  # 1,0 안되나..
    # print(cnt)
    # print('sel:',len(selected_ans))
    # print('---')
    print(len(selected_ans))
