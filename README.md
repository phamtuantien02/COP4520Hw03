# COP4520Hw03
To Compile through CMDPROMPT

Type javac ./Main.java Type java Main This should compile the program and run 5000000 gifts.

Type javac ./TemperatureReading.java Type java TemperatureReading This should compile the program and run 8 sensors.

For the second program the efficiency of it comes from the fact that all of the sensors are going off at the same time 
but there are also locks and systems in place so that the same information is not read over and over again.
The program mimics the hours that passes by as it does a loop to generate the information from that the sensors "read." 
With that in mine we have to make sure that each sensor can read its own information parallel to the other sensors as well.
So when running this program the program completes almost instantly which is good meaning that all the threads are being used
and everything that is used is not interfering with the other programs.

For the minotaur problem the reasoning that the minotaur is losing out on some Thank You gifts is because the remove function where 
the servants are going to be losing on the fact that they are not able to remove something because someone else is already looking at it.
This means that my solution where the lock is implemented better means that they are able to get all 500,000 Thank Yous back to the people.
