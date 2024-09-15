def loadBalancingDynamicProgramming(machines, tasks):
    dp = {}
    dp[(0,) * machines] = 0

    for task in tasks:
        newDp = {}
        for state in dp:
            for i in range(machines):
                newState = list(state)
                newState[i] += task
                newState = tuple(newState)
                newMaxLoad = max(newState)
                if newState not in newDp:
                    newDp[newState] = newMaxLoad
                else:
                    newDp[newState] = min(newDp[newState], newMaxLoad)
        dp = newDp

    return min(max(state) for state in dp.keys())




# print(loadBalancingDynamicProgramming(3, [ 8 , 7 , 6 , 5 , 4 , 3 , 2 , 1 ]))
