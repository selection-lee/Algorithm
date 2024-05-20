def min_time():
    whole = 0  # 시간 총 합
    now = 0  # 현재 사람 걸리는 시간
    for t in arr:
        now += t
        whole += now
    return whole


# 사람 수 N
N = int(input())

# 각 사람이 돈을 인출하는 데 걸리는 시간
arr = list(map(int, input().split()))
arr.sort()

ans = min_time()
print(ans)
