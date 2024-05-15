# N: 노드 개수
# M: 간선 개수
N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(M)]

graph = [[] for _ in range(N + 1)]


def dfs(now):
    #1. 방문처리
    visited[now] = 1
    # 2. 다음 갈 곳 탐색(만들어둔 인접리스트 이용)
    for nxt in graph[now]:
        # 방문 안한 노드면 탐색 go
        if not visited[nxt]:
            dfs(nxt)



for i in range(M):
    s, e = arr[i]
    # 무향그래프
    graph[s].append(e)
    graph[e].append(s)

# dfs로 찾을건데, 연결된 덩어리 개수 세려면?
# N개의 노드 전부에 대해 순회하면서 탐색할건데,
# 방문 안한 노드면 dfs로 탐색하기
# 돌아오면 이번 덩어리는 끝난거니까 카운트를 올려보자.
cnt = 0
visited = [0] * (N + 1)
for i in range(1, N + 1):
    if not visited[i]:
        dfs(i)
        cnt += 1

print(cnt)