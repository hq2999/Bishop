import random
import math

class ProxyUtils:

    def __init__(self, max_length):
        with open('proxy_list.txt', 'r') as proxy_file:
            l = proxy_file.readlines()
            self.proxy_list = [item.replace('\n', '') for item in l if len(item) > 0]
            self.i = -1

        self.max_length = max_length
        self.stat = dict()

        self.fail_stat = dict()

        for proxy in self.proxy_list:
            if proxy in self.stat:
                self.stat[proxy] = self.stat[proxy] + 1
            else:
                self.stat[proxy] = 1

        self.diff = 20
        self.diff_list = list()
        self.succ_list = list()

    def get_stat(self):
        return self.stat

    def get_sequential_proxy(self):
        self.i = self.i + 1
        if self.i > len(self.proxy_list)-1:
            self.i = 0
        return self.proxy_list[self.i]

    def get_random_proxy(self):
        return self.proxy_list[random.randint(0, len(self.proxy_list)-1)]

    def remove(self, proxy):
        if proxy in self.proxy_list:

            if proxy in self.fail_stat:
                self.fail_stat[proxy] = self.fail_stat[proxy] + 1
            else:
                self.fail_stat[proxy] = 1

            if self.fail_stat[proxy] >= 3:
                self.proxy_list.remove(proxy)

                if self.stat[proxy] > 1:
                    self.stat[proxy] = self.stat[proxy] - 1
                else:
                    self.stat.pop(proxy)

    def refresh(self, proxy):
        self.fail_stat[proxy] = 0

    def add(self, proxy):
        if self.get_length() < self.max_length and self.__get_switch(proxy):

            if proxy in self.stat:
                self.stat[proxy] = self.stat[proxy] + 1
            else:
                self.stat[proxy] = 1

            self.proxy_list.append(proxy)

            self.diff_list.append(sum([self.stat[i] for i in self.stat])/len(self.stat))

            if len(self.diff_list) >= math.ceil(math.log(len(self.proxy_list))) and len(set(self.diff_list)) == 1:
                self.diff = self.diff + 1

            if len(self.diff_list) >= math.ceil(math.log(len(self.proxy_list))):
                self.diff_list.clear()

    def get_length(self):
        return len(self.proxy_list)

    def __get_switch(self, proxy):
        if self.stat[proxy] <= sum([self.stat[i] for i in self.stat])/len(self.stat) + self.diff:
            return True
        else:
            return False
