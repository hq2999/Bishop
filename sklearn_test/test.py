#coding:utf-8
import jieba
import re

data_train = []
target_train = []

data_test = []
target_test = []

true_data = []
with open('./true_case.txt', 'r', encoding='utf-8') as f:
    true_date_line = f.readlines()

with open('./case.txt', 'r', encoding='utf-8') as f:
    data_line = f.readlines()

with open('./target.txt', 'r', encoding='utf-8') as f:
    target_line = f.readlines()

for ix, line in enumerate(true_date_line):
    line = re.sub('[\n，。？！：、0-9]', '', line)
    seg_list = jieba.lcut(line)
    line = ' '.join(seg_list)
    true_data.append(line)

for ix, line in enumerate(data_line):
    line = re.sub('[\n，。？！：、0-9]', '', line)
    seg_list = jieba.lcut(line)
    line = ' '.join(seg_list)

    target = int(target_line[ix].replace('\n', ''))

    if ix < 1000:
        data_train.append(line)
        target_train.append(target)
    else:
        data_test.append(line)
        target_test.append(target)

# import sys, io
# sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf8')

import numpy as np
from sklearn.datasets import fetch_20newsgroups
# categories = ['alt.atheism', 'soc.religion.christian', 'comp.graphics', 'sci.med']
# train_data = fetch_20newsgroups(subset='train', shuffle=True, categories=categories, random_state=10)

from sklearn.feature_extraction.text import TfidfVectorizer
tfidf_transformer = TfidfVectorizer()
tf_train_data = tfidf_transformer.fit_transform(data_train)

from sklearn.svm import SVC

clf = SVC(kernel='linear').fit(tf_train_data, np.array(target_train))

# clf = SVC(kernel='rbf', C=2).fit(tf_train_data, np.array(target_train))
tf_test_data = tfidf_transformer.transform(data_test)
predicted = clf.predict(tf_test_data)

tf_true_data = tfidf_transformer.transform(true_data)
predicted = clf.predict(tf_true_data)

print("训练集评分:", clf.score(tf_train_data, target_train))
print("测试集评分", clf.score(tf_test_data, target_test))

from sklearn.decomposition import TruncatedSVD
from sklearn.preprocessing import Normalizer
from sklearn.pipeline import make_pipeline

svd = TruncatedSVD(3)
normalizer = Normalizer(copy=False)
lsa = make_pipeline(svd, normalizer)
Xnew = lsa.fit_transform(tf_train_data)

import matplotlib.pyplot as plt
#
# plt.scatter(Xnew[:,0], Xnew[:,1], c='')
# plt.show()

ax = plt.axes(projection='3d')

# print(np.where(np.array(target_train)==0))

# print(Xnew[[np.where(np.array(target_train)==0)], 0])

# 三维散点的数据

# ax.scatter3D(Xnew[[np.where(np.array(target_train)==0)], 0]
#            , Xnew[[np.where(np.array(target_train)==0)], 1]
#            , Xnew[[np.where(np.array(target_train)==0)], 2]
#            , c=Xnew[[np.where(np.array(target_train)==0)], 2], cmap='Greens')
#
# ax.scatter3D(Xnew[[np.where(np.array(target_train)==1)], 0]
#            , Xnew[[np.where(np.array(target_train)==1)], 1]
#            , Xnew[[np.where(np.array(target_train)==1)], 2]
#            , c=Xnew[[np.where(np.array(target_train)==1)], 2], cmap='Oranges')
#
# plt.show()