def loadBalancingGreedy(machines, tasks):
    tasks.sort(reverse = True)
    machinesTimes = [0] * machines

    for task in tasks:
        minCost = machinesTimes[0]
        machine = 0
        for i in range(1, machines):
            if machinesTimes[i] < minCost:
                minCost = machinesTimes[i]
                machine = i
        
        machinesTimes[machine] += task

    return max(machinesTimes)

# print(loadBalancingGreedy(3, [ 8 , 7 , 6 , 5 , 4 , 3 , 2 , 1 ]))
