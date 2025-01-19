# 프로그래머스
# n^2 배열 자르기
# 런타임에러,,,,
N, left, right = map(int, input().split())
# N*N 배열
data = [[0]*N for _ in range(N)]
# 빈칸을 숫자 i로 채우기
for i in range(0, N):
    for j in range(0, N):
        if j < i:
            data[i][j] = i+1
        else:
            data[i][j] = j+1

arr = []
# 각 행 이어붙인 새로운 1차원 배열 만들기
for i in range(N):
    for d in data[i]:
        arr.append(d)
# print(arr)
# arr[left:right+1]
arr = arr[left:right + 1]
print(arr)