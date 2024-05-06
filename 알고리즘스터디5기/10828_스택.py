'''
14
push 1
push 2
top
size
empty
pop
pop
pop
size
empty
pop
push 3
empty
top
'''
N = int(input())
print(N)
stack = []
order = [list(map(str, input().split())) for _ in range(N)]
print(order)
for i in range(N):
    # order = input()
    # 명령 5가지
    if 'push' in order[i][0]:
        # push_num = int(order.split()[-1])
        stack.append(int(order[i][1]))
        # print(stack)
    elif order[i][0] == 'pop':
        if len(stack) > 0:
            num = stack.pop()
            print(num)
        else:
            print(-1)
    elif order[i][0] == 'size':
        print(len(stack))
    elif order[i][0] == 'empty':
        if len(stack) == 0:
            print(1)
        else:
            print(0)
    elif order[i][0] == 'top':
        if len(stack) > 0:
            print(stack[-1])
        else:
            print(-1)