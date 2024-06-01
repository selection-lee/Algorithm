# 정수 N을 (순서x) 1,2,3의 합으로 나타내는 경우의 수
# try2: dp...
# 아니 애초에 시리즈문제였잖아?!?!?
# https://velog.io/@jkh9615/series/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-1-2-3-%EB%8D%94%ED%95%98%EA%B8%B0-%EC%8B%9C%EB%A6%AC%EC%A6%88
T = int(input())
for tc in range(1, T + 1):
    N = int(input())  # 양수, 1만 이하

    # N을 만들기 위해서는?
    # N-3을 만드는 경우에서 3 더해주기
    # N-2를 만드는 경우에서 2만 더해주면 됨
    # N-1을 만드는 경우에 각각 1만 더해주면 됨
    # 즉, N-3만드는경우 + N-2경우 + N-1 경우

    # 1. dp배열 정의
    # i번째 칸은 i번 수를 만드는 방법 몇가지인지
    dp = [0] * (N + 1)
    # 2. 첫항처리하기
    # 3까지는 자기자신도 가능하니까 미리 처리
    # dp[1] = 1
    dp[0] = 1  # 아무것도 선택하지 않는다는 경우의 수

    # if N > 1:
    #     dp[2] = 2
    # if N > 2:
    #     dp[3] = 4
    # 3. 계산하기
    # for i in range(4, N + 1):
    # dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1]
    # for i in range(1, N + 1):
    #     if i >= 1:
    #         dp[i] += dp[i - 1]
    #     if i >= 2:
    #         dp[i] += dp[i - 2]
    #     if i >= 3:
    #         dp[i] += dp[i - 3]
    # 중복 제거
    for i in range(1, 4):
        for j in range(i, N+1):
            dp[j] += dp[j-i]
    print(dp[N])
