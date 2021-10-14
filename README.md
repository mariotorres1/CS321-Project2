# Project #: Project CPU Scheduling using a priority queue

* Author: Mario Torres
* Class: CS321 Section #003
* Semester: Fall 2021

## Overview

Implements a CPU scheduling of processes using a priority queue
technique stored in a max heap. Simulates the priority-based 
round robin scheduling algorithm for assigning a CPU to a 
running process.

## Reflection

First time using any form of heaps in this project so that was 
something new I had to learn more about implementing and then 
implementing it with a process took me a while to figure out. I 
felt pretty confident of implementing it like the textbook had 
of an int array but the process array made it a lot more difficult
for me to picture how to implement the heap and how to go about 
doing that. 

Once I was able to implement the MaxHeap.java class, everything 
kind of fell into place after that. The MyPriorityQueue.java, 
ProcessGenerator.java, and Process.java classes weren't too 
difficult to write. I did have a little hiccup on the update 
method in MyPriorityQueue.java, I was originally reading the 
psuedo-code for the update method and it was saying to decrement
timeRemaining and reset waitingTime before updating the rest of 
processes but I noticed it was already decrementing timeRemaining
in the CPUScheduling.java class and in turn was decrementing the
timeRemaining twice as much. I saw that question asked in Piazza
and saw that we were just to reset the waitingTime in the update
method since it was already decrementing the timeRemaining in the
CPUScheduling.java class. Other than those things, I struggled with
the Test.java class trying to find a efficient way to test my 
maxHeap, it's been awhile since I've written a test class so I 
think I need a refresher on that but I was able to write 3 test
with different processes in a maxHeap and it looked to be performing
how it should. 

## Compiling and Using

This program takes in command line arguments to be run successfully.
The user should input a max-process-time, max priority, 
time-to-increment-priority, simulation-time, process-arrival-
probability, and if they want, they can enter in a seed to keep the 
results the same each time. 

java CPUScheduling [max-process-time] [max-priority] [time-to-
increment-priority] [simulation-time] [process-arrival-probability]
[seed] (optional)

## Results 

We were given a set of inputs with a seed and the corresponding 
output results and my program was matching those results which
leads me to believe that it is running correctly. I also was 
passing the 3 maxHeap tests I created in Test.java to make sure
that was implemented correctly. 

## Sources used

I again used some of my old CS221 coding practices to look up 
techniques I was using in java last time I worked in it. I also
used the textbook for the class to see the psuedo-code for the 
maxHeap methods to implement. I didn't really need to use the 
internet for much this project, I did look at different 
implementations of a maxHeap other than in int form to see if 
they were done the same way. Other than that, I just leaned on 
other classmates and tutors regarding questions I had for this 
project.

----------
This README template is using Markdown. To preview your README output,
you can copy your file contents to a Markdown editor/previewer such
as [https://stackedit.io/editor](https://stackedit.io/editor).
