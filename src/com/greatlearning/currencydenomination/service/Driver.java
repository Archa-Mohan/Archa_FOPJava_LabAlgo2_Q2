package com.greatlearning.currencydenomination.service;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the size of currency denominations");
		int denominationArraySize = sc.nextInt();

		int[] denominationArray = new int[denominationArraySize];
		System.out.println("Enter the currency denominations value");
		for (int i = 0; i < denominationArraySize; i++) {
			denominationArray[i] = sc.nextInt();
		}

		// To sort the array create an object of merge sort class and call the sort
		// function.This will return the sorted array.
		MergeSort ms = new MergeSort();
		denominationArray = ms.merge_sort(denominationArray);
		
		// Input the amount to be paid
		System.out.println("enter the amount you want to pay");
		int amountPayable = sc.nextInt();

		// Business logic for finding the no. required of each denomination.
		int[] currencyCounter = new int[denominationArraySize];
		for (int i = 0; i < denominationArraySize; i++) {
			currencyCounter[i] = Math.floorDiv(amountPayable, denominationArray[i]);
			amountPayable %= denominationArray[i];
			if (amountPayable == 0) {
				break;
			}
		}

		// If the amount payable can be paid in full using combination of denomination
		// in hand, display the combination. Else print can't pay.

		if (amountPayable == 0) {
			System.out.println("Your payment approach in order to give min no of notes will be");
			for (int i = 0; i < denominationArraySize; i++) {
				if (currencyCounter[i] > 0)
					System.out.println(denominationArray[i] + " : " + currencyCounter[i]);
			}
		} else {
			System.out.println("This amount can't be paid with available denomination");
		}

		sc.close();
	}

}
