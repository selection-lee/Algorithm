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
# print(N)
stack = [0] * N
# print(stack)
top = -1
order = [list(map(str, input().split())) for _ in range(N)]
print(order)

for i in range(N):
    # order = input().split()
    # print(order)
    # 명령 5개
    if order[i][0] == 'push':
        top += 1
        stack[top] = int(order[i][1])
        # print(top)
    elif order[i][0] == 'pop':
        # top -= 1
        if top <= -1:
            print(-1)
        else:
            print(stack[top])
            top -= 1
        # print('top', top)
    elif order[i][0] == 'size':
        print(top + 1)
    elif order[i][0] == 'empty':
        print(1 if top < 0 else 0)
    else:  # top
        print(stack[top] if top >= 0 else -1)
