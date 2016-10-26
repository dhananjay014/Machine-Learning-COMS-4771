from scipy.io import loadmat
ocr = loadmat('ocr.mat')

import numpy as np
import timeit
import random
import math

test_data = np.array(ocr['testdata']).astype(np.float)
testlabels = np.array(ocr['testlabels'])

iterations = 10
n = [1000,2000,4000,8000]
count_mean_array = []
count_std_array = []
start = timeit.default_timer()
for current_n in n:
    count_array = []
    for j in range(iterations) :
        preds = np.empty((len(testlabels),1),int)
        sel = random.sample(xrange(60000),current_n)
        training_data = np.array(ocr['data'][sel]).astype(np.float)
        training_labels = ocr['labels'][sel]
        print "N : %r ; Iteration : %r" % (current_n,j)
        Test_Test = np.transpose(np.sum(test_data*test_data,axis = 1)[np.newaxis])
        TD_TD = np.sum(training_data*training_data,axis = 1)
        Test_TD = np.dot(test_data,training_data.T)
        diff = Test_Test + TD_TD - 2*Test_TD
        lowest_norm_indices = np.argmin(diff,1)
        preds = training_labels[lowest_norm_indices]
        error_array = (preds!=testlabels)
        error_count = sum(error_array)
        count_array.append(error_count)
    count_array = [x / float(len(test_data)) * 100 for x in count_array]

    count_std_array.append(np.std(count_array))
    count_mean_array.append(np.mean(count_array))

print count_mean_array
print count_std_array

stop = timeit.default_timer()
time_taken = stop - start
print time_taken

import matplotlib.pyplot as plt
plt.errorbar(n,count_mean_array,yerr=count_std_array)
plt.axis([500,8500,0,15])
plt.title('Problem 1 Part (1) Learning Curve Plot')
plt.xlabel('n')
plt.ylabel('Error rate')
plt.show()