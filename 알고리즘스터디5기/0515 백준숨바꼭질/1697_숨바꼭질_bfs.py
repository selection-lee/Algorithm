from collections import deque


def bfs():
    queue = deque()
    queue.append((N, 0))  # (현재 위치, 시간)
    visited[N] = True

    while queue:
        me, cnt = queue.popleft()
        if me == K:
            return cnt
        # 걷기 이동
        if me - 1 >= 0 and not visited[me - 1]:
            visited[me - 1] = True
            queue.append((me - 1, cnt + 1))
        if me + 1 <= 100000 and not visited[me + 1]:
            visited[me + 1] = True
            queue.append((me + 1, cnt + 1))
        # 순간이동
        if me * 2 <= 100000 and not visited[me * 2]:
            visited[me * 2] = True
            queue.append((me * 2, cnt + 1))


# me 내 위치, d 목적지, cnt 현재까지 걸린 시간
# def bfs(me, d, cnt):

# 변수 정의
# 초기값 처리하기
# 할 일 반복하기

# N 수빈이 위치
# K 동생 위치
N, K = map(int, input().split())

cnt = 0  # 몇초 지났는지
min_cnt = 100000  # 가장 빠른 시간

# 방문 기록 추가해서 메모이제이션...?
visited = [0] * 100001
ans = bfs()
print(ans)

# N 수빈이 위치, K 동생 위치
N, K = map(int, input().split())
# 방문한 위치를 저장할 배열
visited = [False] * 100001

# 가장 빠른 시간을 출력
print(bfs())
