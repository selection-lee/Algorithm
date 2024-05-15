# me 내 위치, d 목적지, cnt 현재까지 걸린 시간
def dfs(me, cnt):
    global min_cnt
    # 백트래킹
    if me < 0 or me > 100000:
        return

    # 할 일 하기
    visited[me] = 1 # 방문처리
    if me == K:  # 동생 찾으면
        # 만약 현재 시간이 min보다 작으면 min 갱신
        if min_cnt > cnt:
            min_cnt = cnt
        return min_cnt
    # 걷기 이동
    dfs(me + 1, cnt + 1)
    dfs(me - 1, cnt + 1)
    # 순간이동
    dfs(me * 2, cnt + 1)


# N 수빈이 위치
# K 동생 위치
N, K = map(int, input().split())

cnt = 0  # 몇초 지났는지
min_cnt = 100000  # 가장 빠른 시간

# 방문 기록 추가해서 메모이제이션...?
visited = [0] * 100001
ans = dfs(N, cnt)
print(ans)
