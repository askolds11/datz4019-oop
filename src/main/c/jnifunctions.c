#include <stdio.h>
#include <stdlib.h>
#include "../../../lib/jtm_extra12_JNIClass.h" // Reference to generated JNI header file

char *createArray(int size) {
	// Allocate memory for array of specified size plus null byte
	char *array = malloc((sizeof(char) * size) + 1);
	int i, shift = 32;
	for (i = 0; i < size; ++i) { // Generate content of array with visible ASCII codes
		shift = 32 - (i / 95) * 95;
		array[i] = i + shift;
	}
	array[i] = 0; // null byte as end mark of string
	printf("createArray:%s\n", array);
	return array;                      // Return pointer to array
}

void printArray(const char *array) {
	printf("printArray:%s\n", array);
}

void freeArray(char *array) {
	// free the memory when done with the array
	free(array);
	printf("freeArray\n");
}

void printHello() {
	printf("Hello World!\n");
}

/*****************************************************************
 * TODO export JNI functions and prepare Java to C data mapping  *
 *****************************************************************/


// Following main() method is for testing purposes.
// Look at TODO.html how to compile this file as executable binary
int main() {
	printHello();
}
