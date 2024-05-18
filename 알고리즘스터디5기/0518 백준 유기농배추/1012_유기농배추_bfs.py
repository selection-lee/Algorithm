'''
2
10 8 17
0 0
1 0
1 1
4 2
4 3
4 5
2 4
3 4
7 4
8 4
9 4
7 5
8 5
9 5
7 6
8 6
9 6
10 10 1
5 5
'''
from collections import deque

dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]


def bfs(sr, sc):
    # 필요한 변수 만들기
    queue = deque()
    # 첫항 처리
    visited[sr][sc] = 1
    queue.append((sr, sc))
    # 탐색
    while queue:
        # 현재위치
        cr, cc = queue.popleft()
        # 인접 네방향 탐색
        for w in range(4):
            nr, nc = cr + dr[w], cc + dc[w]
            # 범위 내에 있고
            if 0 <= nr < N and 0 <= nc < M:
                # 배추 있는데 벌레 없으면
                if field[nr][nc] and not visited[nr][nc]:
                    # 방문처리하고 큐 삽입
                    visited[nr][nc] = 1
                    queue.append((nr,nc))


T = int(input())

# N*M 배열
# K 배추개수
for tc in range(T):
    M, N, K = map(int, input().split())
    cabbage = [list(map(int, input().split())) for _ in range(K)]
    field = [[0] * M for _ in range(N)]
    for x, y in cabbage:
        field[y][x] = 1
    ans = 0  # 배추흰지렁이

    # 이번엔 bfs.....
    visited = [[0] * M for _ in range(N)]
    for c, r in cabbage:
        # 방문 안한 경우에만
        if not visited[r][c]:
            bfs(r, c)
            # bfs 한 턴 끝나면 지렁이 + 1
            ans += 1

    # 필요한 변수 만들기
    # visited = [[0] * M for _ in range(N)]
    # queue = deque()
    # r, c = 0, 0 # 모든 배추 위치를 탐색하기 전에 이미 (0, 0)에서 시작하는 잘못된 초기화를 하고 있습니다. 탐색은 배추가 있는 위치에서 시작해야 합
    # # 첫 항 처리
    # visited[r][c] = 1
    # queue.append((r, c))
    # 탐색
    # for r in range(N):
    #     for c in range(M):
    #         while queue:
    #             cr, cc = queue.popleft()
    #             for w in range(4):
    #                 nr, nc = cr + dr[w], cc + dc[w]
    #                 # 범위 내에 있고
    #                 if 0 <= nr < N and 0 <= nc < M:
    #                     # 배추가 있고 방문 안했으면
    #                     if field[nr][nc] == 1 and not visited[nr][nc]:
    #                         # 다음 탐색 할 거 넣어주기
    #                         queue.append((nr, nc))
    #         ans += 1

    # for r in range(N):
    #     for c in range(M):
    #         for w in range(4):
    #             while queue:
    #                 cr, cc = queue.popleft()
    #                 # 배추가 있고 방문 안했으면
    #                 if field[cr][cc] and not visited[cr][cc]:
    #                     # 다음 탐색
    #                     nr, nc = cr + dr[w], cc + dc[w]
    #                     if 0 <= nr < N and 0 < nc < M:
    #                         queue.append((nr, nc))
    #
    #             ans += 1 # while문 끝나면 한 덩어리 끝난 것

    print(ans)
