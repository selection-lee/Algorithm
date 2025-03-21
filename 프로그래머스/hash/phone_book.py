def solution(book):
    # 1. 정렬시켜서 접두어 비슷한 애들끼리 모으기.
    book.sort()
    # print(book)
    N = len(book)
    # N-1번까지 해서 N번째꺼랑까지 비교 ㄱ
    for i in range(N-1):
        # 2. 비교해서 있으면 false, 없으면 true
        # 비교는 어케? 
        # 현재 num이 다음꺼의 접두어인지 확인
        # startswith
        if book[i] == book[i+1][:len(book[i])]:
            return False
        
    return True
# 아니 왜 그래도 효율성 테스트 실패냐아아아아악
# def solution(phone_book):
#     N = len(phone_book)
#     for num in phone_book:
#         for i in range(N):
#             if num == phone_book[i]:
#                 continue
#             if num == phone_book[i][0:len(num)]:
#                 # print('접두same', num, phone_book[i][0:len(num)])
#                 return False
#     return True

# def solution(phone_book):
#     # ['119', '97674223', '1195524421']
#     # 1. N번이 나머지에 없으면 F
#     # 2. 들어있으면, 맨 앞인지 chk
    
#     # 1. N번이 나머지에 있는지? 
#     for num in phone_book:
#         print('num',num)
#         for i in range(len(phone_book)):
#             # 자기자신이면 pass.....
#             if num == phone_book[i]:
#                 continue
#             if num in phone_book[i]:
#                 # print('들어있는 num: ',num)
#                 # 2. 들어있으면, 맨 앞인지
#                 cnt = 0
#                 for j in range(len(num)):
#                     if num[j] == phone_book[i][j]:
#                         cnt += 1
#                         # print('num[j] == pb[i][j]', num[j], ' ??' , phone_book[i][j] )
#                     if cnt == len(num):
#                         return False
#     return True