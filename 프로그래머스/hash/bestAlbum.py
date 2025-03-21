# 최종적으로 풀이순서를 다시살펴보면? 
# 1. 장르별 합  dict
# 2. 장르별 노래 리스트 dict
# 3. 장르별 합 값으로 (1)을 장르로 내림차순 정렬 
# 4. 장르 별 노래 선택
# 4.1 각 장르별로 노래들을 재생횟수 내림차순, 고유번호 오름차순 정렬
# 4.2 각 장르 최대 2개(1개일수도있음)를 답 배열에 append
# 4.2.1 i번째 노래의 고유번호만!

def solution(genres, plays):
    # i번째 노래의 genre, play 횟수
    # 장르별 재생최다 노래 2개
    # 고유번호 순서대로 반환
    # 합 최다 장르 >  장르 내 내림차순 > 고유번호 오름차순

    # cf) len(g) == len(plays)

    gen_sum = dict()

    # 1. 장르별 합
    for i in range(len(genres)):
        if genres[i] not in gen_sum:
            gen_sum[genres[i]] = plays[i]
        else:
            gen_sum[genres[i]] += plays[i]
    # print(gen_sum) // {'classic': 1450, 'pop': 3100}
    # 장르별로 정렬 먼저? or 장르 내 내림차순 정렬 먼저? 
    # 장르별 노래 리스트
    plays_list = dict()
    for i in range(len(genres)):
        if genres[i] not in plays_list:
            plays_list[genres[i]] = [(i, plays[i])]
        else:
            plays_list[genres[i]].append((i, plays[i]))
    # print(plays_list) // {'classic': [(0, 500), (2, 150), (3, 800)], 'pop': [(1, 600), (4, 2500)]}

    # print(plays_list['pop'][1]) // (4,2500)
    
    # 2. 장르value(sum값)를 내림차순 정렬 - key를 x:x[1]로!
    gen_sum = sorted(gen_sum.items(), 
                    key=lambda x: x[1], reverse=True) # 내림차순이니까 reverse
    
    # 3. 장르 내 내림차순 정렬?? how?????
    # plays_list = (lambda x: x[/*genres*/][n][1])[/*'??'*/][:2] # 그리고 앞에 2개만 가져올까........ 
    # 3. 장르 별 노래 선택
    # 3.1 각 장르별로 노래들을 재생횟수 내림차순, 고유번호 오름차순으로 정렬하고, 
    # 3.2 최대 2개까지 고르기
    ans = []
    for genre, _ in gen_sum: # plays 합은 값을 안쓸것
        # 3.1 장르별로, key=pl[g]가 x, lambda x: x[1], x[0]인데, x[1]만 내림차순
        sorted_list = sorted(plays_list[genre], key= lambda x: (-x[1], x[0])) # 람다의 키가 2개라면 튜플로 ㅠㅠ
        # 3.2 최대 2개(장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.)
        # 그니까 이번 장르에 속한 곡만!
        print(sorted_list)
        for i in range(min(len(sorted_list), 2)):
            ans.append(sorted_list[i][0]) # i번째 노래의 고유번호만! 
        
    return ans
    
# # i번째 노래의 genre, play 횟수
# # 장르별 최다 2개 씩
# # 고유버놓 순서 반환
# def solution(genres, plays):
#     # for i in range(len(genres)):
#     #     print(genres[i], plays[i])
    
#     d = dict()
#     N = len(genres)
#     for i in range(N):
#         if genres[i] not in d: # (고유번호, 재생횟수)
#             d[genres[i]] = [(i, plays[i])] # 배열로 만들어야 추후에 append로 추가 가능
#             # [{i:[plays[i]]}] # 이렇게 만들면??
#         else:
#             d[genres[i]].append((i,plays[i]))
            
#     print(d['pop'][0][1]) # 앞에서 0번째에 있는 노래의 재생 수
#     # 그럼 재생 수 합으로 sort, 그 후에 그 내부에서는 plays로 sort
#     # 1. 재생 수 합으로 sort
#     d.sort(lambda x: sum(d[x]))
#     print(d)