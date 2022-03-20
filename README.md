# Cosc310Group7
##Yeet the dishes chat bot
There is now a basic GUI that has a menu system as well as chat screen.
The chat bot also provides, in the console, data of messages sent.

## External Lib
Lib: https://opennlp.apache.org/
Tutorial: https://www.tutorialspoint.com/opennlp/opennlp_environment.htm

## GUI
The gui is fairly well formated and SHOULD work regardless of the display size.
The gui is full screened and does not have an option for windowed.
the gui does not allow the user to send messages with symbols(+, -, $, &...).

## Data
This data uses the 3 toolkits we implemented.
The first toolkit tokenizes the messages.
The second toolkit adds tags and probabilities to the toolkits.
The third toolkit uses those tags and provides the LEMMA of each word.
