/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */

#include <stdlib.h>
#include <stdbool.h>

#define MAX_VAL 100001

struct TreeNode* newNode(int val) {
    struct TreeNode* node = (struct TreeNode*)malloc(sizeof(struct TreeNode));
    node->val = val;
    node->left = NULL;
    node->right = NULL;
    return node;
}

struct TreeNode* createBinaryTree(int** descriptions, int descriptionsSize, int* descriptionsColSize) {
    struct TreeNode* nodes[MAX_VAL] = {0};
    bool hasParent[MAX_VAL] = {0};

    for (int i = 0; i < descriptionsSize; i++) {
        int parent = descriptions[i][0];
        int child = descriptions[i][1];
        int isLeft = descriptions[i][2];

        if (nodes[parent] == NULL)
            nodes[parent] = newNode(parent);

        if (nodes[child] == NULL)
            nodes[child] = newNode(child);

        if (isLeft)
            nodes[parent]->left = nodes[child];
        else
            nodes[parent]->right = nodes[child];

        hasParent[child] = true;
    }

    for (int i = 0; i < descriptionsSize; i++) {
        int parent = descriptions[i][0];
        if (!hasParent[parent]) {
            return nodes[parent];
        }
    }

    return NULL;
}