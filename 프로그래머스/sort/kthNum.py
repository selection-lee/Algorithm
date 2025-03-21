# 숫자 배열 array
# commands : [i, j, k]
#    i부터 j앞까지(j-1번 idx까지) 자르고 정렬해서 k번째 숫자 찾기
# [2,5,3] => 2번 idx부터 4번idx까지 자르고 정렬, 3번째 찾기
def solution(array, commands):
    ans = []
    # print(array) #	[1, 5, 2, 6, 3, 7, 4]
    # print(commands) # [[2, 5, 3], [4, 4, 1], [1, 7, 3]]
    for e in commands: 
        # print(e, e[0], e[1], e[2])
        cut = sorted(array[e[0]-1:e[1]]) # 자르는것도 idx x...
        # print('cut: ',cut)
        ans.append(cut[e[2]-1]) # 몇번쨰인지는 idx x
    return ans