package com.greatlearning.currencydenomination.service;

import java.util.Arrays;

public class MergeSort {
	public int[] merge_sort(int[] input) {
		if (input.length <= 1)
			return input;

		int mid = input.length / 2;
		int[] leftArr = merge_sort(Arrays.copyOfRange(input, 0, mid));
		int[] rightArr = merge_sort(Arrays.copyOfRange(input, mid, input.length));
		return merge(leftArr, rightArr);
	}
	
	public int[] merge(int[] leftArr, int[] rightArr) {
		int[] result = new int[leftArr.length + rightArr.length];
		int i = 0, j = 0, k = 0;
		
		while (i < leftArr.length && j < rightArr.length) {
			if (leftArr[i] >= rightArr[j]) {
				result[k] = leftArr[i];
				i++;
			} else {
				result[k] = rightArr[j];
				j++;
			}
			k++;
		}
		
		while (i < leftArr.length) {
			result[k] = leftArr[i];
			i++;
			k++;
		}
		
		while (j < rightArr.length) {
			result[k] = rightArr[j];
			k++;
			j++;
		}
		
		return result;
	}
}
