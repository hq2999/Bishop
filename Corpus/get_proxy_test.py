import random
import math
import matplotlib.pyplot as plt
from get_proxy import ProxyUtils

pu = ProxyUtils(10000)

succ = 0
fail = 0

s_x = []
s_y = []

for count in range(10000):

    proxy_addr = pu.get_random_proxy()
    print(proxy_addr)

    if proxy_addr[0] == '1':
        # pu.refresh(proxy_addr)
        pu.add(proxy_addr)
        succ = succ + 1
    else:
        pu.remove(proxy_addr)
        fail = fail + 1

    stat = pu.get_stat()
    stat_list = [stat[i] for i in stat]

    s_x.append(count)
    s_y.append(succ / (fail + 1))

    if count % 100 == 0:
        # pass
        plt.clf()
        ax1 = plt.subplot(1, 2, 1)
        ax2 = plt.subplot(1, 2, 2)

        plt.sca(ax1)
        plt.plot([i for i in range(len(stat_list))], stat_list, linewidth=1.0, linestyle='-')

        plt.sca(ax2)
        plt.plot(s_x, s_y, linewidth=1.0, linestyle='-')
        plt.pause(0.01)

plt.show()




