#include<stdio.h>
#include<stdlib.h>
#include<string.h>

char * reverse(char input[])
{
	// inplaced reverse	
	char *end = input;
	while(*end != '\0'){
		end++;
	}
	end--;

	char * start = input;
	while(end > start){
		char t = *end;
		*end = *start;
		*start = t; 	
		end--;
		start++;
	}
	return input;
}
#define MAX_STR_LEN 100
int main(){
	int size = 6;
	char *str[] = {
		"a",
		"ab",
		"abc",
		"",
		"aa",
		"abcdefghigh",
	};
	char * temp = malloc( sizeof(char) * MAX_STR_LEN );
	if( NULL != temp ){
		for(int i=0; i<size; i++){
			strncpy(temp, str[i], MAX_STR_LEN);
			printf("ori = %s, reversed = %s\n", str[i], reverse(temp));
		}
		free(temp);
		temp = NULL;
	}
	return 1;
}
