def solution(participant, completion):
    participant.sort()
    completion.sort()
    # 헉 print문이 생각보다 시간 많이 잡아먹는구나,,,
    # print('참여: ', participant)
    # print("완주: ", completion)
    # for person in participant:
    #     print(person)
    #     if person not in completion:
    #         answer = person
    #         print("답:",answer)
    # 대충격 이거 동명이인은 못 거르네 어카징
    
    # for person in participant:
    #     if person in completion:
    #         idx = participant.indexOf(person)
    #         print(participant)
    
    for i in range(len(completion)):
        if participant[i] != completion[i]:
            # 다른 순간 완주못한사람임
            return participant[i]
    # 근데 여기까지 오면 마지막 사람이 미완
    return participant[-1]
    