### if.05.01 TINF Operating Systems

# Assignment 6: Producer Consumer Problem
## Objective
The goal of this week's assignment is to make you familiar with the producer consumer problem.

## Required Task
1. Write a producer-consumer problem that uses threads and shares a common buffer. However, do not use semaphores or any other synchronisation primitives to guard the shared data structures. Just let each thread access them when it wants to. Use sleep and wakeup to handle the full and empty conditions. See how long it takes for a fatal race condition to occur. Take care with printing. Extensive printing on the console might affect the race conditions.
2. Create another NetBeans project to secure the access to the shared buffer using a semaphore
3. Create another NetBeans project so secure the access to the shared buffer using Java synchronized.
