# 하루 옷 최소 1개 이상 입음
# ['의상명', '의상종류']
# [['yellow_hat', 'headgear'], ['blue_sunglasses', 'eyewear'], ['green_turban', 'headgear']]
# dict로 묶으면 되는 거 아닌가? # 같은 key는 선택 x
def solution(clothes):
    d = dict()
    for item in clothes:
        # d[item[1]] = item[0] # ㅇㄴ 이러면 중복일때 어캄
        if item[1] not in d:
            d[item[1]] = [item[0]] # 리스트 만들고 저장
        else:
            d[item[1]].append(item[0])
    # print(d)
    # 의상개수 + (아무것도 안 고르는 경우==1) => 한 종류 경우의 수
    # 총 경우의 수 : 각 의상 경우의 수 * 경우들.... - 1(아무것도 안 고르는 경우는 빼야 함,,,)
    total = 0
    for key in d:
        now = len(d[key])
        # print("의상1 경우의수", now)
        # print('계산전',total)
        total = total*(now+1) if total > 0 else (now +1)
        # print('계산후',total)

    return total - 1
