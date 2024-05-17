'''
7
0110100
0110101
1110101
0000111
0100000
0111110
0111000
'''

dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]


def dfs(cr, cc):
    global inner_cnt
    # 방문처리, 할 일 하기
    visited[cr][cc] = 1
    inner_cnt += 1
    # print(inner_cnt)
    # 상하좌우 탐색
    for w in range(4):
        nr, nc = cr + dr[w], cc + dc[w]
        if 0 <= nr < N and 0 <= nc < N:
            # 집이 있고 방문 아직 안했으며
            if town[nr][nc] == 1 and not visited[nr][nc]:
                # 다음 집 탐색
                dfs(nr, nc)


# 지도크기 N
N = int(input())

town = [list(map(int, input())) for _ in range(N)]
visited = [[0] * N for _ in range(N)]
vill_cnt = 0
ans = []
# 모든 칸 완탐
for r in range(N):
    for c in range(N):
        # 집이 있고 방문 안했으면
        if town[r][c] == 1 and not visited[r][c]:
            # 방문하기
            inner_cnt = 0
            dfs(r, c)
            vill_cnt += 1  # 단지 하나 추가
            ans.append(inner_cnt)
ans.sort()
print(vill_cnt, *ans)
