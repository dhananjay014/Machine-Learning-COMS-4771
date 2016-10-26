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

TD_Label_1 =  training_data[np.where(training_labels == 1)[0]]
TD_Label_2 =  training_data[np.where(training_labels == 2)[0]]
TD_Label_3 =  training_data[np.where(training_labels == 3)[0]]
TD_Label_4 =  training_data[np.where(training_labels == 4)[0]]
TD_Label_5 =  training_data[np.where(training_labels == 5)[0]]
TD_Label_6 =  training_data[np.where(training_labels == 6)[0]]
TD_Label_7 =  training_data[np.where(training_labels == 7)[0]]
TD_Label_8 =  training_data[np.where(training_labels == 8)[0]]
TD_Label_9 =  training_data[np.where(training_labels == 9)[0]]
TD_Label_10 = training_data[np.where(training_labels == 10)[0]]
TD_Label_11 = training_data[np.where(training_labels == 11)[0]]
TD_Label_12 = training_data[np.where(training_labels == 12)[0]]
TD_Label_13 = training_data[np.where(training_labels == 13)[0]]
TD_Label_14 = training_data[np.where(training_labels == 14)[0]]
TD_Label_15 = training_data[np.where(training_labels == 15)[0]]
TD_Label_16 = training_data[np.where(training_labels == 16)[0]]
TD_Label_17 = training_data[np.where(training_labels == 17)[0]]
TD_Label_18 = training_data[np.where(training_labels == 18)[0]]
TD_Label_19 = training_data[np.where(training_labels == 19)[0]]
TD_Label_20 = training_data[np.where(training_labels == 20)[0]]

mu_1 =  (1 + np.sum(TD_Label_1,axis=0))/(2 + TD_Label_1.shape[0])
mu_2 =  (1 + np.sum(TD_Label_2,axis=0))/(2 + TD_Label_2.shape[0])
mu_3 =  (1 + np.sum(TD_Label_3,axis=0))/(2 + TD_Label_3.shape[0])
mu_4 =  (1 + np.sum(TD_Label_4,axis=0))/(2 + TD_Label_4.shape[0])
mu_5 =  (1 + np.sum(TD_Label_5,axis=0))/(2 + TD_Label_5.shape[0])
mu_6 =  (1 + np.sum(TD_Label_6,axis=0))/(2 + TD_Label_6.shape[0])
mu_7 =  (1 + np.sum(TD_Label_7,axis=0))/(2 + TD_Label_7.shape[0])
mu_8 =  (1 + np.sum(TD_Label_8,axis=0))/(2 + TD_Label_8.shape[0])
mu_9 =  (1 + np.sum(TD_Label_9,axis=0))/(2 + TD_Label_9.shape[0])
mu_10 = (1 + np.sum(TD_Label_10,axis=0))/(2 + TD_Label_10.shape[0])
mu_11 = (1 + np.sum(TD_Label_11,axis=0))/(2 + TD_Label_11.shape[0])
mu_12 = (1 + np.sum(TD_Label_12,axis=0))/(2 + TD_Label_12.shape[0])
mu_13 = (1 + np.sum(TD_Label_13,axis=0))/(2 + TD_Label_13.shape[0])
mu_14 = (1 + np.sum(TD_Label_14,axis=0))/(2 + TD_Label_14.shape[0])
mu_15 = (1 + np.sum(TD_Label_15,axis=0))/(2 + TD_Label_15.shape[0])
mu_16 = (1 + np.sum(TD_Label_16,axis=0))/(2 + TD_Label_16.shape[0])
mu_17 = (1 + np.sum(TD_Label_17,axis=0))/(2 + TD_Label_17.shape[0])
mu_18 = (1 + np.sum(TD_Label_18,axis=0))/(2 + TD_Label_18.shape[0])
mu_19 = (1 + np.sum(TD_Label_19,axis=0))/(2 + TD_Label_19.shape[0])
mu_20 = (1 + np.sum(TD_Label_20,axis=0))/(2 + TD_Label_20.shape[0])

mu = np.vstack((mu_1,mu_2,mu_3,mu_4,mu_5,mu_6,mu_7,mu_8,mu_9,mu_10,mu_11,mu_12,mu_13,mu_14,mu_15,mu_16,mu_17,mu_18,mu_19,mu_20))

pi1 = float(TD_Label_1.shape[0])/training_data.shape[0]
pi2 = float(TD_Label_2.shape[0])/training_data.shape[0]
pi3 = float(TD_Label_3.shape[0])/training_data.shape[0]
pi4 = float(TD_Label_4.shape[0])/training_data.shape[0]
pi5 = float(TD_Label_5.shape[0])/training_data.shape[0]
pi6 = float(TD_Label_6.shape[0])/training_data.shape[0]
pi7 = float(TD_Label_7.shape[0])/training_data.shape[0]
pi8 = float(TD_Label_8.shape[0])/training_data.shape[0]
pi9 = float(TD_Label_9.shape[0])/training_data.shape[0]
pi10 = float(TD_Label_10.shape[0])/training_data.shape[0]
pi11 = float(TD_Label_11.shape[0])/training_data.shape[0]
pi12 = float(TD_Label_12.shape[0])/training_data.shape[0]
pi13 = float(TD_Label_13.shape[0])/training_data.shape[0]
pi14 = float(TD_Label_14.shape[0])/training_data.shape[0]
pi15 = float(TD_Label_15.shape[0])/training_data.shape[0]
pi16 = float(TD_Label_16.shape[0])/training_data.shape[0]
pi17 = float(TD_Label_17.shape[0])/training_data.shape[0]
pi18 = float(TD_Label_18.shape[0])/training_data.shape[0]
pi19 = float(TD_Label_19.shape[0])/training_data.shape[0]
pi20 = float(TD_Label_20.shape[0])/training_data.shape[0]
time25 = timeit.default_timer()

pi = np.vstack((pi1,pi2,pi3,pi4,pi5,pi6,pi7,pi8,pi9,pi10,pi11,pi12,pi13,pi14,pi15,pi16,pi17,pi18,pi19,pi20))

J = np.log(pi) + (np.log(mu)).dot(test_data.T) + (np.log(1-mu)).dot(1-test_data.T)
K = np.log(pi) + (np.log(mu)).dot(training_data.T) + (np.log(1-mu)).dot(1-training_data.T)

preds = np.argmax(J.T,axis=1)
preds_training = np.argmax(K.T,axis=1)

preds = preds+1
preds_training = preds_training + 1

preds = preds[:,np.newaxis]
preds_training = preds_training[:,np.newaxis]

test_error_count = sum(preds!=test_labels)
training_error_count = sum(preds_training!=training_labels)

test_error_rate = float(test_error_count)/test_labels.shape[0] * 100
training_error_rate = float(training_error_count)/training_labels.shape[0] * 100

print test_error_count
print test_error_rate

print training_error_count
print training_error_rate

stop = timeit.default_timer()
print "Total time taken"
print stop-start