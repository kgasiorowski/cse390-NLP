#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

//Represents a unigram, or a word. Has a string 
struct Word{

	string word;
	unsigned int frequency;
	
	Word(): frequency(0) {}
	Word(string s, int f) : word(s), frequency(f) {}

};

//Represents a typical bigram. Has two words, and a frequency denoting how often it appears.
struct Bigram{

	Word *firstWord, *secondWord;
	unsigned int frequency;

	Bigram(): frequency(0) {}
	Bigram(Word *fw, Word *sw, int f): firstWord(fw), secondWord(sw), frequency(f) {}

};


typedef unordered_map<string, Word*> MyMap;

MyMap* computeUnigrams(vector<string>);
