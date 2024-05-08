# N 나무개수
# M 나무길이 갖고갈거
N, M = map(int, input().split())
# 나무 높이 (항상 M 이상)
tree = list(map(int, input().split()))
# 1. 절단기에 높이 H 지정
# 2. 나무높이 - H = 가져갈 길이(양수일때만)
# 3. 절단기 높이 최댓값!

# tree.sort(reverse=True)
# 아하 이분탐색을 배열의 인덱스가 아니라 절단기 높이로 !!!!
# 그래서 start를 1로, end를 max(tree)로
start = 1
end = max(tree)
max_height = 0 # 설정높이 최댓값
# 가져갈 길이
while start <= end:
    get_tree = 0
    middle = (start + end) // 2
    #가져갈 길이
    for t in tree:
        if t - middle > 0:
            get_tree += t - middle
    if get_tree < M:  # 부족하니까 절단기 높이 낮춰야지
        end = middle - 1
    else:
        if middle > max_height: # 중간값이랑 max_height랑 비교해서 중간값이 더 높으면
            max_height = middle
        start = middle + 1
print(max_height)
