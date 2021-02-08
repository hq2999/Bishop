#coding:utf-8
import jieba
import re

data_in = []

with open('./case.txt', 'r', encoding='utf-8') as f:
    lines = f.readlines()
    for line in lines:
        line = re.sub('[\n，。？！：]', '', line)
        # seg_list = jieba.lcut(line)
        data_in.append(line)

import sys, io
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf8')

import numpy as np
from sklearn.datasets import fetch_20newsgroups
categories = ['alt.atheism', 'soc.religion.christian', 'comp.graphics', 'sci.med']
train_data = fetch_20newsgroups(subset='train', shuffle=True, categories=categories, random_state=10)

from sklearn.feature_extraction.text import TfidfVectorizer
tfidf_transformer = TfidfVectorizer()

tf_train_data = tfidf_transformer.fit_transform(train_data.data)

print(np.shape(tf_train_data))
print(np.shape(train_data.target))

#
# from sklearn.svm import SVC
# # print(tf_train_data)
#
# clf = SVC(kernel='linear').fit(tf_train_data, train_data.target)
#
# # clf = SVC(kernel='rbf', C=1.5).fit(tf_train_data, train_data.target)
#
# docs_new = ['God is love', 'OpenGL on the GPU is fast']
# tf_docs_new = tfidf_transformer.transform(docs_new)
# predicted = clf.predict(tf_docs_new)
# for doc, category in zip(docs_new, predicted):
#     print(doc + '>>' + train_data.target_names[category])
#
# test_data = fetch_20newsgroups(subset='test', shuffle=True, categories=categories,random_state=23)
# tf_test_data = tfidf_transformer.transform(test_data.data)
# predicted = clf.predict(tf_test_data)
# print("训练集评分:", clf.score(tf_train_data, train_data.target))
# print("测试集评分", clf.score(tf_test_data, test_data.target))

