from collections import deque

# 델타배열
dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]


def bfs():
    # 변수 생성
    visited = [[0] * M for _ in range(N)]
    queue = deque()
    # 초기데이터 처리
    queue.append((0, 0))
    visited[0][0] = 1
    # 탐색하기
    while queue:
        r, c = queue.popleft()
        # print('r,c', r, c)
        for w in range(4):
            nr, nc = r + dr[w], c + dc[w]
            # 미로 범위 내에서 
            if 0 <= nr < N and 0 <= nc < M:
                # 길 있고 방문 기록 없으면
                if maze[nr][nc] and not visited[nr][nc]:
                    # v += 1, 큐에 다음좌표 넣기
                    visited[nr][nc] = visited[r][c] + 1  # 거리 기록
                    queue.append((nr, nc))
    return visited[N - 1][M - 1]


# N N개의 줄
# M M개의 정수
# N*M 배열
# 2 <= N, M <= 100
N, M = map(int, input().split())
# 1 통로, 0 벽
maze = [list(map(int, input())) for _ in range(N)]

# bfs 호출
ans = bfs()

print(ans)
