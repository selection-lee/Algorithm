# 와 대충격
def solution_others(nums):
    return min(len(nums)/2, len(set(nums))) # 이렇게 간단할 수가!!! 
def solution(nums):
    N = len(nums)
    print('N', N)
    nums = set(nums)
    print(nums)
    nums_length = len(nums)
    print('len', nums_length)
    # N/2와 set의 길이 중 더 적은 것 반환하기
    return N/2 if N/2 <= nums_length else nums_length
# 이렇게 하면 경우의 수를 모두 구하는 거고.......... 
# 이문제는 그냥 한 번에 최대 가짓수를 구하는 거였다ㅠㅠㅠ
# # nums: N마리 종류 번호 [3, 1, 2, 3]
# # N/2마리 고르고 종류 번호의 개수 리턴
# def solution(nums): # N: len(nums) < 10000
#     # 일단 N 저장해놓고 N/2값 구해야겠다
#     N = len(nums)
#     # set으로 바꿔버릴까? 
#     nums = set(nums)
#     # 이제 중복 없으니까 이 set에서 2/N개 고르는 경우의 수 계산ㄱㄱ
#     ans = 0
    
#     # dfs?? 재귀 기억안나고 귀찮으니까 bfs로 ㄱ,...
#     visited = [0]*N
#     chosen = [] # 고른 거 저장할 것
#     cnt = 0 # 혹시 모르니까 len 벗어나면 
#     while True:
#         # 1. 종료조건
#         if len(chosen) == N/2 or cnt == N:
#             break
#         # 2. 초항
#         # visited[0] = 1
#         # cnt += 1
        
#         # 3. 고르기
#         if not visited[cnt]:
#             visited[cnt] = 1
#             cnt += 1
#             chosen.append(nums(0))
#     return ans