# 곡 N개, 시작 볼륨 S, 볼륨 최댓값 M
N, S, M = map(int, input().split())

# i번째 곡을 연주하기 전에 바꿀 수 있는 볼륨 N개
vols = list(map(int, input().split()))
# 현재 볼륨 +- vols[i번] 만 가능
# 볼륨은 0 이상 M 이하만 가능

# i번째 곡이 볼륨 0부터 M까지의 볼륨이 될 수 있는지 여부?
# 첫 줄(0번)은 시작 볼륨, 둘째 줄(1번 줄) 부터 각 노래 볼륨 조절 여부
dp = [[0] * (M + 1) for _ in range(N + 1)]
dp[0][S] = 1  # 시작 볼륨 처리

# 각 곡마다, 노래 볼륨 0~M마다, 볼륨 조절 가능하면 처리하기.
for i in range(1, N + 1):
    for j in range(M + 1):
        if dp[i - 1][j] != 0:  # i-1번 노래를 j로 볼륨 조절 가능하면!
            # 이번 볼륨이 범위 내에 있으면
            if 0 <= j + vols[i - 1] <= M:
                # 이번 볼륨 조절 가능 표시
                dp[i][j + vols[i - 1]] = 1
            # 이번엔 뺀 볼륨,, 범위 내에 있으면
            if 0 <= j - vols[i - 1] <= M:
                # 이번 볼륨 조절 가능 표시
                dp[i][j - vols[i - 1]] = 1
max_V = -1
# 끝에서부터 볼륨 최댓값 찾고 찾으면 바로 종료
for i in range(M, -1, -1):
    if dp[N][i] == 1: # 해당 볼륨이 가능하면, (뒤에서부터 찾아서 이게 최댓값이다)
        max_V = i # 볼륨 최댓값 갱신
        break

print(max_V)
