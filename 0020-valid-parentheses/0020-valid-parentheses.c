#include <stdio.h>
#include <stdbool.h>
#include <string.h>

#define MAX_STACK_SIZE 10000

// Stack implementation for storing brackets
char stack[MAX_STACK_SIZE];
int top = -1;

// Push
void push(char c) {
    stack[++top] = c;
}

// Pop
char pop() {
    return stack[top--];
}

// Check empty
bool isEmpty() {
    return top == -1;
}
bool isMatching(char open, char close) {
    return (open == '(' && close == ')') ||
           (open == '{' && close == '}') ||
           (open == '[' && close == ']');
}

// Main validation function
bool isValid(char *s) {
    top = -1; // reset stack

    for (int i = 0; i < strlen(s); i++) {
        char ch = s[i];

        // If opening bracket → push
        if (ch == '(' || ch == '{' || ch == '[') {
            push(ch);
        }
        // If closing bracket
        else {
            if (isEmpty())
                return false;

            char topChar = pop();

            if (!isMatching(topChar, ch))
                return false;
        }
    }

    return isEmpty(); // valid only if stack empty
}