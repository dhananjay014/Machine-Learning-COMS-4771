from scipy.io import loadmat
ocr = loadmat('ocr.mat')

import numpy as np
import math
import timeit
import random

start = timeit.default_timer()
test_data = np.array(ocr['testdata']).astype(np.float)
test_labels = np.array(ocr['testlabels'])
training_labels = np.array(ocr['labels'])
Values = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

indices_label_0 = np.where(training_labels == 0)[0]
indices_label_1 = np.where(training_labels == 1)[0]
indices_label_2 = np.where(training_labels == 2)[0]
indices_label_3 = np.where(training_labels == 3)[0]
indices_label_4 = np.where(training_labels == 4)[0]
indices_label_5 = np.where(training_labels == 5)[0]
indices_label_6 = np.where(training_labels == 6)[0]
indices_label_7 = np.where(training_labels == 7)[0]
indices_label_8 = np.where(training_labels == 8)[0]
indices_label_9 = np.where(training_labels == 9)[0]

def NN_classifier(training_data, training_labels, test_data, test_labels, m_value, iteration_no):
    preds = np.empty((len(test_labels), 1), int)
    print "M : %r ; Iteration : %r" % (m_value, iteration_no)
    Test_Test = np.transpose(np.sum(test_data * test_data, axis=1)[np.newaxis])
    TD_TD = np.sum(training_data * training_data, axis=1)
    Test_TD = np.dot(test_data, training_data.T)
    diff = Test_Test + TD_TD - 2 * Test_TD
    lowest_norm_indices = np.argmin(diff, 1)
    preds = training_labels[lowest_norm_indices]
    error_array = (preds != test_labels)
    error_count = sum(error_array)
    return error_count

m = [1000, 2000, 4000, 8000]

data_indices = []
iterations = 10
error_count_mean_array = []
error_count_std_array = []

for i in m:
    x = i / len(Values)
    error_count_array = []
    for j in range(0, iterations):
        data_index_0 = random.sample(indices_label_0, x)
        data_index_1 = random.sample(indices_label_1, x)
        data_index_2 = random.sample(indices_label_2, x)
        data_index_3 = random.sample(indices_label_3, x)
        data_index_4 = random.sample(indices_label_4, x)
        data_index_5 = random.sample(indices_label_5, x)
        data_index_6 = random.sample(indices_label_6, x)
        data_index_7 = random.sample(indices_label_7, x)
        data_index_8 = random.sample(indices_label_8, x)
        data_index_9 = random.sample(indices_label_9, x)

        data_indices = []
        data_indices = np.append(data_indices,
                                 [data_index_0, data_index_1, data_index_2, data_index_3, data_index_4, data_index_5,
                                  data_index_6, data_index_7, data_index_8, data_index_9])
        data_indices = data_indices.astype(int)
        training_data = ocr['data'][data_indices].astype(np.float)
        training_labels = ocr['labels'][data_indices]
        error_count = NN_classifier(training_data, training_labels, test_data, test_labels, i, j)
        error_count_array.append(error_count)
    error_count_array = [x / float(len(test_data)) * 100 for x in error_count_array]
    error_count_std_array.append(np.std(error_count_array))
    error_count_mean_array.append(np.mean(error_count_array))

print error_count_mean_array
print error_count_std_array

stop = timeit.default_timer()
time_taken = stop - start
print time_taken

import matplotlib.pyplot as plt
plt.errorbar(m,error_count_mean_array,yerr=error_count_std_array)
plt.axis([500,8500,0,15])
plt.xlabel('n')
plt.ylabel('Error rate')
plt.show()