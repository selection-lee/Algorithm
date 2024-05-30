# N*N 게임판
# 칸에 적혀있는 수만큼 우/하 방향 이동 가능
# 0은 종착점
# 점프 중에는 방향 변경 불가.
# 경로 개수 구하기

# 델타 우 하
dr = [0, 1]
dc = [1, 0]

N = int(input())
board = [list(map(int, input().split())) for _ in range(N)]

# 경로 개수 저장하기
# (r, c)까지 올 수 있는 경로는 x개
dp = [[0] * N for _ in range(N)]
# 현재 위치에서 오른쪽/아래로 이동하면서, 해당 위치의 dp배열 값을 더해주면 됨.

# 전체 순회할거긴 한데
# 만약 해당위치 오는 경로 존재하고, 종착점이 아니면
# 점프하기. (도착가능한 칸의 좌표의 경로 개수 갱신)
dp[0][0] = 1  # 최초 값 처리
for r in range(N):
    for c in range(N):
        if dp[r][c] and board[r][c]:
            # 점프한 좌표가 범위 내에 있으면 점프
            # 오른쪽 먼저 가볼까?
            if c + dc[0] * board[r][c] < N:  # 점프한 열 좌표가 범위 내에 있으면
                dp[r][c + dc[0] * board[r][c]] += dp[r][c]
            # 다음은 아래쪽
            if r + dr[1] * board[r][c] < N:
                dp[r + dr[1] * board[r][c]][c] += dp[r][c]

print(dp[-1][-1])
