def solution(genres, plays): 
	# 1. 재생 수 합 계산
	gen_sum = dict() # genre: plays
	for i in range(len(genres)):
		# 있으면 더하고 없으면 만들고
		if genres[i] in gen_sum:
			gen_sum[genres[i]] += plays[i]
		else: 
			gen_sum[genres[i]] = plays[i]
	# 2. 재생 수 합 순으로 장르 정렬
	gen_sum = sorted(gen_sum.items(), key=lambda x : x[1], reverse=True) # 내림차순

	# 3. 각 장르 별 노래 genre: (고유번호: play 수)
	plays_list = dict()
	for i in range(len(genres)):
		if genres[i] not in plays_list:
			plays_list[genres[i]] = [(i, plays[i])]
		else: 
			plays_list[genres[i]].append((i, plays[i]))

	# 4. 장르별로 재생 수 많은 곡부터 내림차순, 재생수 같으면 고유번호 오름차순
	ans = []
	for genre, _ in gen_sum: # 중복 없이 장르만 갖다쓸 것
		# 이번 장르 노래 정렬
		sorted_songs = sorted(plays_list[genre], key = lambda x: (-x[1], x[0]))
		# 최대 2개만
		for i in range(min(len(sorted_songs), 2)):
			ans.append(sorted_songs[i][0])

	return ans