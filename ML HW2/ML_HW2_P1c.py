from scipy.io import loadmat
from scipy.sparse import csr_matrix
import scipy
import numpy as np
import timeit

start = timeit.default_timer()
news = loadmat('news.mat')

training_labels = np.array(news['labels'])
training_data = news['data'].toarray()
test_data = news['testdata'].toarray()
test_labels = np.array(news['testlabels'])

Training_Data_Label_0 =  training_data[np.where((training_labels == 1) | (training_labels == 16) | (training_labels == 20))[0]]
Training_Data_Label_1 =  training_data[np.where((training_labels == 17) | (training_labels == 18) | (training_labels == 19))[0]]

Test_Data_Label_0 = test_data[np.where((test_labels == 1) | (test_labels == 16) | (test_labels == 20))[0]]
Test_Data_Label_1 = test_data[np.where((test_labels == 17) | (test_labels == 18) | (test_labels == 19))[0]]

test_data_modified = np.vstack((Test_Data_Label_0,Test_Data_Label_1))
training_data_modified = np.vstack((Training_Data_Label_0,Training_Data_Label_1))

Training_Labels_Label_0 = training_labels[np.where((training_labels == 1) | (training_labels == 16) | (training_labels == 20))[0]]
Training_Labels_Label_1 = training_labels[np.where((training_labels == 17) | (training_labels == 18) | (training_labels == 19))[0]]

Training_Labels_Label_0[:] = 0
Training_Labels_Label_1[:] = 1

Test_Labels_Label_0 = test_labels[np.where((test_labels == 1) | (test_labels == 16) | (test_labels == 20))[0]]
Test_Labels_Label_1 = test_labels[np.where((test_labels == 17) | (test_labels == 18) | (test_labels == 19))[0]]

Test_Labels_Label_0[:] = 0
Test_Labels_Label_1[:] = 1

training_labels_modified = np.vstack((Training_Labels_Label_0,Training_Labels_Label_1))
test_labels_modified = np.vstack((Test_Labels_Label_0,Test_Labels_Label_1))

mu_0 =  (1 + np.sum(Training_Data_Label_0,axis=0))/(2 + Training_Data_Label_0.shape[0])
mu_1 =  (1 + np.sum(Training_Data_Label_1,axis=0))/(2 + Training_Data_Label_1.shape[0])

mu = np.vstack((mu_0,mu_1))

pi0 = float(Training_Data_Label_0.shape[0])/training_data_modified.shape[0]
pi1 = float(Training_Data_Label_1.shape[0])/training_data_modified.shape[0]

pi = np.vstack((pi0,pi1))

J = np.log(pi) + (np.log(mu)).dot(test_data_modified.T) + (np.log(1-mu)).dot(1-test_data_modified.T)
K = np.log(pi) + (np.log(mu)).dot(training_data_modified.T) + (np.log(1-mu)).dot(1-training_data_modified.T)

preds = np.argmax(J.T,axis=1)
preds_training = np.argmax(K.T,axis=1)

preds = preds[:,np.newaxis]
preds_training = preds_training[:,np.newaxis]

test_error_count = sum(preds!=test_labels_modified)
training_error_count = sum(preds_training!=training_labels_modified)

test_error_rate = float(test_error_count)/test_labels_modified.shape[0] * 100
training_error_rate = float(training_error_count)/training_labels_modified.shape[0] * 100

print test_error_count
print test_error_rate

print training_error_count
print training_error_rate

stop = timeit.default_timer()
print "Total time taken"
print stop-start
