
# Importing libraries
import csv
import numpy as np
import timeit
import scipy.io as io
import random

#Importing Vectorizers
from sklearn.feature_extraction.text import CountVectorizer
from sklearn.feature_extraction.text import TfidfTransformer

#Importing training data and labels
csv_file_object_tr = csv.reader(open("reviews_tr.csv",'rb'))
header_tr = csv_file_object_tr.next()
training_data = []
training_labels = []
count = 0
for row in csv_file_object_tr :
    training_data.append(row[1])
    training_labels.append(row[0])
    count = count+1;
    if(count == 200000) :
        break


#Converting training labels
training_labels[:] = map(float,training_labels)
training_labels[:] = [2*x - 1 for x in training_labels]
training_labels = np.asarray(training_labels)
training_labels = training_labels[:,np.newaxis]

#Importing test data and labels
csv_file_object_te = csv.reader(open("reviews_te.csv",'rb'))
header_te = csv_file_object_te.next()
test_data = []
test_labels = []
for row in csv_file_object_te :
    test_data.append(row[1])
    test_labels.append(row[0])
        
#Converting test labels
test_labels[:] = map(float,test_labels)
test_labels[:] = [2*x - 1 for x in test_labels]
test_labels = np.asarray(test_labels)
test_labels = test_labels[:,np.newaxis]


#Perceptron function
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

    preds_te = test_data.dot(w.T)
    preds_tr = training_data.dot(w.T)
    
    error_array_te = ((np.multiply(preds_te,test_labels)) < 0)
    error_array_tr = ((np.multiply(preds_tr,training_labels)) < 0)

    error_count_te = np.sum(error_array_te)
    error_count_tr = np.sum(error_array_tr)
    
    print error_count_te
    print error_count_tr
    
    print (float)(error_count_te)/test_data.shape[0]
    print (float)(error_count_tr)/training_data.shape[0]

    error_rate_te = (float)(error_count_te)/test_data.shape[0]
    error_rate_tr = (float)(error_count_tr)/training_data.shape[0]

    return error_rate_te,error_rate_tr

#Converting training data into bigram data and calculating test and training error rates 
cvec3 = CountVectorizer(ngram_range=(1,2),min_df=0,token_pattern='\\b\\w+\\b')
bigram_training_data = cvec3.fit_transform(training_data)
bigram_test_data = cvec3.transform(test_data)
error_rate_test, error_rate_training = perceptron(bigram_training_data,training_labels,bigram_test_data,test_labels)
print error_rate_test
print error_rate_training