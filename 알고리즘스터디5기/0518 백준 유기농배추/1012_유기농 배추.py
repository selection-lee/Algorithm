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
dr = [-1,1,0,0]
dc = [0,0,-1,1]

T = int(input())
def dfs(cr,cc):
    # 할 일 하기
    visited[cr][cc] = 1 # 방문처리
    # 다음(상하좌우)탐색하기
    for w in range(4):
        nr, nc = cr + dr[w], cc + dc[w]
        # 좌표 범위 내에서
        if 0 <= nr < N and 0 <= nc < M:
            # 배추가 있고 방문 안햇으면
            if field[nr][nc] and not visited[nr][nc]:
                # 다음 배추 탐색
                dfs(nr, nc)
    
    
# N*M 배열
# K 배추개수
for tc in range(T):
    M, N, K = map(int, input().split())
    cabbage = [list(map(int, input().split())) for _ in range(K)]
    field = [[0] * M for _ in range(N)]
    for x,y in cabbage:
        field[y][x] = 1
    ans = 0 # 배추흰지렁이
    visited = [[0] * M for _ in range(N)]
    # 완탐으로 탐색
    for r in range(N):
        for c in range(M):
            # 배추가 있고, 방문 안했으면 
            if field[r][c] == 1 and not visited[r][c]:
                dfs(r,c)
                ans += 1
    print(ans)