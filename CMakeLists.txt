cmake_minimum_required(VERSION 3.26)
project(DataStructures)

set(CMAKE_CXX_STANDARD 17)

add_executable(DataStructures
        LinkedList/src/LinkedList.h
        LinkedList/src/LinkedList.cpp
        LinkedList/src/LinkedList.cpp
        Stack/src/Stack.h
        Stack/src/Stack.cpp
        Queue/src/Queue.h
        Queue/src/Queue.cpp
        BST/src/BST.h
        BST/src/BST.h)
