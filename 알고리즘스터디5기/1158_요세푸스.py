N, K = map(int, input().split())

people = list(i for i in range(1, N + 1))

# print(people[K])
jose = []
idx = 0  # 제거할 인덱스
while people:
    # if len(people) == 0:
    #     break
    # if len(people) > 0:
    # print(idx)
    # now = people.pop(idx % (len(people)))
    # yose.append(now)
    # idx += K - 1
    # idx %= len(people)
    # idx 계산 순서!!!
    idx = (idx + K - 1) % len(people)
    jose.append(people.pop(idx))
print("<" + ", ".join(map(str, jose)) + ">")
'''
1 2 3 4 5 6 7 1 2 3 4 5 6 7 1 2 3 4 5 6 7
7 3
3 6 2 
'''
