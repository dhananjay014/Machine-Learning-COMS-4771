
#Importing libraries
import csv
import numpy as np
import timeit
import scipy.io as io
import random

#Importing vectorizers
from sklearn.feature_extraction.text import CountVectorizer
from sklearn.feature_extraction.text import TfidfTransformer
from sklearn.naive_bayes import BernoulliNB

#Importing training data
csv_file_object_tr = csv.reader(open("reviews_tr.csv",'rb'))
header_tr = csv_file_object_tr.next()
training_data = []
training_labels = []
for row in csv_file_object_tr :
    training_data.append(row[1])
    training_labels.append(row[0])
    count = count+1;
    if(count == 200000) :
        break


training_labels[:] = map(float,training_labels)
training_labels[:] = [2*x - 1 for x in training_labels]
k = 5
kfold_size = len(training_data)/k

training_labels = np.asarray(training_labels)
training_labels = training_labels[:,np.newaxis]

# Function for Perceptron
def perceptron(training_data,training_labels,test_data,test_labels) :
    w = np.zeros((1,training_data.shape[1]))
    b=0.0
    beta = 0.0
    u = np.zeros((1,training_data.shape[1]))

    for iter in range(1,3) :
        c = 0.0
        w_total = 0.0
        b_total = 0.0
        w_previous = w
        b_previous = b
        rand_indices = random.sample(xrange(training_data.shape[0]),training_data.shape[0])
        for i in rand_indices :
            if ((training_labels[i][0])*((training_data[i].dot(w.T)) + b) <= 0) :
                w = w + training_labels[i][0]*training_data[i]
                b = b + training_labels[i][0]
                if (iter == 2) :
                    w_total = w_total+(c+2)*w
                    b_total = b_total+(c+2)*b
            c = c+1
 
    w = (w_total + w_previous)/(c+1)
    b = (b_total + b_previous)/(c+1)

    preds = test_data.dot(w.T)
    error_array = ((np.multiply(preds,test_labels)) < 0)
    error_count = np.sum(error_array)
    print error_count
    print (float)(error_count)/test_data.shape[0]
    error_rate = (float)(error_count)/test_data.shape[0]
    return error_rate

#Dividing training data and labels into chunks so that we can make kfolds out of it
data_chunk1  = training_data[0:kfold_size]
data_chunk2  = training_data[kfold_size:2*kfold_size]
data_chunk3  = training_data[2*kfold_size:3*kfold_size]
data_chunk4  = training_data[3*kfold_size:4*kfold_size]
data_chunk5  = training_data[4*kfold_size:5*kfold_size]
label_chunk1 = training_labels[0:kfold_size]
label_chunk2 = training_labels[kfold_size:2*kfold_size]
label_chunk3 = training_labels[2*kfold_size:3*kfold_size]
label_chunk4 = training_labels[3*kfold_size:4*kfold_size]
label_chunk5 = training_labels[4*kfold_size:5*kfold_size]

training_data_kfold_1 = []
training_data_kfold_2 = []
training_data_kfold_3 = []
training_data_kfold_4 = []
training_data_kfold_5 = []

#Making kfolds
training_data_kfold_1.extend(data_chunk1 + data_chunk2 + data_chunk3 + data_chunk4)
cv_data_kfold_1 = data_chunk5
training_data_kfold_2.extend(data_chunk1 + data_chunk2 + data_chunk3 + data_chunk5)
cv_data_kfold_2 = data_chunk4
training_data_kfold_3.extend(data_chunk1 + data_chunk2 + data_chunk4 + data_chunk5)
cv_data_kfold_3 = data_chunk3
training_data_kfold_4.extend(data_chunk1 + data_chunk3 + data_chunk4 + data_chunk5)
cv_data_kfold_4 = data_chunk2
training_data_kfold_5.extend(data_chunk2 + data_chunk3 + data_chunk4 + data_chunk5)
cv_data_kfold_5 = data_chunk1

training_labels_kfold_1 = np.concatenate((label_chunk1,label_chunk2,label_chunk3,label_chunk4),axis=0)
training_labels_kfold_2 = np.concatenate((label_chunk1,label_chunk2,label_chunk3,label_chunk5),axis=0)
training_labels_kfold_3 = np.concatenate((label_chunk1,label_chunk2,label_chunk4,label_chunk5),axis=0)
training_labels_kfold_4 = np.concatenate((label_chunk1,label_chunk3,label_chunk4,label_chunk5),axis=0)
training_labels_kfold_5 = np.concatenate((label_chunk2,label_chunk3,label_chunk4,label_chunk5),axis=0)
cv_labels_kfold_1 = label_chunk5
cv_labels_kfold_2 = label_chunk4
cv_labels_kfold_3 = label_chunk3
cv_labels_kfold_4 = label_chunk2
cv_labels_kfold_5 = label_chunk1

#UNIGRAM KFOLD 1
cvec = CountVectorizer(min_df=0,token_pattern='\\b\\w+\\b')
unigram_data_kfold_1 = cvec.fit_transform(training_data_kfold_1)
unigram_cv_data_kfold_1 = cvec.transform(cv_data_kfold_1)
error_rate_uni_kfold_1 = perceptron(unigram_data_kfold_1,training_labels_kfold_1,unigram_cv_data_kfold_1,cv_labels_kfold_1)
error_rate_uni_kfold_1

#UNIGRAM KFOLD 2
unigram_data_kfold_2 = cvec.fit_transform(training_data_kfold_2)
unigram_cv_data_kfold_2 = cvec.transform(cv_data_kfold_2)
error_rate_uni_kfold_2 = perceptron(unigram_data_kfold_2,training_labels_kfold_2,unigram_cv_data_kfold_2,cv_labels_kfold_2)
error_rate_uni_kfold_2

#UNIGRAM KFOLD 3
unigram_data_kfold_3 = cvec.fit_transform(training_data_kfold_3)
unigram_cv_data_kfold_3 = cvec.transform(cv_data_kfold_3)
error_rate_uni_kfold_3 = perceptron(unigram_data_kfold_3,training_labels_kfold_3,unigram_cv_data_kfold_3,cv_labels_kfold_3)
error_rate_uni_kfold_3

#UNIGRAM KFOLD 4
unigram_data_kfold_4 = cvec.fit_transform(training_data_kfold_4)
unigram_cv_data_kfold_4 = cvec.transform(cv_data_kfold_4)
error_rate_uni_kfold_4 = perceptron(unigram_data_kfold_4,training_labels_kfold_4,unigram_cv_data_kfold_4,cv_labels_kfold_4)
error_rate_uni_kfold_4

#UNIGRAM KFOLD 5
unigram_data_kfold_5 = cvec.fit_transform(training_data_kfold_5)
unigram_cv_data_kfold_5 = cvec.transform(cv_data_kfold_5)
error_rate_uni_kfold_5 = perceptron(unigram_data_kfold_5,training_labels_kfold_5,unigram_cv_data_kfold_5,cv_labels_kfold_5)
error_rate_uni_kfold_5

#UNIGRAM AVERAGE ERROR RATE
ave_error_rate_unigram = (error_rate_uni_kfold_1 + error_rate_uni_kfold_2 + error_rate_uni_kfold_3 + error_rate_uni_kfold_4 + error_rate_uni_kfold_5)/5
print ave_error_rate_unigram


# TFIDF KFOLD 1
ttran = TfidfTransformer(norm=None,smooth_idf=False)
tfidf_data_kfold_1 = ttran.fit_transform(unigram_data_kfold_1)
tfidf_data_kfold_1 = (tfidf_data_kfold_1 - unigram_data_kfold_1) * (np.log10(np.exp(1)))
tfidf_cv_data_kfold_1 = ttran.transform(unigram_cv_data_kfold_1)
tfidf_cv_data_kfold_1 = (tfidf_cv_data_kfold_1 - unigram_cv_data_kfold_1) * (np.log10(np.exp(1)))
error_rate_tfidf_kfold_1 = perceptron(tfidf_data_kfold_1,training_labels_kfold_1,tfidf_cv_data_kfold_1,cv_labels_kfold_1)
error_rate_tfidf_kfold_1

# TFIDF KFOLD 2
tfidf_data_kfold_2 = ttran.fit_transform(unigram_data_kfold_2)
tfidf_data_kfold_2 = (tfidf_data_kfold_2 - unigram_data_kfold_2) * (np.log10(np.exp(1)))
tfidf_cv_data_kfold_2 = ttran.transform(unigram_cv_data_kfold_2)
tfidf_cv_data_kfold_2 = (tfidf_cv_data_kfold_2 - unigram_cv_data_kfold_2) * (np.log10(np.exp(1)))
error_rate_tfidf_kfold_2 = perceptron(tfidf_data_kfold_2,training_labels_kfold_2,tfidf_cv_data_kfold_2,cv_labels_kfold_2)
error_rate_tfidf_kfold_2

# TFIDF KFOLD 3 
tfidf_data_kfold_3 = ttran.fit_transform(unigram_data_kfold_3)
tfidf_data_kfold_3 = (tfidf_data_kfold_3 - unigram_data_kfold_3) * (np.log10(np.exp(1)))
tfidf_cv_data_kfold_3 = ttran.transform(unigram_cv_data_kfold_3)
tfidf_cv_data_kfold_3 = (tfidf_cv_data_kfold_3 - unigram_cv_data_kfold_3) * (np.log10(np.exp(1)))
error_rate_tfidf_kfold_3 = perceptron(tfidf_data_kfold_3,training_labels_kfold_3,tfidf_cv_data_kfold_3,cv_labels_kfold_3)
error_rate_tfidf_kfold_3

# TFIDF KFOLD 4
tfidf_data_kfold_4 = ttran.fit_transform(unigram_data_kfold_4)
tfidf_data_kfold_4 = (tfidf_data_kfold_4 - unigram_data_kfold_4) * (np.log10(np.exp(1)))
tfidf_cv_data_kfold_4 = ttran.transform(unigram_cv_data_kfold_4)
tfidf_cv_data_kfold_4 = (tfidf_cv_data_kfold_4 - unigram_cv_data_kfold_4) * (np.log10(np.exp(1)))
error_rate_tfidf_kfold_4 = perceptron(tfidf_data_kfold_4,training_labels_kfold_4,tfidf_cv_data_kfold_4,cv_labels_kfold_4)
error_rate_tfidf_kfold_4

# TFIDF KFOLD 5
tfidf_data_kfold_5 = ttran.fit_transform(unigram_data_kfold_5)
tfidf_data_kfold_5 = (tfidf_data_kfold_5 - unigram_data_kfold_5) * (np.log10(np.exp(1)))
tfidf_cv_data_kfold_5 = ttran.transform(unigram_cv_data_kfold_5)
tfidf_cv_data_kfold_5 = (tfidf_cv_data_kfold_5 - unigram_cv_data_kfold_5) * (np.log10(np.exp(1)))
error_rate_tfidf_kfold_5 = perceptron(tfidf_data_kfold_5,training_labels_kfold_5,tfidf_cv_data_kfold_5,cv_labels_kfold_5)
error_rate_tfidf_kfold_5

#TFIDF AVERAGE ERROR RATE
ave_error_rate_tfidf = (error_rate_tfidf_kfold_1 + error_rate_tfidf_kfold_2 + error_rate_tfidf_kfold_3 + error_rate_tfidf_kfold_4 + error_rate_tfidf_kfold_5)/5
print ave_error_rate_tfidf

#Function for Naive Bayes
def naive_bayes(training_data,training_labels,test_data,test_labels) :
    clf = BernoulliNB()
    test_labels = np.squeeze(test_labels)
    training_labels = np.squeeze(training_labels)
    clf.fit(training_data, training_labels)
    preds = clf.predict(test_data)
    error = (preds!=test_labels)
    error_count = np.sum(error)
    error_rate = (float)(error_count)/test_labels.shape[0]
    return error_rate

# NAIVE BAYES KFOLD 1, KFOLD 2, KFOLD 3, KFOLD 4, KFOLD 5
error_rate_nb_kfold_1 = naive_bayes(unigram_data_kfold_1,training_labels_kfold_1,unigram_cv_data_kfold_1,cv_labels_kfold_1)
error_rate_nb_kfold_2 = naive_bayes(unigram_data_kfold_2,training_labels_kfold_2,unigram_cv_data_kfold_2,cv_labels_kfold_2)
error_rate_nb_kfold_3 = naive_bayes(unigram_data_kfold_3,training_labels_kfold_3,unigram_cv_data_kfold_3,cv_labels_kfold_3)
error_rate_nb_kfold_4 = naive_bayes(unigram_data_kfold_4,training_labels_kfold_4,unigram_cv_data_kfold_4,cv_labels_kfold_4)
error_rate_nb_kfold_5 = naive_bayes(unigram_data_kfold_5,training_labels_kfold_5,unigram_cv_data_kfold_5,cv_labels_kfold_5)
print error_rate_nb_kfold_1
print error_rate_nb_kfold_2
print error_rate_nb_kfold_3
print error_rate_nb_kfold_4
print error_rate_nb_kfold_5

#NAIVE BAYES AVERAGE ERROR RATE
ave_error_rate_nb = (error_rate_nb_kfold_1 + error_rate_nb_kfold_2 + error_rate_nb_kfold_3 + error_rate_nb_kfold_4 + error_rate_nb_kfold_5)/5
print ave_error_rate_nb


# MY METHOD - SUBLINEAR TF, KFOLD 1
ttran = TfidfTransformer(norm=None,smooth_idf=False,sublinear_tf=True)
sublin_data_kfold_1 = ttran.fit_transform(unigram_data_kfold_1)
sublin_cv_data_kfold_1 = ttran.transform(unigram_cv_data_kfold_1)
error_rate_sublin_kfold_1 = perceptron(sublin_data_kfold_1,training_labels_kfold_1,sublin_cv_data_kfold_1,cv_labels_kfold_1)
error_rate_sublin_kfold_1

# MY METHOD - SUBLINEAR TF, KFOLD 2
sublin_data_kfold_2 = ttran.fit_transform(unigram_data_kfold_2)
sublin_cv_data_kfold_2 = ttran.transform(unigram_cv_data_kfold_2)
error_rate_sublin_kfold_2 = perceptron(sublin_data_kfold_2,training_labels_kfold_2,sublin_cv_data_kfold_2,cv_labels_kfold_2)
error_rate_sublin_kfold_2

# MY METHOD - SUBLINEAR TF, KFOLD 3
sublin_data_kfold_3 = ttran.fit_transform(unigram_data_kfold_3)
sublin_cv_data_kfold_3 = ttran.transform(unigram_cv_data_kfold_3)
error_rate_sublin_kfold_3 = perceptron(sublin_data_kfold_3,training_labels_kfold_3,sublin_cv_data_kfold_3,cv_labels_kfold_3)
error_rate_sublin_kfold_3

# MY METHOD - SUBLINEAR TF, KFOLD 4
sublin_data_kfold_4 = ttran.fit_transform(unigram_data_kfold_4)
sublin_cv_data_kfold_4 = ttran.transform(unigram_cv_data_kfold_4)
error_rate_sublin_kfold_4 = perceptron(sublin_data_kfold_4,training_labels_kfold_4,sublin_cv_data_kfold_4,cv_labels_kfold_4)
error_rate_sublin_kfold_4

# MY METHOD - SUBLINEAR TF, KFOLD 5
sublin_data_kfold_5 = ttran.fit_transform(unigram_data_kfold_5)
sublin_cv_data_kfold_5 = ttran.transform(unigram_cv_data_kfold_5)
error_rate_sublin_kfold_5 = perceptron(sublin_data_kfold_5,training_labels_kfold_5,sublin_cv_data_kfold_5,cv_labels_kfold_5)
error_rate_sublin_kfold_5

#SUBLINEAR AVERAGE ERROR RATE
ave_error_rate_sublin = (error_rate_sublin_kfold_1 + error_rate_sublin_kfold_2 + error_rate_sublin_kfold_3 + error_rate_sublin_kfold_4 + error_rate_sublin_kfold_5)/5
print ave_error_rate_sublin


csv_file_object_te = csv.reader(open("reviews_te.csv",'rb'))
header_te = csv_file_object_te.next()
test_data = []
test_labels = []
for row in csv_file_object_te :
    test_data.append(row[1])
    test_labels.append(row[0])
        
test_labels[:] = map(float,test_labels)
test_labels[:] = [2*x - 1 for x in test_labels]
test_labels = np.asarray(test_labels)
test_labels = test_labels[:,np.newaxis]

print len(test_data)

# BIGRAM KFOLD 1
cvec2 = CountVectorizer(ngram_range=(1,2),min_df=0,token_pattern='\\b\\w+\\b')
bigram_data_kfold_1 = cvec2.fit_transform(training_data_kfold_1)
bigram_cv_data_kfold_1 = cvec2.transform(cv_data_kfold_1)
error_rate_bigram_kfold_1 = perceptron(bigram_data_kfold_1,training_labels_kfold_1,bigram_cv_data_kfold_1,cv_labels_kfold_1)
error_rate_bigram_kfold_1

# BIGRAM KFOLD 2
bigram_data_kfold_2 = cvec2.fit_transform(training_data_kfold_2)
bigram_cv_data_kfold_2 = cvec2.transform(cv_data_kfold_2)
error_rate_bigram_kfold_2 = perceptron(bigram_data_kfold_2,training_labels_kfold_2,bigram_cv_data_kfold_2,cv_labels_kfold_2)
error_rate_bigram_kfold_2

# BIGRAM KFOLD 3
bigram_data_kfold_3 = cvec2.fit_transform(training_data_kfold_3)
bigram_cv_data_kfold_3 = cvec2.transform(cv_data_kfold_3)
error_rate_bigram_kfold_3 = perceptron(bigram_data_kfold_3,training_labels_kfold_3,bigram_cv_data_kfold_3,cv_labels_kfold_3)
error_rate_bigram_kfold_3

# BIGRAM KFOLD 4
bigram_data_kfold_4 = cvec2.fit_transform(training_data_kfold_4)
bigram_cv_data_kfold_4 = cvec2.transform(cv_data_kfold_4)
error_rate_bigram_kfold_4 = perceptron(bigram_data_kfold_4,training_labels_kfold_4,bigram_cv_data_kfold_4,cv_labels_kfold_4)
error_rate_bigram_kfold_4

# BIGRAM KFOLD 5
bigram_data_kfold_5 = cvec2.fit_transform(training_data_kfold_5)
bigram_cv_data_kfold_5 = cvec2.transform(cv_data_kfold_5)
error_rate_bigram_kfold_5 = perceptron(bigram_data_kfold_5,training_labels_kfold_5,bigram_cv_data_kfold_5,cv_labels_kfold_5)
error_rate_bigram_kfold_5

#BIGRAM AVERAGE ERROR RATE
ave_error_rate_bigram = (error_rate_bigram_kfold_1 + error_rate_bigram_kfold_2 + error_rate_bigram_kfold_3 + error_rate_bigram_kfold_4 + error_rate_bigram_kfold_5)/5
print ave_error_rate_bigram

