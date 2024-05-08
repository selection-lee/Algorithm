# N 나무개수
# M 나무길이 갖고갈거
N, M = map(int, input().split())
# 나무 높이 (항상 M 이상)
tree = list(map(int, input().split()))
# 1. 절단기에 높이 H 지정
# 2. 나무높이 - H = 가져갈 길이(양수일때만)
# 3. 절단기 높이 최댓값!
# 완탐으로도 가능할 것 같다
# H를 max(tree)로 잡고 1씩 빼가면서, 가져갈 길이가 M이상 되는 순간 멈추고 H 반환하기

height = max(tree) - 1
for h in range(height, -1, -1):
    get_tree = 0 # 초기화 위치 주의
    for t in tree:
        if (t - h) > 0:
            get_tree += (t - h)
    if get_tree >= M:
        height = h
        break
print(height)
