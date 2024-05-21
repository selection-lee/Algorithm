# 회의 개수
N = int(input())

# 회의 시작-끝 (0 ~ 2^31-1)
arr = [list(map(int, input().split())) for _ in range(N)]
# arr.sort(key=lambda x: x[1])
arr.sort(key=lambda x: (x[1], x[0])) # 끝나는 시간 기준 정렬, 동시 종료면 시작시간 순
# print(arr)
ans = []
# 만약 0번인덱스가 이전 회의 종료시간보다 빠르면 넘어가고, 같거나 뒤면 이용가능
# now_end = arr[0][1]
# idx = 0
# ans.append(arr[0])
# cnt = 1
# while idx + 1 < N:
#     next_start = arr[idx + 1][0]
#     if now_end <= next_start:
#         ans.append(arr[idx+1])
#         now_end = arr[idx+1][1]
#         cnt += 1
#     idx += 1

cnt = 0
before_end = 0
for start, end in arr:
    if start >= before_end:
        cnt += 1
        before_end = end


print(cnt)

