# N 정점개수
# M 간선개수
# V 탐색시작정점번호
N, M, V = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(M)]

def dfs(now):
    # 1. 할 일
    ans_dfs.append(now)  # 방문한 노드 정답에 추가
    visited[now] = 1  # 방문 표시
    # 2. 방문하기
    for n in graph[now]:
        # 아직 방문 안했으면
        if not visited[n]:
            # -> dfs로 방문하기
            dfs(n)
def bfs(start):
    # 1. 필요한 큐, 방문체크배열, 변수 생성
    q = []  # 방문체크배열은 밖에서 만들어놧음
    # 2. 초기데이터(들) 삽입/처리
    q.append(start)
    ans_bfs.append(start)  # 방문한 노드 정답에 추가
    visited[start] = 1  # 시작노드 방문 표시
    # 3.
    # 큐에 데이터가 있는 동안
    while q:
        # 큐에서 하나 이번 노드 pop
        now = q.pop(0)
        # 정답처리 할 게 있으면 여기서 처리하는 게 코드가 더 심플해짐
        # 나머진 dfs와 똑같이 방문이다.
        for n in graph[now]:  # n == next
            # 방문 안 한 곳이면
            if not visited[n]:
                # -> 할 일 하기
                q.append(n)  # 큐 삽입
                ans_bfs.append(n)  # 정답 배열 삽입
                visited[n] = 1  # 방문 표시


graph = [[] * (N+1) for _ in range(N+1)]
for i in range(M):
    s, e = map(int, arr[i])
    # 양방향그래프
    graph[s].append(e)
    graph[e].append(s)

# graph 오름차순 정렬
for i in range(1, N + 1):
    graph[i].sort()

# dfs - visited배열, 정답 저장할 배열 만들기
visited = [0] * (N + 1)
ans_dfs = []
dfs(V)  # 함수 호출

visited = [0] * (N + 1)
ans_bfs = []
bfs(V)  # 함수 호출

# 결과 출력
print(*ans_dfs)
print(*ans_bfs)